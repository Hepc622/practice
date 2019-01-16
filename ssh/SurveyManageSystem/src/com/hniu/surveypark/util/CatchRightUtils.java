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
 * �����ǣ���ȡ���е�Ȩ��
 * 
 * @author: hpc
 * @version: 2016��12��14�� ����8:39:31
 */
public class CatchRightUtils {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		// �õ�spring ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext*.xml");
		RightService rightService = (RightService) ac.getBean("rightServiceImpl");
		// ��ȡ�������
		ClassLoader cl = CatchRightUtils.class.getClassLoader();
		// ��ȡurl����
		URL resource = cl.getResource("com/hniu/surveypark/strus2/action/impl");
		File file = new File(resource.toURI());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				String name = f.getName();
				if (ValidateUtil.isEmpty(name) && name.contains(".class")) {
					name = name.substring(0, name.indexOf(".class"));
					// ͨ�������õ����е������֣���ͨ�������õ����еķ���
					Class<?> clazz = Class.forName("com.hniu.surveypark.strus2.action.impl." + name);
					// ��ȡ���еķ���
					Method[] methods = clazz.getDeclaredMethods();
					for (Method method : methods) {
						// ��ȡ���η�
						int modifiers = method.getModifiers();
						// ��ȡ��������
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
