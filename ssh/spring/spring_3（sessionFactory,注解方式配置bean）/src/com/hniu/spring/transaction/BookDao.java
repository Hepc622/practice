package com.hniu.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Integer getBookPrice(int book_id) {
		String sql = "SELECT book_price FROM book WHERE book_id=?";
		Integer integer = jdbcTemplate.queryForObject(sql, Integer.class, book_id);
		return integer;
	}
}
