package com.hniu.surveypark.model;

import java.util.Date;
import java.util.Set;

/**
 * ”√ªß¿‡
 */
public class User {
	private Integer user_id;
	private String user_email;
	private String user_name;
	private String user_password;
	private String user_nickname;
	private String re_user_password;
	private Date user_rgtTime = new Date();

	private long[] rightSum;
	private Set<Role> user_role;

	public long[] getRightSum() {
		return rightSum;
	}

	public void setRightSum(long[] rightSum) {
		this.rightSum = rightSum;
	}

	public Set<Role> getUser_role() {
		return this.user_role;
	}

	public void setUser_role(Set<Role> user_role) {
		this.user_role = user_role;
	}

	public Date getUser_rgtTime() {
		return user_rgtTime;
	}

	public void setUser_rgtTime(Date user_rgtTime) {
		this.user_rgtTime = user_rgtTime;
	}

	public String getRe_user_password() {
		return re_user_password;
	}

	public void setRe_user_password(String re_user_password) {
		this.re_user_password = re_user_password;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public void initRigth() {
		int pos = 0;
		long code = 0;
		Set<Role> r = getUser_role();
		if (r != null && r.size() > 0) {
			for (Role role : r) {
				for (Right right : role.getRole_right()) {
					pos = right.getRight_pos();
					code = right.getRight_code();
					rightSum[pos] |= code;
				}
			}
			r = null;
		}
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_email=" + user_email + ", user_name=" + user_name
				+ ", user_password=" + user_password + ", user_nickname=" + user_nickname + ", re_user_password="
				+ re_user_password + ", user_rgtTime=" + user_rgtTime + "]";
	}

}
