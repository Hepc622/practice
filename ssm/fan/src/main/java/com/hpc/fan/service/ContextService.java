package com.hpc.fan.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hpc.fan.bean.Context;

/**
 * class：This is ContextDao
 * 
 * @author hpc
 * @2017年3月17日下午7:16:14
 */
public interface ContextService {
	/**
	 * This is read operation
	 */
	public Context getContextBeforeOrAfter(@Param("flag") Integer flag,@Param("pid") Integer pid, @Param("cid") Integer cid);
	/**
	 * The method use of get out Context Entity
	 * 
	 * @param statement
	 *            This sql mapper
	 */
	public Context getContextEntity(boolean first, Integer context_id);

	/**
	 * The method use of get out Context Count
	 * 
	 * @param statement
	 *            This sql mapper
	 */
	public Integer getContextCount(Integer parent_id);

	/**
	 * The method use of get out Context all Entity
	 * 
	 * @param statement
	 *            This sql mapper
	 */
	public List<Context> getAllContextEntity(Integer parent_id, Integer begin, Integer everypage);

	/**
	 * This is write operation
	 */
	/**
	 * The method use of update Context entity
	 */
	public Integer updateContextEntity(Context context);

	/**
	 * The method use of delete Product entity
	 */
	public Integer deleteContextEntity(Integer context_id);

	/**
	 * The method use of insert Context entity
	 */
	public Integer saveContextEntity(Context context);
}
