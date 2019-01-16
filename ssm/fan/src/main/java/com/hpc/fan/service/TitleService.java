package com.hpc.fan.service;

import java.util.List;

import com.hpc.fan.bean.Title;

public interface TitleService {
	/**
	 * This is read operation
	 */
	/**
	 * The method use of get out Title Entity
	 * 
	 * @param statement
	 *            This sql mapper
	 */
	public Title getTitleEntity(int t_id);

	/**
	 * The method use of get out Product all Entity
	 * 
	 * @param statement
	 *            This sql mapper
	 */
	public List<Title> getAllTitleEntity(int t_id);

	/**
	 * This is write operation
	 */
	/**
	 * The method use of update Title entity
	 */
	public int updateTitleEntity(Title t);

	/**
	 * The method use of delete Title entity
	 */
	public int deleteTitleEntity(int t_id);

	/**
	 * The method use of insert Title entity
	 */
	public int saveTitleEntity(Title t);

}
