package com.hpc.fan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hpc.fan.bean.Product;

/**
 * class��This is ProductDao
 * 
 * @author hpc
 * @2017��3��15������9:52:14
 */
public interface ProductDao {
	/**
	 * �����ȡ5����Ʒ
	 */
	public List<Product> getRandomProduct();

	/**
	 * ��ȡһ��Product�������һ���������һ������
	 * 
	 * @param flag
	 *            1 Ϊ�������Ķ��� 2 ΪС��������
	 * @param id
	 *            Product id
	 * @return ����
	 */
	public Product getProductBeforeOrAfter(@Param("flag") Integer flag, @Param("pid") Integer pid,
			@Param("cid") Integer cid);

	/**
	 * ��ȡһ��Product����
	 * 
	 * @param frist
	 *            ʱ���ȡ��һ������������
	 * @param id
	 *            Ϊtrueʱ���븸��id,��֮product id
	 * @return
	 */
	public Product getProductEntity(@Param("first") boolean first, @Param("id") Integer id);

	/**
	 * ��ȡ���е�����
	 * 
	 * @param id
	 * @return
	 */
	public Integer getProductCount(Integer parent_id);

	/**
	 * ����null�ͺ�
	 * 
	 * @return
	 */
	public List<Product> getAllProductEntity(@Param("p_id") Integer p_id, @Param("begin") Integer begin,
			@Param("everypage") Integer everypage);

	/**
	 * ������Ҫ���µĶ���
	 * 
	 * @param Product
	 * @return
	 */
	public Integer updateProductEntity(Product pro);

	/**
	 * ��Ҫ����Ķ���
	 * 
	 * @param Product
	 * @return
	 */
	public Integer saveProductEntity(@Param("pro") Product pro, @Param("imgUrl") String imgUrl);

	/**
	 * ��Ҫɾ����product_id
	 * 
	 * @return
	 */
	public Integer deleteProductEntity(Integer product_id);

}
