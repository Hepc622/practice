package com.hpc.fan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.hpc.fan.bean.Product;
import com.hpc.fan.dao.ProductDao;
import com.hpc.fan.service.ProductService;

/**
 * class：This is ProductServiceImpl
 * 
 * @author hpc
 * @2017年3月15日下午10:07:05
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDao productDao;

	@Override
	public Product getProductEntity(boolean first, Integer id) {
		return productDao.getProductEntity(first, id);
	}

	@Override
	public List<Product> getAllProductEntity(Integer product_id, Integer begin, Integer everypage) {
		return productDao.getAllProductEntity(product_id, begin, everypage);
	}

	@Override
	public Integer getProductCount(Integer parent_id) {
		return productDao.getProductCount(parent_id);
	}

	@Override
	public Integer updateProductEntity(Product product) {
		return productDao.updateProductEntity(product);
	}

	@Override
	public Integer deleteProductEntity(Integer product_id) {
		return productDao.deleteProductEntity(product_id);
	}

	@Override
	public Integer saveProductEntity(Product product,String imgUrl) {
		return productDao.saveProductEntity(product,imgUrl);
	}

	@Override
	public Product getProductBeforeOrAfter(Integer flag, @Param("pid") Integer pid, Integer cid) {
		return productDao.getProductBeforeOrAfter(flag, pid, cid);
	}

	@Override
	public List<Product> getRandomProduct() {
		return productDao.getRandomProduct();
	}

}
