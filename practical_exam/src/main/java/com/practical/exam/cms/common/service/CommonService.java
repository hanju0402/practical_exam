package com.practical.exam.cms.common.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practical.exam.cms.common.dao.CommonDao;
import com.practical.exam.common.auth.UserInfo;

@Service("commonService")
public class CommonService {

	@Resource
	UserInfo userInfo;
	
	@Autowired
	CommonDao common;
	
	public ResponseEntity<Object> menuList() {
		return new ResponseEntity<>(common.getMenuList(userInfo),HttpStatus.OK);
	}
}
