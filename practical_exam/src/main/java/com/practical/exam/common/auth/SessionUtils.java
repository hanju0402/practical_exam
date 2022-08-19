package com.practical.exam.common.auth;

import java.util.HashMap;

import javax.annotation.Resource;

/**
 * 세션 관리 유틸리티
 * 
 * @author adgjl
 *
 */
public class SessionUtils {
	@Resource
	private UserInfo userInfo;
	
	/**
	 * 세션 정보 가져오기
	 * @return
	 */
	public UserInfo getSessionInfo() {
		return this.userInfo;
	}
	
	/**
	 * 세션이 살아있는지 확인
	 * 
	 * 차후 로직 수정 필요
	 * @return
	 */
	public boolean sessionExist() {
		if(userInfo.getUserId()==null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	/**
	 * 세션 등록
	 * 
	 * 차후 로직 수정 필요
	 * @param sessionInfo
	 */
	public void setSession(HashMap<String,String> sessionInfo) {
		userInfo.setUserId(sessionInfo.get("userId"));
		userInfo.setUserId(sessionInfo.get("password"));
	}
	
}
