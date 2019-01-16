package com.hpc.fan.bean;

/**
 * class：This is Product
 * 
 * @author hpc
 * @2017年3月10日下午11:34:41
 */
public class Product {
	private String pro_id;
	private String pro_name;
	private String pro_type;
	private String pro_specification;
	private String pro_parameter;
	private String pro_image;
	private Title parent_title;

	public Title getParent_title() {
		return parent_title;
	}

	public void setParent_title(Title parent_title) {
		this.parent_title = parent_title;
	}

	public Product() {
	}

	public Product(String pro_name, String pro_type, String pro_specification, String pro_parameter, String pro_image,
			Title title) {
		super();
		this.pro_name = pro_name;
		this.pro_type = pro_type;
		this.pro_specification = pro_specification;
		this.pro_parameter = pro_parameter;
		this.pro_image = pro_image;
		this.parent_title = title;
	}

	@Override
	public String toString() {
		return "Product [pro_id=" + pro_id + ", pro_name=" + pro_name + ", pro_type=" + pro_type
				+ ", pro_specification=" + pro_specification + ", pro_parameter=" + pro_parameter + ", pro_image="
				+ pro_image + "]";
	}

	public String getPro_parameter() {
		return pro_parameter;
	}

	public void setPro_parameter(String pro_parameter) {
		this.pro_parameter = pro_parameter;
	}

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_type() {
		return pro_type;
	}

	public void setPro_type(String pro_type) {
		this.pro_type = pro_type;
	}

	public String getPro_specification() {
		return pro_specification;
	}

	public void setPro_specification(String pro_specification) {
		this.pro_specification = pro_specification;
	}

	public String[] getPro_image() {
		return pro_image.split(",");
	}

	public void setPro_image(String pro_image) {
		this.pro_image = pro_image;
	}

}
