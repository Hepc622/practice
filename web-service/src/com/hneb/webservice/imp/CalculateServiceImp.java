package com.hneb.webservice.imp;

import javax.jws.WebService;

import com.hneb.webservice.bean.User;
import com.hneb.webservice.service.CalculateService;

/**
 * @author hpc 
 * 2017年7月21日 下午5:55:11
 */
@WebService(endpointInterface="com.hneb.webservice.service.CalculateService")
// 在实现类上定义WebService注解且添加参数endpointInterface指定你要对外开发的接口(endpointInterface="xxx.xxx.Xxx")
public class CalculateServiceImp implements CalculateService {

	@Override
	public int add(int x, int y) {
		return x+y;
	}

	@Override
	public int subtract(int x, int y) {
		return x-y;
	}

	@Override
	public User getUser(String userId) {
		return new User(userId, "hpc", "pwd");
	}

}
