package com.hniu.surveypark.service.impl;

import java.util.List;

import com.hniu.surveypark.dao.impl.RightDao;
import com.hniu.surveypark.model.Right;
import com.hniu.surveypark.service.RightService;
import com.hniu.surveypark.util.ValidateUtil;

/**
 * 此类是：RigthServiceImpl实现
 * 
 * @author: hpc
 * @version: 2016年12月12日 下午10:39:57
 */
public class RightServiceImpl implements RightService {
	private RightDao rightDao;

	public void setRightDao(RightDao rightDao) {
		this.rightDao = rightDao;
	}

	/*
	 * 获取所有的权限
	 */
	public List<Right> getAllRight() {
		String hql = "from Right";
		return rightDao.findEntityByHQL(hql);
	}

	/*
	 * 保存或更新权限
	 */
	public void saveOrUpdateRight(Right model) {
		String hql;
		hql = "from Right r where r.right_url=?";
		List<Right> list = rightDao.findEntityByHQL(hql, model.getRight_url());
		if (ValidateUtil.isEmpty(model.getRight_url()) && list.size() > 0) {
			if (list.get(0).getRight_url().equals(model.getRight_url())) {
				return;
			}
		}
		hql = "select max(r.right_code),max(r.right_pos) from Right r where r.right_pos=(select MAX(rr.right_pos) from Right rr )";
		// 获取数据库中最大的权限为和权限码
		Object[] urt = (Object[]) rightDao.uniqueResult(hql);
		Long code = (Long) urt[0];
		Integer pos = (Integer) urt[1];
		if (pos == null || code == null) {
			model.setRight_pos(0);
			model.setRight_code(1l);
		} else {
			if (1 << 60 > code) {
				model.setRight_pos(pos);
				model.setRight_code(code << 1);
			} else {
				model.setRight_pos(pos + 1);
				model.setRight_code(1l);
			}
		}
		rightDao.saveOrUpdateEntity(model);
	}

	/*
	 * 获取权限对象
	 */
	public Right getRight(Right model) {
		return rightDao.getEntity(model.getRight_id());
	}

	/*
	 * 通过url获取取权限对象
	 */
	public Right getRight(String url) {
		String hql = "from Right r where r.right_url=?";
		List<Right> list = rightDao.findEntityByHQL(hql, url);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/*
	 * 编辑权限
	 */
	public void editRight(Right model) {
		rightDao.saveOrUpdateEntity(model);
	}

	/**
	 * 获取最大权限位
	 */
	public int getMaxPos() {
		String hql = "select max(r.right_pos) from Right r";
		Integer maxPos = (Integer) rightDao.uniqueResult(hql);
		return maxPos != null ? maxPos.intValue() : 0;
	}
}
