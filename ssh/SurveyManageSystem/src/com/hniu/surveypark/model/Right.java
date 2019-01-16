package com.hniu.surveypark.model;

/**
 * 此类是：权限
 * 
 * @author: hpc
 * @version: 2016年12月12日 下午3:52:38
 */
public class Right {
	private Integer right_id;
	private String right_name = "未命名";
	private String right_url;
	private String right_desc;
	private Long right_code = 0l;
	private Integer right_pos = 0;// 权限位，相当于对权限分组，从0开始
	private boolean right_open;

	public Right() {
	}

	public Right(String right_url) {
		super();
		this.right_url = right_url;
	}

	public Integer getRight_id() {
		return right_id;
	}

	public void setRight_id(Integer right_id) {
		this.right_id = right_id;
	}

	public String getRight_name() {
		return right_name;
	}

	public void setRight_name(String right_name) {
		this.right_name = right_name;
	}

	public String getRight_url() {
		return right_url;
	}

	public void setRight_url(String right_url) {
		this.right_url = right_url;
	}

	public String getRight_desc() {
		return right_desc;
	}

	public void setRight_desc(String right_desc) {
		this.right_desc = right_desc;
	}

	public Long getRight_code() {
		return right_code;
	}

	public void setRight_code(Long right_code) {
		this.right_code = right_code;
	}

	public Integer getRight_pos() {
		return right_pos;
	}

	public void setRight_pos(Integer right_pos) {
		this.right_pos = right_pos;
	}

	public boolean getRight_open() {
		return right_open;
	}

	public void setRight_open(boolean right_open) {
		this.right_open = right_open;
	}

}
