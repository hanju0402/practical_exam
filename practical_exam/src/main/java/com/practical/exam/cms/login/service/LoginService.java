package com.practical.exam.cms.login.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
	/**
	 * 회원가입 신청
	 * 
	 * @param reqData
	 * @return
	 */
	public ResponseEntity<Object> signUp(HashMap<String,String> reqData) {
		
		// 아이디 중복여부 확인
		
		String result = "해당 계정 중복입니다. 다시 가입해주세요.";
		
		if(!loginDao.idDuplicated(reqData)) {			
			loginDao.addUserInfo(reqData);
			result = "회원가입 성공하셨습니다 !";
			return new ResponseEntity<>(result,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(result,HttpStatus.FAILED_DEPENDENCY);
		}
	}
	
	
	
}
