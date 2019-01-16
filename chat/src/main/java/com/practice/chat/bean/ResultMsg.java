package com.practice.chat.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class ResultMsg {
	//请求码   0 请求成功    1请求失败	
	private Integer code;
	private String message;
	private Map<String,Object> datas = new HashMap<String,Object>();
	
	public static ResultMsg success() {
		ResultMsg rm = new ResultMsg(0,"操作成功");
		return rm;
	}
	public static ResultMsg fail() {
		ResultMsg rm = new ResultMsg(1,"操作失败");
		return rm;
	}

	private ResultMsg(Integer code,String message) {
		this.code=code;
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}
	public ResultMsg setCode(Integer code) {
		this.code = code;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ResultMsg setMessage(String message) {
		this.message = message;
		return this;
	}
	public Map<String, Object> getDatas() {
		return datas;
	}
	public ResultMsg setDatas(Map<String, Object> map) {
		this.datas = map;
		return this;
	}
	public ResultMsg setDatas(String k,Object v) {
		this.datas.put(k, v);
		return this;
	}
}
