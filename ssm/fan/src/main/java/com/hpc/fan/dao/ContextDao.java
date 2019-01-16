package com.hpc.fan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hpc.fan.bean.Context;

/**
 * class��This is
 * 
 * @author hpc
 * @2017��3��17������7:20:27
 */
public interface ContextDao {
	/**
	 * ��ȡһ��Context�������һ���������һ������
	 * 
	 * @param flag
	 *            1 Ϊ�������Ķ��� 2 ΪС��������
	 * @param id
	 *            Context id
	 * @return ����
	 */
	public Context getContextBeforeOrAfter(@Param("flag") Integer flag, @Param("pid") Integer pid,
			@Param("cid") Integer cid);

	/**
	 * ��ȡһ��Context����
	 * 
	 * @param frist
	 *            ʱ���ȡ��һ������������
	 * @param id
	 *            Ϊtrueʱ���븸��id,��֮context id
	 * @return
	 */
	public Context getContextEntity(@Param("first") boolean first, @Param("id") Integer id);

	/**
	 * ��ȡ���е�����
	 * 
	 * @param id
	 * @return
	 */
	public Integer getContextCount(Integer parent_id);

	/**
	 * ����null�ͺ�
	 * 
	 * @return
	 */
	public List<Context> getAllContextEntity(@Param("context_id") Integer context_id, @Param("begin") Integer begin,
			@Param("everypage") Integer everypage);

	/**
	 * ������Ҫ���µĶ���
	 * 
	 * @param Context
	 * @return
	 */
	public Integer updateContextEntity(Context nav);

	/**
	 * ��Ҫ����Ķ���
	 * 
	 * @param Context
	 * @return
	 */
	public Integer saveContextEntity(Context nav);

	/**
	 * ��Ҫɾ����context_id
	 * 
	 * @return
	 */
	public Integer deleteContextEntity(Integer context_id);

}
