package com.hniu.surveypark.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 此类是：角色类
 * 
 * @author: hpc
 * @version: 2016年12月12日 下午3:52:00
 */
public class Role {
	private Integer role_id;
	private String role_name;
	private String role_value;
	private String role_desc;
	private Set<Right> role_right;
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_value() {
		
		return role_value;
	}
	public void setRole_value(String role_value) {
		this.role_value = role_value;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	public Set<Right> getRole_right() {
		if(role_value==null){
			return new HashSet<Right>();
		}else{
			return this.role_right;
		}
	}
	public void setRole_right(Set<Right> role_right) {
		this.role_right = role_right;
	}

}
