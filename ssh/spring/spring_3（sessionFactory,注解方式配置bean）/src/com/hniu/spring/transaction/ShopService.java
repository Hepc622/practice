package com.hniu.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopService {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private UserDao userDao;
	/**
	 * 使用propagation指定传播行为，当前为默认行为，都公用一个事务，
	 * 可以将propagation指定为REQUIRES_NEW这样每个方法就用自己的事务，互补干扰
	 *isolation 使用该属性设置隔离级别
	 *	READ_COMMITTED 读已提交
	 *	READ_UNCOMMITTED 读未已提交
	 *	REPEATABLE_READ 重复读
	 *readOnly 只读 
	 *	false true
	 *timeout 访问时间
	 *	超出访问时间失败，时间单位秒
	 *rollbackFor 指定哪些类回滚
	 *	以数组的方式{...class,...class}
	 *noRollbackFor 指定哪些类不回滚
	 *	以数组的方式{...class,...class}
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED,
			readOnly=false,
			timeout=3,
			rollbackFor={UserExcepetion.class,ShopExcepetion.class},
			noRollbackFor={}
			)
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
