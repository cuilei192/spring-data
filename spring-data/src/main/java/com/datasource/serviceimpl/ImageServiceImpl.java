package com.datasource.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasource.bean.Image;
import com.datasource.config.datasource.TargetDataSource;
import com.datasource.dao.ImageDao;
import com.datasource.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	ImageDao imageDao;
    
	@TargetDataSource("secondaryDB")
	@Override
	public Image getImg(int id) {
		return imageDao.getImg(id);
	}
	
}
