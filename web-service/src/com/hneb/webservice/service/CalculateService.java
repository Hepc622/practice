package com.hneb.webservice.service;

import javax.jws.WebService;

import com.hneb.webservice.bean.User;

/**
 * @author hpc 
 * 2017��7��21�� ����5:48:58
 */
@WebService   //�ڷ������϶���WebServiceע��
public interface CalculateService {
	/**�ӷ�����
	 * @param x 
	 * @param y
	 * @return int��ֵ
	 */
	public int add(int x,int y);
	
	/** ��������
	 * @param x ����
	 * @param y ������
	 * @return int��ֵ
	 */
	public int subtract(int x,int y);
	
	/**��ȡuser����
	 * @param userId
	 * @return USER ����
	 */
	public User getUser(String userId);
}
