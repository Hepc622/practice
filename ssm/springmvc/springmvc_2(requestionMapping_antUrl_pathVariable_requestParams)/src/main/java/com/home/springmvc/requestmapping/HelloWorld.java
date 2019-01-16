package com.home.springmvc.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * �����ǣ�springMVC������@Controller
 * 
 * @author hpc
 * @2017��2��16������4:34:10
 */
@Controller
public class HelloWorld {
	/**
	 * @return
	 * requestMapping����ע���ڷ�����Ҳ����ע�������ϡ�
	 * 1.ע���ڷ����ϣ��൱һ���ţ��������ҵ���
	 * 2.ע�������ϣ��൱�ڽ���������ӵ���
	 * 
	 * 3.����ӳ��url�⻹���Խ���
	 * 	1.���󷽷�@RequestMapping(method=RequestMothod.POST|RequestMothod.GET)
	 * 	2.�������@RequestMapping(params="hpc")
	 * 	3.����ͷӳ������@RequestMapping(headers="contextType=text/*")
	 */
	@RequestMapping("/helloSpringmvc")
	public String helloWorld() {
		System.out.println("hello Spring mvc");
		return "success";
	}
	
	/**
	 * get��ʽ����
	 */
	@RequestMapping(value="/methodRequest",method=RequestMethod.GET)
	public String method(){
		System.out.println("get��ʽ����");
		return "success";
	}
	/**
	 * post��ʽ����
	 */
	@RequestMapping(value="/methodRequest",method=RequestMethod.POST)
	public String method2(){
		System.out.println("post��ʽ����");
		return "success";
	}
	/**
	 * put ���·�ʽ
	 */
	@RequestMapping(value="/putRequest/{put}",method=RequestMethod.PUT)
	public String put(@PathVariable Integer put){
		System.out.println("����"+put);
		return "success";
	}
	/**
	 * delete ɾ����ʽ
	 */
	@RequestMapping(value="/deleteRequest/{delete}",method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer delete){
		System.out.println("ɾ��"+delete);
		return "success";
	}
	/**
	 * params��ʽ����
	 */
	@RequestMapping(value="/paramsRequest",params={"userName=hpc","age!=40"})
	public String params(){
		System.out.println("params��ʽ����");
		return "success";
	}
}
