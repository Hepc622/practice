package com.hniu.spring.transaction.xml;

import org.springframework.jdbc.core.JdbcTemplate;
public class UserDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void updateUserBalance(int book_price,int user_id){
		String sql;
		sql = "SELECT user_balance FROM USER WHERE user_id = ?";
		Integer result = jdbcTemplate.queryForObject(sql,Integer.class,user_id);
		if(result<book_price)
			throw new UserExcepetion();
		sql = "UPDATE user SET user_balance=user_balance-? WHERE user_id=?";
		jdbcTemplate.update(sql,book_price,user_id);
	}
}
