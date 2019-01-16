package com.hniu.surveypark.service;

import java.util.List;

import com.hniu.surveypark.model.Right;

/**
 * �����ǣ�Ȩ��Service
 * 
 * @author: hpc
 * @version: 2016��12��12�� ����10:38:08
 */
public interface RightService {

	/**
	 * ��ȡ���е�Ȩ��
	 */
	public List<Right> getAllRight();

	/**
	 * ��������Ȩ��
	 */
	public void saveOrUpdateRight(Right model);

	/**
	 * ��ȡȨ��
	 */
	public Right getRight(Right model);

	/**
	 * ͨ��url��ȡȨ�޶���
	 */
	public Right getRight(String right_url);

	/**
	 * �༭Ȩ��
	 */
	public void editRight(Right model);

	/**
	 * ��ȡ���Ȩ��λ
	 */
	public int getMaxPos();


}
