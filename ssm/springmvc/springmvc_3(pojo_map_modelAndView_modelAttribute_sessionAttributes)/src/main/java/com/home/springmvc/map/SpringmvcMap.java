package com.home.springmvc.map;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * �����ǣ�Map��������
 * 
 * @author hpc
 * @2017��2��17������7:42:53
 */
@Controller
public class SpringmvcMap {
	@RequestMapping("/springmvcMap")
	public String springmvcMap(Map<String, Object> map) {
		// ��map�ᱻ���뵽request����ȥ
		map.put("name", "hpc");
		return "success";
	}
}
