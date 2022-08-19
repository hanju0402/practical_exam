package com.practical.exam.cms.home.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.exam.common.auth.SessionUtils;

@Service("homeService")
public class HomeService {
	
	@Autowired
	SessionUtils session;
	/**
	 * 로그인 처리 
	 * 
	 * @param reqData
	 * @return
	 */
	public void login(HashMap<String,Object> reqData) {
		// DB가 없으므로 , 'sss' ,'ddd'로 하드코딩 되어있음.
		String id="sss";
		String pw="ddd";
		
		String reqUserId= reqData.get("username").toString();
		String reqUserpw= reqData.get("password").toString();
		
		// 로그인 성공 시,
		if(id.equals(reqUserId) && pw.equals(reqUserpw)) {
			// 세션 생성
			HashMap<String,String> reqInfo = new HashMap<String,String>();
			session.setSession(reqInfo);
		} 
	}
}
