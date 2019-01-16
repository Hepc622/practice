package com.hpc.fan.dao;

import java.util.List;

import com.hpc.fan.bean.Navigation;

/**
 * class：This is  NavigationDao
 * @author hpc
 * @2017年3月11日下午5:55:05
 */
public interface NavigationDao {
	/**获取一个导航对象
	 * @param id 
	 * @return
	 */
	public Navigation getNavigationEntity(int nav_id);
	/**传个null就好
	 * @return
	 */						
	public List<Navigation> getAllNavigationEntity();
	
	/**传入需要更新的对象
	 * @param Navigation
	 * @return
	 */
	public int updateNavigationEntity(Navigation nav);
	/**你要保存的对象
	 * @param Navigation
	 * @return
	 */
	public int saveNavigationEntity(Navigation nav);
	/**你要删除的nav_id
	 * @return
	 */
	public int deleteNavigationEntity(int nav_id);

}
