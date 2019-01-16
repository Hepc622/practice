package com.hniu.surveypark.strus2.action.impl;

import java.util.List;

import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.service.RightService;
import com.hniu.surveypark.strus2.action.BaseAction;

/**
 * 此类是：权限Action
 * 
 * @author: hpc
 * @version: 2016年12月13日 下午4:23:21
 */
public class RightAction extends BaseAction<Right> {

	private static final long serialVersionUID = -7258398211329678019L;
	private RightService rightService;
	private List<Right> list;

	public List<Right> getList() {
		return list;
	}

	public void setRightService(RightService rightService) {
		this.rightService = rightService;
	}

	/**
	 * 去权限页面
	 */
	public String toRight() {
		this.list = rightService.getAllRight();
		return "toRight";
	}

	/**
	 * 去添加权限页面
	 */
	public String toAddRight() {
		return "toAddRight";
	}

	/**
	 * 添加权限
	 */
	public String addRight() {
		rightService.saveOrUpdateRight(this.model);
		return "addRight";
	}

	/**
	 * 去编辑权限页面
	 */
	public String toEditRight() {
		// 获取出来权限对象
		this.model = rightService.getRight(this.model);
		return "toEditRight";
	}

	/**
	 * 编辑权限
	 */
	public String editRight() {
		// 获取出来权限对象
		rightService.editRight(this.model);
		return "editRight";
	}
}
