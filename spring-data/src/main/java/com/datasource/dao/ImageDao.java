package com.datasource.dao;

import org.apache.ibatis.annotations.Mapper;

import com.datasource.bean.Image;

@Mapper
public interface ImageDao {

	public Image getImg(int id);

}
