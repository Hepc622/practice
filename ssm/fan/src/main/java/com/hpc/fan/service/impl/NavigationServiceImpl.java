package com.hpc.fan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hpc.fan.bean.Navigation;
import com.hpc.fan.dao.NavigationDao;
import com.hpc.fan.service.NavigationService;

/**
 * class：This is NavigationServiceImpl
 * 
 * @author hpc
 * @2017年3月15日下午10:05:53
 */
@Service("navigationService")
public class NavigationServiceImpl implements NavigationService {

	@Resource
	private NavigationDao navigationDao;

	@Override
	public Navigation getNavigationEntity(int t_id) {
		return navigationDao.getNavigationEntity(t_id);
	}

	@Override
	public List<Navigation> getAllNavigationEntity() {
		return navigationDao.getAllNavigationEntity();
	}

	@Override
	public int updateNavigationEntity(Navigation t) {
		return navigationDao.updateNavigationEntity(t);
	}

	@Override
	public int deleteNavigationEntity(int t_id) {
		return navigationDao.deleteNavigationEntity(t_id);
	}

	@Override
	public int saveNavigationEntity(Navigation t) {
		return navigationDao.saveNavigationEntity(t);
	}

}
