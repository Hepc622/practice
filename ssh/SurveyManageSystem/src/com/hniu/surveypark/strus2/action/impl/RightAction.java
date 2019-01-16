package com.hniu.surveypark.strus2.action.impl;

import java.util.List;

import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.service.RightService;
import com.hniu.surveypark.strus2.action.BaseAction;

/**
 * �����ǣ�Ȩ��Action
 * 
 * @author: hpc
 * @version: 2016��12��13�� ����4:23:21
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
	 * ȥȨ��ҳ��
	 */
	public String toRight() {
		this.list = rightService.getAllRight();
		return "toRight";
	}

	/**
	 * ȥ���Ȩ��ҳ��
	 */
	public String toAddRight() {
		return "toAddRight";
	}

	/**
	 * ���Ȩ��
	 */
	public String addRight() {
		rightService.saveOrUpdateRight(this.model);
		return "addRight";
	}

	/**
	 * ȥ�༭Ȩ��ҳ��
	 */
	public String toEditRight() {
		// ��ȡ����Ȩ�޶���
		this.model = rightService.getRight(this.model);
		return "toEditRight";
	}

	/**
	 * �༭Ȩ��
	 */
	public String editRight() {
		// ��ȡ����Ȩ�޶���
		rightService.editRight(this.model);
		return "editRight";
	}
}
