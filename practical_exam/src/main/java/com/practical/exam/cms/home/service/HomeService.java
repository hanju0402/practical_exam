package com.practical.exam.cms.home.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.practical.exam.common.auth.UserInfo;

@Service("homeService")
public class HomeService {

	@Resource
	private UserInfo userInfo;
}
