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
 * class：This is ProductController
 * 
 * @author hpc
 * @2017年3月21日下午5:25:18
 */
/**
 * class：This is
 * 
 * @author hpc
 * @2017年4月9日下午10:20:39
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
	 * 所有的子标题
	 */
	@RequestMapping("/{title}")
	public ModelAndView title(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "page", required = false) Integer targetPage) {
		// 初始化 分页实体类
		Page page = new Page(productService.getProductCount(id));
		page.setEveryPage(9);
		// 目标页不等于空
		page.setCurrentPage(targetPage);
		// 获取指定页数据
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
		// 当前数据
		Product pcurrent = productService.getProductEntity(false, pid);
		// 获取它的后一条数据
		Product pafter = productService.getProductBeforeOrAfter(2, pcurrent.getParent_title().getTitle_id(), pid);
		// 获取它的前一条数据
		Product pbefore = productService.getProductBeforeOrAfter(1, pcurrent.getParent_title().getTitle_id(), pid);
		// initData(int id) 当从首页点击产品的时候需要再次初始化页面数据
		initData(5, pcurrent.getParent_title().getTitle_id());
		mv.addObject("cafter", pafter);
		mv.addObject("ccurrent", pcurrent);
		mv.addObject("cbefore", pbefore);
		mv.setViewName("company_context");
		return mv;
	}

	/**
	 * 初始化product的single点击进入的product数据页数据
	 * 
	 * @param id
	 */
	private void initData(int id, int c_id) {
		// 获取指定id的导航类
		Navigation nav = navigationService.getNavigationEntity(id);
		// 获取指定id导航类的子类
		List<Title> titles = titleService.getAllTitleEntity(nav.getNavigation_id());
		// 当前标题栏对象
		Title title = null;
		for (Title t : titles) {
			if (t.getTitle_id() == c_id) {
				title = t;// 将指定的标题id拿出来
			}
		}
		// t_id 用于获取当前标题下的所有产品，用于分页
		if (title == null) {
			title = titles.get(c_id);// 如果是空的话就获取导航行栏的第一个子标题栏的id
			mv.addObject("title", title);
		} else {
			mv.addObject("title", title);// 将当前的标题栏对象存入request中
		}
		// 初始化 分页实体类
		Page page = new Page(productService.getProductCount(title.getTitle_id()));
		page.setEveryPage(9);
		// 获取第一个标题之内容
		List<Product> products = productService.getAllProductEntity(title.getTitle_id(),
				page.getBeginIndex() >= 0 ? page.getBeginIndex() : 0, page.getEveryPage());
		// 设置到request中
		mv.addObject("nav", nav);
		mv.addObject("titles", titles);
		// 获取之标题栏的第一个子内容
		mv.addObject("pros", products);
		mv.addObject("page", page);

		mv.setViewName("company_product");
	}

	// 保存实体类
	@RequestMapping("/delete")
	public @ResponseBody int deleteProduct(@RequestParam("id") int pid, @RequestParam("imgUrl") String imgUrl) {
		try {
			Product p = productService.getProductEntity(false, pid);// 获取对应的实体类
			// 删除实体类
			productService.deleteProductEntity(pid);
			String ppath = request.getSession().getServletContext().getRealPath("/");
			for (String img : p.getPro_image()) {//循环删除
				File file = new File(ppath + img);
				if (file.isFile()) {
					file.delete();// 删除文件
					file.getParentFile().delete();// 获取文件的上一级文件进行删除
				}
			}
			return 1;// 成功返回1
		} catch (Exception e) {
			System.out.println(e);
			return 0;// 失败返回0
		}
	}

}
