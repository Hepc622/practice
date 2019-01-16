package com.hniu.surveypark.service;

import java.util.List;

/**
 * Service ���baseservice��
 * 
 * @param <T>
 */
public interface BaseService<T> {
	// д����
	/**
	 * ����������
	 * 
	 * @param t
	 *            Ҫ����Ķ���
	 */
	public void saveEntity(T t);

	/**
	 * ���»򱣴�������
	 * 
	 * @param t
	 *            Ҫ���»򱣴�Ķ���
	 */
	public void saveOrUpdateEntity(T t);

	/**
	 * ɾ���������
	 * 
	 * @param t
	 *            Ҫɾ������
	 */
	public void deleteEntity(T t);

	/**
	 * ���������
	 * 
	 * @param hql
	 *            �������hql���
	 * @param objects
	 *            ��Ӧ�Ĳ���
	 */
	public void batchEntityByHQL(String hql, Object... objects);

	// ������
	/**
	 * ��ȡ�������
	 * 
	 * @param id
	 *            ���ݶ���id��ȡ����
	 * @return ���ض���
	 */
	public T loadEntity(Integer id);

	/**
	 * ��ȡ�������
	 * 
	 * @param id
	 *            ���ݶ���id��ȡ����
	 * @return ���ض���
	 */
	public T getEntity(Integer id);

	/**
	 * ���������
	 * 
	 * @param hql
	 *            �������hql���
	 * @param objects
	 *            ��Ӧ�Ĳ���
	 */
	public List<T> findEntityByHQL(String hql, Object... object);
}
