package com.hniu.surveypark.service;

import java.util.List;

import com.hniu.surveypark.model.Right;

/**
 * 此类是：权限Service
 * 
 * @author: hpc
 * @version: 2016年12月12日 下午10:38:08
 */
public interface RightService {

	/**
	 * 获取或有的权限
	 */
	public List<Right> getAllRight();

	/**
	 * 保存或更新权限
	 */
	public void saveOrUpdateRight(Right model);

	/**
	 * 获取权限
	 */
	public Right getRight(Right model);

	/**
	 * 通过url获取权限对象
	 */
	public Right getRight(String right_url);

	/**
	 * 编辑权限
	 */
	public void editRight(Right model);

	/**
	 * 获取最大权限位
	 */
	public int getMaxPos();


}
