package com.practical.exam.cms.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.practical.exam.common.auth.UserInfo;

@Mapper
public interface CommonDao {
	List<Map<String,String>> getMenuList(UserInfo userInfo);
	List<Map<String,String>> getCommonCode(String groupCode);
}
