package com.datasource.dao;


import org.apache.ibatis.annotations.Mapper;

import com.datasource.bean.MsXxjsdy;


@Mapper
public interface MsXxjsdyDao {

	MsXxjsdy getMsXxjsdyById(Integer id);
}