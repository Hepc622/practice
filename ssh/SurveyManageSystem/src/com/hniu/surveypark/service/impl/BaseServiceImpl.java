package com.hniu.surveypark.service.impl;

import java.util.List;

import com.hniu.surveypark.dao.BaseDao;
import com.hniu.surveypark.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	private BaseDao<T> userDao;
	
	public void setUserDao(BaseDao<T> baseDao) {
		this.userDao = baseDao;
	}

	public void saveEntity(T t) {
		userDao.saveEntity(t);
	}

	public void saveOrUpdateEntity(T t) {
		userDao.saveOrUpdateEntity(t);
	}

	public void deleteEntity(T t) {
		userDao.deleteEntity(t);
	}

	public void batchEntityByHQL(String hql, Object... objects) {
		userDao.batchEntityByHQL(hql, objects);
	}

	public T loadEntity(Integer id) {
		return userDao.loadEntity(id);
	}

	public T getEntity(Integer id) {
		return userDao.getEntity(id);
	}

	public List<T> findEntityByHQL(String hql, Object... objects) {
		return userDao.findEntityByHQL(hql, objects);
	}

}
