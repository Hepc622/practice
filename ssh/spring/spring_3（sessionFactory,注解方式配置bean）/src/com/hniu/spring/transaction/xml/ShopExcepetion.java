package com.hniu.spring.transaction.xml;

public class ShopExcepetion extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public ShopExcepetion() {
		System.out.println("此书籍没有库存了！");
	}

}
