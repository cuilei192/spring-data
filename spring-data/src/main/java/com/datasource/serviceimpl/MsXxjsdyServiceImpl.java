package com.datasource.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasource.bean.MsXxjsdy;
import com.datasource.config.datasource.TargetDataSource;
import com.datasource.dao.MsXxjsdyDao;
import com.datasource.service.MsXxjsdyService;

@Service
public class MsXxjsdyServiceImpl implements MsXxjsdyService{

	@Autowired
	MsXxjsdyDao msXxjsdyDao;
	
	@TargetDataSource("primaryDB")
	@Override
	public MsXxjsdy getMsXxjsdyById(Integer id) {
		// TODO Auto-generated method stub
		return msXxjsdyDao.getMsXxjsdyById(id);
	}

}
