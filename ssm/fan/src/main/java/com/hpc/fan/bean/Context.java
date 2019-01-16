package com.hpc.fan.bean;

import java.util.Date;

/**
 * class��This is Context
 * 
 * @author hpc
 * @2017��3��14������3:50:39
 */
public class Context {
	private Integer context_id;
	private String context_img;
	private String context_text;
	private String context_title;
	private Date context_date;
	private Title parent_title;


	public String getContext_title() {
		return context_title;
	}

	public void setContext_title(String context_title) {
		this.context_title = context_title;
	}

	public Date getContext_date() {
		return context_date;
	}

	public void setContext_date(Date context_date) {
		this.context_date = context_date;
	}

	public Context() {
	}

	/**
	 * ������ͨ��context��
	 * 
	 * @param context_text
	 *            ����
	 * @param parent_title
	 *            �����id new Title(id);
	 */
	public Context(String context_text, Title parent_title) {
		this.context_text = context_text;
		this.parent_title = parent_title;
		this.context_date = new Date();
	}

	/**
	 * �ϴ�����֤��
	 * 
	 * @param context_img
	 *            ͼƬurl
	 * @param context_title
	 *            ����֤�����
	 * @param parent_title
	 *            ����id
	 */
	public Context(String context_img, String context_title, Title parent_title) {
		this.context_img = context_img;
		this.context_title = context_title;
		this.parent_title = parent_title;
		this.context_date = new Date();
	}

	/**
	 * �ϴ�����
	 * 
	 * @param context_img
	 *            ͼƬurl
	 * @param context_title
	 *            ����֤�����
	 * @param parent_title
	 *            ����id
	 */
	public Context(String context_img, String context_title, String context_text, Title parent_title) {
		this.context_img = context_img;
		this.context_title = context_title;
		this.parent_title = parent_title;
		this.context_text = context_text;
		this.context_date = new Date();
	}

	public Title getParent_title() {
		return parent_title;
	}

	public void setParent_title(Title parent_title) {
		this.parent_title = parent_title;
	}

	public Integer getContext_id() {
		return context_id;
	}

	public void setContext_id(Integer context_id) {
		this.context_id = context_id;
	}

	public String getContext_img() {
		return context_img;
	}

	public void setContext_img(String context_img) {
		this.context_img = context_img;
	}

	public String getContext_text() {
		return context_text;
	}

	public void setContext_text(String context_text) {
		this.context_text = context_text;
	}

}
