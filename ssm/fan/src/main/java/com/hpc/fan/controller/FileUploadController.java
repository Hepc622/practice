package com.hpc.fan.controller;

import java.io.File;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hpc.fan.bean.Context;
import com.hpc.fan.bean.Product;
import com.hpc.fan.bean.Title;

/**
 * class��This is FileUploadController
 * 
 * @author hpc
 * @2017��3��18������9:48:52
 */
@Controller
public class FileUploadController extends BaseController {
	@Resource
	private HttpServletRequest request;

	/***
	 * �ϴ��ļ� ��@RequestParamע����ָ�����ϵ�fileΪMultipartFile
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/upload/fileUpload", method = RequestMethod.POST)
	public @ResponseBody String fileUpload(@RequestParam("file") MultipartFile file) {
		Calendar c = Calendar.getInstance();
		// ԭʼ����
		String filename = file.getOriginalFilename();
		// ��Ŀ·��
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		// �ļ�url·��
		String filePath = "/fileUpload/general/" + c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/"
				+ c.get(Calendar.DAY_OF_MONTH) + "/";
		// ͼƬ����
		String imgName = c.getTimeInMillis() + filename.substring(filename.indexOf("."));
		return saveFile(file, projectPath, filePath, imgName);
	}

	/**
	 * �ϴ�����֤��
	 * 
	 * @param file
	 * @param id
	 *            ����id
	 */
	@RequestMapping(value = "/upload/honorImg", method = RequestMethod.POST)
	public @ResponseBody int addHonor(@RequestParam("file") MultipartFile file,
			@RequestParam(value = "id", required = true) int id, @RequestParam("title") String honorTitle) {
		Calendar c = Calendar.getInstance();
		// ԭʼ����
		String filename = file.getOriginalFilename();
		// ��Ŀ·��
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		// �ļ�url·��
		String filePath = "/fileUpload/honorBook/" + c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/"
				+ c.get(Calendar.DAY_OF_MONTH) + "/";
		String imgName = c.getTimeInMillis() + filename.substring(filename.indexOf("."));
		String imgUrl = saveFile(file, projectPath, filePath, imgName);
		// �������ݱ���
		try {
			// ����ʵ����
			contextService.saveContextEntity(new Context(imgUrl, honorTitle, new Title(id)));
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			mv.setViewName("input");
			return 0;
		}
	}

	/**
	 * �ϴ�����
	 * 
	 * @param file
	 * @param id
	 *            ����id
	 */
	@RequestMapping(value = "/upload/news", method = RequestMethod.POST)
	public @ResponseBody int uploadNews(@RequestParam("file") MultipartFile file,
			@RequestParam(value = "id", required = true) int id, @RequestParam("title") String title,
			@RequestParam("ctext") String context) {
		Calendar c = Calendar.getInstance();
		// ԭʼ����
		String filename = file.getOriginalFilename();
		// ��Ŀ·��
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		// �ļ�url·��
		String filePath = "/fileUpload/news/" + c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/"
				+ c.get(Calendar.DAY_OF_MONTH) + "/";
		String imgName = c.getTimeInMillis() + filename.substring(filename.indexOf("."));
		String imgUrl = saveFile(file, projectPath, filePath, imgName);
		// �������ݱ���
		try {
			// ����ʵ����
			contextService.saveContextEntity(new Context(imgUrl, title, context, new Title(id)));
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			mv.setViewName("input");
			return 0;
		}
	}

	/**
	 * �ϴ���Ŀ
	 * 
	 * @param file
	 * @param id
	 *            ����id
	 */
	@RequestMapping(value = "/upload/project", method = RequestMethod.POST)
	public @ResponseBody int uploadProject(@RequestParam("file") MultipartFile file,
			@RequestParam(value = "id", required = true) int id, @RequestParam("title") String title,
			@RequestParam("ctext") String context) {
		Calendar c = Calendar.getInstance();
		// ԭʼ����
		String filename = file.getOriginalFilename();
		// ��Ŀ·��
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		// �ļ�url·��
		String filePath = "/fileUpload/project/" + c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/"
				+ c.get(Calendar.DAY_OF_MONTH) + "/";
		String imgName = c.getTimeInMillis() + filename.substring(filename.indexOf("."));
		String imgUrl = saveFile(file, projectPath, filePath, imgName);
		// �������ݱ���
		try {
			// ����ʵ����
			contextService.saveContextEntity(new Context(imgUrl, title, context, new Title(id)));
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			mv.setViewName("input");
			return 0;
		}
	}

	/**
	 * �ϴ���Ŀ
	 * 
	 * @param p_image
	 * @param id
	 *            ����id
	 */
	@RequestMapping(value = "/upload/product", method = RequestMethod.POST)
	public @ResponseBody int uploadProduct(@RequestParam("p_image") MultipartFile[] p_image,
			@RequestParam(value = "id", required = true) int id, @RequestParam("p_name") String p_name,
			@RequestParam("p_specification") String p_specification, @RequestParam("p_parameter") String p_parameter,
			@RequestParam("p_type") String p_type) {
		Calendar c = Calendar.getInstance();
		String imgUrl = "";
		int index=0;
		for (MultipartFile file : p_image) {
			// ԭʼ����
			String filename = file.getOriginalFilename();
			// ��Ŀ·��
			String projectPath = request.getSession().getServletContext().getRealPath("/");
			// �ļ�url·��
			String filePath = "/fileUpload/product/" + c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/"
					+ c.get(Calendar.DAY_OF_MONTH) + "/";
			String imgName = (c.getTimeInMillis()+ ++index) + filename.substring(filename.indexOf("."));
			imgUrl += saveFile(file, projectPath, filePath, imgName) + ",";
		}
		// �������ݱ���
		try {
			// ����ʵ����
			productService.saveProductEntity(
					new Product(p_name, p_type, p_specification, p_parameter, imgUrl, new Title(id)), imgUrl);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			mv.setViewName("input");
			return 0;
		}
	}

	/**
	 * �����ļ�
	 */
	private String saveFile(MultipartFile file, String projectPath, String filePath, String imgName) {
		// �ж��ļ��Ƿ�Ϊ��
		if (!file.isEmpty()) {
			try {
				// �����ļ�
				File f = new File(projectPath + filePath);
				// �ж��ļ��Ƿ����
				if (!f.exists()) {
					f.mkdirs();
				}
				// ת���ļ�
				file.transferTo(new File(f, imgName));
				// �����ļ�url
				return filePath + imgName;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
}
