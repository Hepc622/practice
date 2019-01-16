package com.hniu.spring.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User getUser(int id) {
		String sql = "SELECT * FROM USERINFO WHERE USER_ID=?";
		RowMapper<User> requiredType = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(sql, requiredType, id);
		return user;
	}
}
