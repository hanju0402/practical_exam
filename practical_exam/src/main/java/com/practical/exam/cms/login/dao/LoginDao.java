package com.practical.exam.cms.login.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
	Map<String,String> getUserInfo(Map<String,String> userInfo);
}
