package com.hpc.fan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hpc.fan.bean.Product;

/**
 * class：This is ProductDao
 * 
 * @author hpc
 * @2017年3月15日下午9:52:14
 */
public interface ProductDao {
	/**
	 * 随机获取5个产品
	 */
	public List<Product> getRandomProduct();

	/**
	 * 获取一个Product对象的上一个对象和下一个对象
	 * 
	 * @param flag
	 *            1 为大于它的对象 2 为小于它对象
	 * @param id
	 *            Product id
	 * @return 对象
	 */
	public Product getProductBeforeOrAfter(@Param("flag") Integer flag, @Param("pid") Integer pid,
			@Param("cid") Integer cid);

	/**
	 * 获取一个Product对象
	 * 
	 * @param frist
	 *            时候获取第一个对象降序排序
	 * @param id
	 *            为true时传入父类id,反之product id
	 * @return
	 */
	public Product getProductEntity(@Param("first") boolean first, @Param("id") Integer id);

	/**
	 * 获取所有的内容
	 * 
	 * @param id
	 * @return
	 */
	public Integer getProductCount(Integer parent_id);

	/**
	 * 传个null就好
	 * 
	 * @return
	 */
	public List<Product> getAllProductEntity(@Param("p_id") Integer p_id, @Param("begin") Integer begin,
			@Param("everypage") Integer everypage);

	/**
	 * 传入需要更新的对象
	 * 
	 * @param Product
	 * @return
	 */
	public Integer updateProductEntity(Product pro);

	/**
	 * 你要保存的对象
	 * 
	 * @param Product
	 * @return
	 */
	public Integer saveProductEntity(@Param("pro") Product pro, @Param("imgUrl") String imgUrl);

	/**
	 * 你要删除的product_id
	 * 
	 * @return
	 */
	public Integer deleteProductEntity(Integer product_id);

}
