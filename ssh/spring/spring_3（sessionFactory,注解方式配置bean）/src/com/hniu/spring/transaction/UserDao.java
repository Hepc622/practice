package com.hniu.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void updateUserBalance(int book_price, int user_id) {
		String sql;
		sql = "SELECT user_balance FROM USER WHERE user_id = ?";
		Integer result = jdbcTemplate.queryForObject(sql, Integer.class, user_id);
		if (result < book_price)
			throw new UserExcepetion();
		sql = "UPDATE user SET user_balance=user_balance-? WHERE user_id=?";
		jdbcTemplate.update(sql, book_price, user_id);
	}
}
