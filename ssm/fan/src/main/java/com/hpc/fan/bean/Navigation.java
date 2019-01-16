package com.hpc.fan.bean;

/**
 * class：This is Navigation
 * 
 * @author hpc
 * @2017年3月15日下午9:02:45
 */
public class Navigation {
	private int navigation_id;
	private String navigation_name;
	private String navigation_url;
	private String navigation_english;
	private String navigation_img;

	public String getNavigation_img() {
		return navigation_img;
	}

	public void setNavigation_img(String navigation_img) {
		this.navigation_img = navigation_img;
	}

	public String getNavigation_english() {
		return navigation_english;
	}

	public void setNavigation_english(String navigation_english) {
		this.navigation_english = navigation_english;
	}

	public int getNavigation_id() {
		return navigation_id;
	}

	public void setNavigation_id(int navigation_id) {
		this.navigation_id = navigation_id;
	}

	public String getNavigation_name() {
		return navigation_name;
	}

	public void setNavigation_name(String navigation_name) {
		this.navigation_name = navigation_name.toLowerCase();
	}

	public String getNavigation_url() {
		return navigation_url;
	}

	public void setNavigation_url(String navigation_url) {
		this.navigation_url = navigation_url;
	}

	@Override
	public String toString() {
		return "Navigation [navigation_id=" + navigation_id + ", navigation_name=" + navigation_name
				+ ", navigation_url=" + navigation_url + ", navigation_english=" + navigation_english
				+ ", navigation_img=" + navigation_img + "]";
	}

}
