package com.practice.chat.bean;

import javax.websocket.Session;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Administrator
 *在线用户的
 */
public class OnlineUser {
	private String userId;
	private JSONObject group;
	private Session session;
	
	public JSONObject getGroup() {
		return group;
	}
	public void setGroup(JSONObject group) {
		this.group = group;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	@Override
	public String toString() {
		return "OnlineUser [userId=" + userId + ", group=" + group + ", session=" + session + "]";
	}
	
	
}
