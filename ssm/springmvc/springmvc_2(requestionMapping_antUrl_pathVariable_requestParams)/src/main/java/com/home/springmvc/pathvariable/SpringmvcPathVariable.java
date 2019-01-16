package com.home.springmvc.pathvariable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * �����ǣ�pathVariable ע�� ��url��ռλ��
 * @author hpc
 * @2017��2��16������11:37:02
 */
@Controller
public class SpringmvcPathVariable {
	// ��Ҫȡ�����ݽ��������������������൱��ռλ���ɡ�{number}
	@RequestMapping("/springmvc/abc/{number}")
	public String antUrl(@PathVariable("number") Integer number) {//�ڷ����������Ҫһ��@PathVariableע�� ��������Ҫȡ�Ǹ�ֵ
		
		System.out.println("PathVariable��"+number);
		return "success";
	}
}
