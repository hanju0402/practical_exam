package com.practical.exam.cms.home.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeDao {
	
	int passPercent(String userId);

}
