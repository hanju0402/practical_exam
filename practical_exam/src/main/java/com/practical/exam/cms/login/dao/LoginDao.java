package com.practical.exam.cms.login.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
	
	// 사용자 정보 조회
	Map<String,String> getUserInfo(Map<String,String> userInfo);
	
	// 신규 계정 추가
	void addUserInfo(Map<String,String> userInfo);
	
	// 계정 중복여부
	boolean idDuplicated(Map<String,String> userInfo);
}
