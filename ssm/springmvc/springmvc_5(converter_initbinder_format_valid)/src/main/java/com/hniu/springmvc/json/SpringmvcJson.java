package com.hniu.springmvc.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hniu.springmvc.bean.Employee;

/**
 * class：This is springmvc json controller 
 * @author hpc
 * @2017年2月26日下午3:09:15
 * 
 *  1 add json jar
 *  2 create handler and response method
 *  3 @ResponseBody of add on the method
 *  4 the statement of the method of return type 
 */
@Controller
public class SpringmvcJson {
	
	
	/**
	 * @ResponseBody 修饰的返回值就代表着，以指定的类型返回到客户端
	 * @RequestBody 修饰的入参表示这，请求参数将转换成指定的类型进入方法	 
	 **/
	@RequestMapping("/springmvcJson")
	public @ResponseBody Employee springmvcJson(){
		System.out.println("springmvcJson");
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("dyn", 21, "women", "dyn@dyn.com"));
		list.add(new Employee("dyn", 22, "women", "dyn@dyn.com"));
		list.add(new Employee("dyn", 23, "women", "dyn@dyn.com"));
		list.add(new Employee("dyn", 24, "women", "dyn@dyn.com"));
		return new Employee("dyn", 24, "women", "dyn@dyn.com");
	}
}
