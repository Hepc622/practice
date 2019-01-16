package com.hpc.fan.dao;

import java.util.List;

import com.hpc.fan.bean.Title;

/**
 * class��This is TitleDao
 * @author hpc
 * @2017��3��15������9:52:14
 */
public interface TitleDao {
	/**
	 * @param id 
	 * @return
	 */
	public Title getTitleEntity(int t_id);
	/**����null�ͺ�
	 * @return
	 */
	public List<Title> getAllTitleEntity(int t_id);
	
	/**������Ҫ���µĶ���
	 * @param t
	 * @return
	 */
	public int updateTitleEntity(Title t);
	/**��Ҫ����Ķ���
	 * @param t
	 * @return
	 */
	public int saveTitleEntity(Title t);
	/**��Ҫɾ����t_id
	 * @return
	 */
	public int deleteTitleEntity(int t_id);

}
