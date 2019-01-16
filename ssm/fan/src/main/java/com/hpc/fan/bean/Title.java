package com.hpc.fan.bean;

/**
 * class：This is Title
 * 
 * @author hpc
 * @2017年3月15日下午8:24:42
 */
public class Title {
	private int title_id;
	private String title_name;
	private String title_url;
	private int title_type;
	
	public int getTitle_type() {
		return title_type;
	}

	public void setTitle_type(int title_type) {
		this.title_type = title_type;
	}
	public Title(int title_id) {
		super();
		this.title_id = title_id;
	}

	public Title() {
		super();
	}

	public Title(int title_id, String title_name, String title_url) {
		super();
		this.title_id = title_id;
		this.title_name = title_name;
		this.title_url = title_url;
	}

	public String getTitle_url() {
		return title_url;
	}

	public void setTitle_url(String title_url) {
		this.title_url = title_url;
	}

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}

	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}

	@Override
	public String toString() {
		return "Title [title_id=" + title_id + ", title_name=" + title_name + ", title_url=" + title_url + "]";
	}

}
