package com.home.springmvc.pathvariable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 此类是：pathVariable 注解 绑定url的占位符
 * @author hpc
 * @2017年2月16日下午11:37:02
 */
@Controller
public class SpringmvcPathVariable {
	// 你要取的数据将它用中括号括起来，相当于占位符吧。{number}
	@RequestMapping("/springmvc/abc/{number}")
	public String antUrl(@PathVariable("number") Integer number) {//在方法的入参需要一个@PathVariable注解 告诉它你要取那个值
		
		System.out.println("PathVariable："+number);
		return "success";
	}
}
