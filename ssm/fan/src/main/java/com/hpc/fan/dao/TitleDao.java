package com.hpc.fan.dao;

import java.util.List;

import com.hpc.fan.bean.Title;

/**
 * class：This is TitleDao
 * @author hpc
 * @2017年3月15日下午9:52:14
 */
public interface TitleDao {
	/**
	 * @param id 
	 * @return
	 */
	public Title getTitleEntity(int t_id);
	/**传个null就好
	 * @return
	 */
	public List<Title> getAllTitleEntity(int t_id);
	
	/**传入需要更新的对象
	 * @param t
	 * @return
	 */
	public int updateTitleEntity(Title t);
	/**你要保存的对象
	 * @param t
	 * @return
	 */
	public int saveTitleEntity(Title t);
	/**你要删除的t_id
	 * @return
	 */
	public int deleteTitleEntity(int t_id);

}
