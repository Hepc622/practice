package com.home.springmvc.pojo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.bean.User;

/**
 * �����ǣ�springmvc pojo 
 * @author hpc
 * @2017��2��17������7:01:04
 */
@Controller
public class SpringmvcPojo {
	
	/**
	 * ֱ�ӽ����е�����ӳ�䵽User��ȥ
	 * 	֧�ּ���ӳ��
	 * �����ֱ�����pojo����һֱ
	 */
	@RequestMapping("/springmvcPojo")
	public String springmvcPojo(User user){
		System.out.println(user);
		return "success";
	}
}
