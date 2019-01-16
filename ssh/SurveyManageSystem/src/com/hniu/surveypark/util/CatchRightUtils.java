package com.hniu.surveypark.util;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.service.RightService;

/**
 * 此类是：获取所有的权限
 * 
 * @author: hpc
 * @version: 2016年12月14日 下午8:39:31
 */
public class CatchRightUtils {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		// 拿到spring 容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext*.xml");
		RightService rightService = (RightService) ac.getBean("rightServiceImpl");
		// 获取类加载器
		ClassLoader cl = CatchRightUtils.class.getClassLoader();
		// 获取url对象
		URL resource = cl.getResource("com/hniu/surveypark/strus2/action/impl");
		File file = new File(resource.toURI());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				String name = f.getName();
				if (ValidateUtil.isEmpty(name) && name.contains(".class")) {
					name = name.substring(0, name.indexOf(".class"));
					// 通过反射拿到所有的类名字，在通过反射拿到所有的方法
					Class<?> clazz = Class.forName("com.hniu.surveypark.strus2.action.impl." + name);
					// 获取所有的方法
					Method[] methods = clazz.getDeclaredMethods();
					for (Method method : methods) {
						// 获取修饰符
						int modifiers = method.getModifiers();
						// 获取返回类型
						Class<?> type = method.getReturnType();
						if (Modifier.isPublic(modifiers) && type == String.class) {
							String url;
							if (method.getName().equals("execute")) {
								url = "/" + name;
							} else {
								url = "/" + "Sms_" + name.toLowerCase().substring(0, 2) + "_" + method.getName();
							}
							Right r = new Right();
							r.setRight_url(url);
							rightService.saveOrUpdateRight(r);
						}
					}
				}
			}
		}
	}
}
