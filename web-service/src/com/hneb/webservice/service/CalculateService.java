package com.hneb.webservice.service;

import javax.jws.WebService;

import com.hneb.webservice.bean.User;

/**
 * @author hpc 
 * 2017年7月21日 下午5:48:58
 */
@WebService   //在服务类上定义WebService注解
public interface CalculateService {
	/**加法运算
	 * @param x 
	 * @param y
	 * @return int数值
	 */
	public int add(int x,int y);
	
	/** 减法运算
	 * @param x 减数
	 * @param y 被减数
	 * @return int数值
	 */
	public int subtract(int x,int y);
	
	/**获取user对象
	 * @param userId
	 * @return USER 对象
	 */
	public User getUser(String userId);
}
