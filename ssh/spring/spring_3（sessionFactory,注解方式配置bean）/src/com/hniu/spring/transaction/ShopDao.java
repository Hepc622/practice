package com.hniu.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ShopDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void updateBookSurplus(int book_id) {
		String sql = null;
		sql = "SELECT book_surplus FROM shop WHERE book_id=?";
		Integer result = jdbcTemplate.queryForObject(sql, Integer.class, book_id);
		if (result <= 0)
			throw new ShopExcepetion();
		sql = "UPDATE shop SET book_surplus=book_surplus-1 WHERE book_id=?";
		jdbcTemplate.update(sql, book_id);
	}
}
