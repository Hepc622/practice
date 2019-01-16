package com.hpc.fan.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hpc.fan.bean.Navigation;
import com.hpc.fan.bean.Page;
import com.hpc.fan.bean.Product;
import com.hpc.fan.bean.Title;

/**
 * class��This is ProductController
 * 
 * @author hpc
 * @2017��3��21������5:25:18
 */
/**
 * class��This is
 * 
 * @author hpc
 * @2017��4��9������10:20:39
 */
@Controller
@RequestMapping("/product")
@SessionAttributes(value = { "nav", "titles" })
public class ProductController extends BaseController {
	@Resource
	private HttpServletRequest request;

	@RequestMapping("")
	public ModelAndView product(@RequestParam("id") int id,
			@RequestParam(value = "page", required = false) Integer targetPage) {
		initData(id, 0);
		return mv;
	}

	/**
	 * ���е��ӱ���
	 */
	@RequestMapping("/{title}")
	public ModelAndView title(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "page", required = false) Integer targetPage) {
		// ��ʼ�� ��ҳʵ����
		Page page = new Page(productService.getProductCount(id));
		page.setEveryPage(9);
		// Ŀ��ҳ�����ڿ�
		page.setCurrentPage(targetPage);
		// ��ȡָ��ҳ����
		List<Product> pros = productService.getAllProductEntity(id,
				page.getBeginIndex() >= 0 ? page.getBeginIndex() : 0, page.getEveryPage());
		mv.addObject("page", page);
		mv.addObject("title", titleService.getTitleEntity(id));
		mv.addObject("pros", pros);
		mv.setViewName("company_product");
		return mv;
	}

	@RequestMapping("/single")
	public ModelAndView single(@RequestParam(value = "id", required = true) Integer pid) {
		// ��ǰ����
		Product pcurrent = productService.getProductEntity(false, pid);
		// ��ȡ���ĺ�һ������
		Product pafter = productService.getProductBeforeOrAfter(2, pcurrent.getParent_title().getTitle_id(), pid);
		// ��ȡ����ǰһ������
		Product pbefore = productService.getProductBeforeOrAfter(1, pcurrent.getParent_title().getTitle_id(), pid);
		// initData(int id) ������ҳ�����Ʒ��ʱ����Ҫ�ٴγ�ʼ��ҳ������
		initData(5, pcurrent.getParent_title().getTitle_id());
		mv.addObject("cafter", pafter);
		mv.addObject("ccurrent", pcurrent);
		mv.addObject("cbefore", pbefore);
		mv.setViewName("company_context");
		return mv;
	}

	/**
	 * ��ʼ��product��single��������product����ҳ����
	 * 
	 * @param id
	 */
	private void initData(int id, int c_id) {
		// ��ȡָ��id�ĵ�����
		Navigation nav = navigationService.getNavigationEntity(id);
		// ��ȡָ��id�����������
		List<Title> titles = titleService.getAllTitleEntity(nav.getNavigation_id());
		// ��ǰ����������
		Title title = null;
		for (Title t : titles) {
			if (t.getTitle_id() == c_id) {
				title = t;// ��ָ���ı���id�ó���
			}
		}
		// t_id ���ڻ�ȡ��ǰ�����µ����в�Ʒ�����ڷ�ҳ
		if (title == null) {
			title = titles.get(c_id);// ����ǿյĻ��ͻ�ȡ���������ĵ�һ���ӱ�������id
			mv.addObject("title", title);
		} else {
			mv.addObject("title", title);// ����ǰ�ı������������request��
		}
		// ��ʼ�� ��ҳʵ����
		Page page = new Page(productService.getProductCount(title.getTitle_id()));
		page.setEveryPage(9);
		// ��ȡ��һ������֮����
		List<Product> products = productService.getAllProductEntity(title.getTitle_id(),
				page.getBeginIndex() >= 0 ? page.getBeginIndex() : 0, page.getEveryPage());
		// ���õ�request��
		mv.addObject("nav", nav);
		mv.addObject("titles", titles);
		// ��ȡ֮�������ĵ�һ��������
		mv.addObject("pros", products);
		mv.addObject("page", page);

		mv.setViewName("company_product");
	}

	// ����ʵ����
	@RequestMapping("/delete")
	public @ResponseBody int deleteProduct(@RequestParam("id") int pid, @RequestParam("imgUrl") String imgUrl) {
		try {
			Product p = productService.getProductEntity(false, pid);// ��ȡ��Ӧ��ʵ����
			// ɾ��ʵ����
			productService.deleteProductEntity(pid);
			String ppath = request.getSession().getServletContext().getRealPath("/");
			for (String img : p.getPro_image()) {//ѭ��ɾ��
				File file = new File(ppath + img);
				if (file.isFile()) {
					file.delete();// ɾ���ļ�
					file.getParentFile().delete();// ��ȡ�ļ�����һ���ļ�����ɾ��
				}
			}
			return 1;// �ɹ�����1
		} catch (Exception e) {
			System.out.println(e);
			return 0;// ʧ�ܷ���0
		}
	}

}
