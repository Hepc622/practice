package com.hpc.fan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hpc.fan.bean.Context;

/**
 * class：This is
 * 
 * @author hpc
 * @2017年3月17日下午7:20:27
 */
public interface ContextDao {
	/**
	 * 获取一个Context对象的上一个对象和下一个对象
	 * 
	 * @param flag
	 *            1 为大于它的对象 2 为小于它对象
	 * @param id
	 *            Context id
	 * @return 对象
	 */
	public Context getContextBeforeOrAfter(@Param("flag") Integer flag, @Param("pid") Integer pid,
			@Param("cid") Integer cid);

	/**
	 * 获取一个Context对象
	 * 
	 * @param frist
	 *            时候获取第一个对象降序排序
	 * @param id
	 *            为true时传入父类id,反之context id
	 * @return
	 */
	public Context getContextEntity(@Param("first") boolean first, @Param("id") Integer id);

	/**
	 * 获取所有的内容
	 * 
	 * @param id
	 * @return
	 */
	public Integer getContextCount(Integer parent_id);

	/**
	 * 传个null就好
	 * 
	 * @return
	 */
	public List<Context> getAllContextEntity(@Param("context_id") Integer context_id, @Param("begin") Integer begin,
			@Param("everypage") Integer everypage);

	/**
	 * 传入需要更新的对象
	 * 
	 * @param Context
	 * @return
	 */
	public Integer updateContextEntity(Context nav);

	/**
	 * 你要保存的对象
	 * 
	 * @param Context
	 * @return
	 */
	public Integer saveContextEntity(Context nav);

	/**
	 * 你要删除的context_id
	 * 
	 * @return
	 */
	public Integer deleteContextEntity(Integer context_id);

}
