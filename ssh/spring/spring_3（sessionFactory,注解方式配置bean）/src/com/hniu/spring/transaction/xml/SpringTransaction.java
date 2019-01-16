package com.hniu.spring.transaction.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransaction {
	private ShopService shopService;
	private BatchBuyBook batchBuyBook;
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jdbc-xml.xml");
		shopService = (ShopService) ac.getBean("shopService");
		// batchBuyBook = (BatchBuyBook) ac.getBean("batchBuyBook");

	}

	@Test
	public void jdbcTran() {
		shopService.start(1, 8);
	}
}
