package com.hniu.spring.transaction.xml;


public class ShopService {
	private BookDao bookDao;
	private ShopDao shopDao;
	private UserDao userDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void start(int book_id,int user_id) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		// 获取书籍价格
		Integer bookPrice = bookDao.getBookPrice(book_id);
		// 更新书库
		shopDao.updateBookSurplus(book_id);
		// 扣除金额
		userDao.updateUserBalance(bookPrice, user_id);
	}
}
