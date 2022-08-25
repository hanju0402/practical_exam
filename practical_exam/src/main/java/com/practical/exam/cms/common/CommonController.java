package com.practical.exam.cms.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practical.exam.cms.common.service.CommonService;

@Controller
@RequestMapping(value="/common", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CommonController {

	@Autowired
	CommonService commonService;
	/**
	 * 현재 로그인 한 사용자의 계정 정보를 조회하여, 권한에 맞는 화면 리스트 return
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/menuList", method = RequestMethod.POST)	
	public ResponseEntity<Object> menuList() {
		return commonService.menuList();
	}
}
