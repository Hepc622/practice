package com.hniu.springmvc.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hniu.springmvc.bean.Employee;

/**
 * class��This is springmvc json controller 
 * @author hpc
 * @2017��2��26������3:09:15
 * 
 *  1 add json jar
 *  2 create handler and response method
 *  3 @ResponseBody of add on the method
 *  4 the statement of the method of return type 
 */
@Controller
public class SpringmvcJson {
	
	
	/**
	 * @ResponseBody ���εķ���ֵ�ʹ����ţ���ָ�������ͷ��ص��ͻ���
	 * @RequestBody ���ε���α�ʾ�⣬���������ת����ָ�������ͽ��뷽��	 
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
