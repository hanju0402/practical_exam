package com.practical.exam.common.sms.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsDao {
	
	
	boolean getSmsIpCheck(Map<String,String> map);
	// 인증번호 가져오기
	String getRegisterAuth(Map<String,String> map);
	
	// 인증번호 등록
	void addAuthNumber(Map<String,String> map);
}
