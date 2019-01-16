package com.home.springmvc.sessionAttributes;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * �����ǣ�@SessionAttributes���ڴ��������session��
 * @author hpc
 * @2017��2��17������11:18:28
 */
@SessionAttributes("name")
@Controller
public class SpringmvcSessionAttributes {
	/**
	 * @SessionAttributes ���˿���ͨ��������ָ����Ҫ�ŵ��Ự�е�������(ʵ����ʹ�õ��� value ����ֵ),
	 * ������ͨ��ģ�����ԵĶ�������ָ����Щģ��������Ҫ�ŵ��Ự��(ʵ����ʹ�õ��� types ����ֵ)
	 * 
	 * ע��: ��ע��ֻ�ܷ����������. ���������ηŷ���. 
	 */
	@RequestMapping("/springmvcSessionAttributes")
	public String springmvcSessionAttributes(Map<String,Object> map){
		map.put("name", "dynltx");
		return "success";
	}
	
}
