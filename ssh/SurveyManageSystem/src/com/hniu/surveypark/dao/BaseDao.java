package com.hniu.surveypark.dao;

import java.util.List;

/**
 * Base接口
 */
public interface BaseDao<T> {
	// 写操作
	/**
	 * 保存对象操作
	 * 
	 * @param t
	 *            要保存的对象
	 */
	public void saveEntity(T t);

	/**
	 * 更新或保存对象操作
	 * 
	 * @param t
	 *            要更新或保存的对象
	 */
	public void saveOrUpdateEntity(T t);

	/**
	 * 删除对象操作
	 * 
	 * @param t
	 *            要删除对象
	 */
	public void deleteEntity(T t);

	/**
	 * 批处理操作
	 * 
	 * @param hql
	 *            批处理的hql语句
	 * @param objects
	 *            对应的参数
	 */
	public void batchEntityByHQL(String hql, Object... objects);

	// 读操作
	/**
	 * 读取对象操作
	 * 
	 * @param id
	 *            根据对象id获取对象
	 * @return 返回对象
	 */
	public T loadEntity(Integer id);

	/**
	 * 读取对象操作
	 * 
	 * @param id
	 *            根据对象id获取对象
	 * @return 返回对象
	 */
	public T getEntity(Integer id);

	/**
	 * 批处理操作
	 * 
	 * @param hql
	 *            批处理的hql语句
	 * @param objects
	 *            对应的参数
	 */
	public List<T> findEntityByHQL(String hql, Object... object);

	/**
	 * 单值检索
	 * 
	 * @param hql
	 *            sql 语句
	 * @param objects
	 *            sql语句的对应参数
	 * @return 返回一条记录
	 */
	public Object uniqueResult(String hql, Object... objects);
}
