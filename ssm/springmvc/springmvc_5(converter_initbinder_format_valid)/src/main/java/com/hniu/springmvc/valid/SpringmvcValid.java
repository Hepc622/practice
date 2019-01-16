package com.hniu.springmvc.valid;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hniu.springmvc.bean.Employee;

/**
 * class：This is Springmvc valid Test controller
 * 
 * @author hpc
 * @2017年2月24日下午4:11:40
 */
@Controller
@RequestMapping("/")
public class SpringmvcValid {
	@RequestMapping("springmvcValid")
	public String springmvcValid(@Valid Employee employee, Errors errors) {
		// get it of error field count
		int fieldErrorCount = errors.getFieldErrorCount();
		// redirct to index if fieldErrorCount > 0
		if (fieldErrorCount > 0) {
			// get it of error field,this method have a return value of
			// FieldError class
			errors.getFieldError().getField();
			// geting all field of errors,return a List of field error
			for (FieldError fe : errors.getFieldErrors()) {
				System.out.println(fe.getField() + ":" + fe.getDefaultMessage());
			}

			return "input";
		}
		return "success";
	}
	@RequestMapping("input")
	public String input(Map<String,Employee> map){
		map.put("employee", new Employee());
		return "input";
	}
}
