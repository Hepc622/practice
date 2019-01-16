package com.hniu.spring.jdbcTemplate;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class NamedParameterJdbcTmplateTest {
	NamedParameterJdbcTemplate npjt = null;
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-jdbc.xml");
		npjt = (NamedParameterJdbcTemplate) ac
				.getBean("namedParameterJdbcTemplate");
	}
	/**
	 *	具名参数一类型形式进行插入数据（参数名字必须与类的名字一样，才能进行输入插入）
	 *	参数  :xxx要与类的属性一样 类属性xxx
	 *	优点
	 *		1 比单个数据插入要便捷，数据清晰
	 *		2 减少代码量便于维护
	 */
	@Test
	public void getUser2(){
		String sql = "INSERT INTO USERINFO (USER_ID,USER_CAR,USER_NAME,USER_PWD)VALUES(DEFAULT,DEFAULT,:user_Name,:user_Pwd)";
		User user = new User("LS","LS123");
		System.out.println(user);
		SqlParameterSource paraMap = new BeanPropertySqlParameterSource(user);
		npjt.update(sql, paraMap );
	}
	/** 
	 * 具名参数jdbc
	 * 	好处
	 * 		1  便于维护sql代码，如果是？号形式的参数就多了就会造成参数混乱
	 * 		2  参数对比清晰
	 * 	坏处
	 * 		1  比以前的麻烦些，代码量增多
	 */
	@Test
	public void getUser(){
		String sql = "INSERT INTO USERINFO (USER_ID,USER_CAR,USER_NAME,USER_PWD)VALUES(DEFAULT,DEFAULT,:NAME,:PWD)";
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("NAME", "ZS");
		paraMap.put("PWD", "ZS123");
		npjt.update(sql, paraMap);
	}
}
