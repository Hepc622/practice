package com.hniu.spring.transaction.xml;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Integer getBookPrice(int book_id){
		String sql="SELECT book_price FROM book WHERE book_id=?";
		Integer integer = jdbcTemplate.queryForObject(sql,Integer.class,book_id);
		return integer;
	}
}
