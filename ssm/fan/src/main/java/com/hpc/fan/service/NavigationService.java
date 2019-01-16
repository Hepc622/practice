package com.hpc.fan.service;

import java.util.List;

import com.hpc.fan.bean.Navigation;

public interface NavigationService {
	/**
	 * This is read operation
	 */
	/**
	 * The method use of get out Navigation Entity
	 * 
	 * @param statement
	 *            This sql mapper
	 */
	public Navigation getNavigationEntity(int nav_id);

	/**
	 * The method use of get out Navigation all Entity
	 * 
	 * @param statement
	 *            This sql mapper
	 */
	public List<Navigation> getAllNavigationEntity();

	/**
	 * This is write operation
	 */
	/**
	 * The method use of update Navigation entity
	 */
	public int updateNavigationEntity(Navigation nav);

	/**
	 * The method use of delete Product entity
	 */
	public int deleteNavigationEntity(int nav_id);

	/**
	 * The method use of insert Navigation entity
	 */
	public int saveNavigationEntity(Navigation nav);

}
