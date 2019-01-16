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
 * class：This is ContextController
 * 
 * @author hpc
 * @2017年3月30日下午10:19:29
 */
@Controller
@RequestMapping("/context")
public class ContextController extends BaseController {
	@Resource
	private HttpServletRequest request;

	// 保存实体类
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody int saveContext(@RequestParam("id") int t_id, @RequestParam("contexts") String context) {
		try {
			// 保存实体类
			contextService.saveContextEntity(new Context(context, new Title(t_id)));
			return 1;// 成功返回1
		} catch (Exception e) {
			return 0;// 失败返回0
		}
	}

	// 删除实体类
	@RequestMapping("/delete")
	public @ResponseBody int deleteContext(@RequestParam("id") int cid, @RequestParam("imgUrl") String imgUrl) {
		try {
			Context con = contextService.getContextEntity(false, cid);//获取对象
			// 删除实体类
			contextService.deleteContextEntity(cid);
			String ppath = request.getSession().getServletContext().getRealPath("/");
			File file = new File(ppath + con.getContext_img());
			if (file.isFile()) {
				file.delete();// 删除文件
				file.getParentFile().delete();// 获取文件的上一级文件进行删除
			}
			return 1;// 成功返回1
		} catch (Exception e) {
			System.out.println(e);
			return 0;// 失败返回0
		}
	}
}
