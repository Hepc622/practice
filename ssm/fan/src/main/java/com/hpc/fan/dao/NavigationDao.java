package com.hpc.fan.dao;

import java.util.List;

import com.hpc.fan.bean.Navigation;

/**
 * class��This is  NavigationDao
 * @author hpc
 * @2017��3��11������5:55:05
 */
public interface NavigationDao {
	/**��ȡһ����������
	 * @param id 
	 * @return
	 */
	public Navigation getNavigationEntity(int nav_id);
	/**����null�ͺ�
	 * @return
	 */						
	public List<Navigation> getAllNavigationEntity();
	
	/**������Ҫ���µĶ���
	 * @param Navigation
	 * @return
	 */
	public int updateNavigationEntity(Navigation nav);
	/**��Ҫ����Ķ���
	 * @param Navigation
	 * @return
	 */
	public int saveNavigationEntity(Navigation nav);
	/**��Ҫɾ����nav_id
	 * @return
	 */
	public int deleteNavigationEntity(int nav_id);

}
