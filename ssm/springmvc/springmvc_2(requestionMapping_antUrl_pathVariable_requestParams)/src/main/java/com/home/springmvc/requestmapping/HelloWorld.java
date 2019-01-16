package com.home.springmvc.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 此类是：springMVC控制类@Controller
 * 
 * @author hpc
 * @2017年2月16日下午4:34:10
 */
@Controller
public class HelloWorld {
	/**
	 * @return
	 * requestMapping集合注解在方法上也可以注解在类上。
	 * 1.注解在方法上，相当一个门，进入卧室的门
	 * 2.注解在类上，相当于进入这个房子的门
	 * 
	 * 3.除了映射url外还可以进行
	 * 	1.请求方法@RequestMapping(method=RequestMothod.POST|RequestMothod.GET)
	 * 	2.请求参数@RequestMapping(params="hpc")
	 * 	3.请求头映射请求@RequestMapping(headers="contextType=text/*")
	 */
	@RequestMapping("/helloSpringmvc")
	public String helloWorld() {
		System.out.println("hello Spring mvc");
		return "success";
	}
	
	/**
	 * get方式请求
	 */
	@RequestMapping(value="/methodRequest",method=RequestMethod.GET)
	public String method(){
		System.out.println("get方式请求");
		return "success";
	}
	/**
	 * post方式请求
	 */
	@RequestMapping(value="/methodRequest",method=RequestMethod.POST)
	public String method2(){
		System.out.println("post方式请求");
		return "success";
	}
	/**
	 * put 更新方式
	 */
	@RequestMapping(value="/putRequest/{put}",method=RequestMethod.PUT)
	public String put(@PathVariable Integer put){
		System.out.println("更新"+put);
		return "success";
	}
	/**
	 * delete 删除方式
	 */
	@RequestMapping(value="/deleteRequest/{delete}",method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer delete){
		System.out.println("删除"+delete);
		return "success";
	}
	/**
	 * params方式请求
	 */
	@RequestMapping(value="/paramsRequest",params={"userName=hpc","age!=40"})
	public String params(){
		System.out.println("params方式请求");
		return "success";
	}
}
