package com.practical.exam.cms.home.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.practical.exam.common.auth.UserInfo;

@Service("homeService")
public class HomeService {
	

	@Resource
	private UserInfo userInfo;
	/**
	 * 로그인 처리 
	 * 
	 * @param reqData
	 * @return
	 */
	public void login(HashMap<String,String> reqData) {
		// DB가 없으므로 , 'sss' ,'ddd'로 하드코딩 되어있음.
		String id="sss";
		String pw="ddd";
		
		String reqUserId= reqData.get("userId");
		String reqUserpw= reqData.get("password");
		
		// 로그인 성공 시,
		if(id.equals(reqUserId) && pw.equals(reqUserpw)) {
			// 세션 생성
			userInfo.setUserId(reqUserId);
			userInfo.setUserNm(reqUserpw);
		} 
	}
}
