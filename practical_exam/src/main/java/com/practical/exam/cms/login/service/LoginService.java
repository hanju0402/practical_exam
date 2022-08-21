package com.practical.exam.cms.login.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.exam.cms.login.dao.LoginDao;
import com.practical.exam.common.auth.UserInfo;

@Service("loginService")
public class LoginService {
	

	@Resource
	private UserInfo userInfo;
	
	@Autowired
	private LoginDao loginDao;
	/**
	 * 로그인 처리 
	 * 
	 * @param reqData
	 * @return
	 */
	public void login(HashMap<String,String> reqData) {
		Map<String,String> reslt = loginDao.getUserInfo(reqData);
		
		// 로그인 성공 시,
		if(reslt != null) {			
			// 세션 생성
			userInfo.setUserId(reslt.get("userId"));
			userInfo.setUserNm(reslt.get("userNm"));
		}
	}
}
