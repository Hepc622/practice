package com.hpc.fan.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hpc.fan.bean.Product;

public interface ProductService {
	/**
	 * random five product
	 */
	public List<Product> getRandomProduct();

	/**
	 * This is read operation
	 */
	public Product getProductBeforeOrAfter(@Param("flag") Integer flag, @Param("pid") Integer pid,
			@Param("cid") Integer cid);

	/**
	 * The method use of get out Product Entity
	 * 
	 * @param statement
	 *            This sql mapper
	 */
	public Product getProductEntity(boolean first, Integer product_id);

	/**
	 * The method use of get out Product Count
	 * 
	 * @param statement
	 *            This sql mapper
	 */
	public Integer getProductCount(Integer parent_id);

	/**
	 * The method use of get out Product all Entity
	 * 
	 * @param statement
	 *            This sql mapper
	 */
	public List<Product> getAllProductEntity(Integer parent_id, Integer begin, Integer everypage);

	/**
	 * This is write operation
	 */
	/**
	 * The method use of update Product entity
	 */
	public Integer updateProductEntity(Product product);

	/**
	 * The method use of delete Product entity
	 */
	public Integer deleteProductEntity(Integer product_id);

	/**
	 * The method use of insert Product entity
	 */
	public Integer saveProductEntity(Product product, String imgUrl);

}
