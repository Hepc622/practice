package com.hpc.fan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hpc.fan.bean.Title;
import com.hpc.fan.dao.TitleDao;
import com.hpc.fan.service.TitleService;

@Service("titleSerivce")
public class TitleServiceImpl implements TitleService {

	@Resource
	private TitleDao titleDao;

	@Override
	public Title getTitleEntity(int t_id) {
		return titleDao.getTitleEntity(t_id);
	}

	@Override
	public List<Title> getAllTitleEntity(int t_id) {
		return titleDao.getAllTitleEntity(t_id);
	}

	@Override
	public int updateTitleEntity(Title t) {
		return titleDao.updateTitleEntity(t);
	}

	@Override
	public int deleteTitleEntity(int t_id) {
		return titleDao.deleteTitleEntity(t_id);
	}

	@Override
	public int saveTitleEntity(Title t) {
		return titleDao.saveTitleEntity(t);
	}

}
