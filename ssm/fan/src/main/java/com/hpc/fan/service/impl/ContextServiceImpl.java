package com.hpc.fan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.hpc.fan.bean.Context;
import com.hpc.fan.dao.ContextDao;
import com.hpc.fan.service.ContextService;

/**
 * class：This is ContextServiceImpl
 * 
 * @author hpc
 * @2017年3月17日下午7:18:54
 */
@Service("contextService")
public class ContextServiceImpl implements ContextService {
	@Resource
	private ContextDao contextDao;

	@Override
	public Context getContextEntity(boolean first, Integer id) {
		return contextDao.getContextEntity(first, id);
	}

	@Override
	public List<Context> getAllContextEntity(Integer context_id, Integer begin, Integer everypage) {
		return contextDao.getAllContextEntity(context_id, begin, everypage);
	}

	@Override
	public Integer getContextCount(Integer parent_id) {
		return contextDao.getContextCount(parent_id);
	}

	@Override
	public Integer updateContextEntity(Context context) {
		return contextDao.updateContextEntity(context);
	}

	@Override
	public Integer deleteContextEntity(Integer context_id) {
		return contextDao.deleteContextEntity(context_id);
	}

	@Override
	public Integer saveContextEntity(Context context) {
		return contextDao.saveContextEntity(context);
	}

	@Override
	public Context getContextBeforeOrAfter(Integer flag, @Param("pid") Integer pid, Integer cid) {
		return contextDao.getContextBeforeOrAfter(flag, pid, cid);
	}

}
