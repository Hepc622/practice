package com.hniu.surveypark.strus2.action;

import com.hniu.surveypark.model.User;

/**
 * 用户注入，只有实现了该接口才给他注入user对象
 */
public interface UserAware {
	// 注入用户对象对象
	public void setUser(User user);
}
