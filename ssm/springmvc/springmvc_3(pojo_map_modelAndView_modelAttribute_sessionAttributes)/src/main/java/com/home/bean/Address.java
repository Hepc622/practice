package com.home.bean;

/**
 * �����ǣ���ַʵ����
 * @author hpc
 * @2017��2��17������7:07:32
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
