package com.home.bean;

/**
 * 此类是：地址实体类
 * @author hpc
 * @2017年2月17日下午7:07:32
 */
public class Address {
	private String city;
	private String street;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + "]";
	}
	
}
