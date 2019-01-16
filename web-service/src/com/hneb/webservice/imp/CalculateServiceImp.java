package com.hneb.webservice.imp;

import javax.jws.WebService;

import com.hneb.webservice.bean.User;
import com.hneb.webservice.service.CalculateService;

/**
 * @author hpc 
 * 2017��7��21�� ����5:55:11
 */
@WebService(endpointInterface="com.hneb.webservice.service.CalculateService")
// ��ʵ�����϶���WebServiceע������Ӳ���endpointInterfaceָ����Ҫ���⿪���Ľӿ�(endpointInterface="xxx.xxx.Xxx")
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
