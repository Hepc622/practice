package com.home.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * �����ǣ�springMVC������@Controller
 * 
 * @author hpc
 * @2017��2��16������4:34:10
 */
//���������Ŀ������ϼ��ϸ�ע��
@Controller 
public class HelloWorld {
	// ���������/helloSpringmvc�ͻ���뵽�÷�������������
	@RequestMapping("/")
	public String helloWorld() {
		System.out.println("hello Spring mvc");
		return "success";// ����Ĭ����ָת�������ҳ��
	}
}
