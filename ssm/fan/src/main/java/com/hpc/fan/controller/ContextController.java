package com.hpc.fan.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpc.fan.bean.Context;
import com.hpc.fan.bean.Title;

/**
 * class��This is ContextController
 * 
 * @author hpc
 * @2017��3��30������10:19:29
 */
@Controller
@RequestMapping("/context")
public class ContextController extends BaseController {
	@Resource
	private HttpServletRequest request;

	// ����ʵ����
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody int saveContext(@RequestParam("id") int t_id, @RequestParam("contexts") String context) {
		try {
			// ����ʵ����
			contextService.saveContextEntity(new Context(context, new Title(t_id)));
			return 1;// �ɹ�����1
		} catch (Exception e) {
			return 0;// ʧ�ܷ���0
		}
	}

	// ɾ��ʵ����
	@RequestMapping("/delete")
	public @ResponseBody int deleteContext(@RequestParam("id") int cid, @RequestParam("imgUrl") String imgUrl) {
		try {
			Context con = contextService.getContextEntity(false, cid);//��ȡ����
			// ɾ��ʵ����
			contextService.deleteContextEntity(cid);
			String ppath = request.getSession().getServletContext().getRealPath("/");
			File file = new File(ppath + con.getContext_img());
			if (file.isFile()) {
				file.delete();// ɾ���ļ�
				file.getParentFile().delete();// ��ȡ�ļ�����һ���ļ�����ɾ��
			}
			return 1;// �ɹ�����1
		} catch (Exception e) {
			System.out.println(e);
			return 0;// ʧ�ܷ���0
		}
	}
}
