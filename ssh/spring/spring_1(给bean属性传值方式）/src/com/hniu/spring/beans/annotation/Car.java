package com.hniu.spring.beans.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


//@Component("name") 可以通过name获取该对象,基本注解
//@Repository	标识持久层组件
//@Service	标识服务层
@Controller("c") //标识表现层
public class Car {
	@Autowired
	private Person p;
	public void getCar() {
		System.out.println("被调用。。。。"+p+"被引用。");
	}
}
 
