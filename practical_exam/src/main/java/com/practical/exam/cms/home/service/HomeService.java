package com.practical.exam.cms.home.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.exam.cms.home.dao.HomeDao;
import com.practical.exam.common.auth.UserInfo;



@Service("homeService")
public class HomeService {
	
	@Autowired
	HomeDao homeDao;

	@Resource
	private UserInfo userInfo;
	
	public HashMap<String, Object> dash() {
		String userId = userInfo.getUserId();
		
		HashMap<String, Object> homeInfo = new HashMap<>();
		homeInfo.put("userName", userInfo.getUserNm());
		
		int passPercent = homeDao.passPercent(userId);
		System.out.println("합격률??" + homeDao.passPercent(userId));
		return homeInfo;
		
	}
}
