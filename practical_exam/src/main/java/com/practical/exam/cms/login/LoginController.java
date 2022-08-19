package com.practical.exam.cms.login;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practical.exam.cms.login.service.LoginService;
import com.practical.exam.common.auth.UserInfo;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Resource
	private UserInfo userInfo;
	/**
	 * 로그인 페이지 이동
	 * 해당 URL로 접근 시, 세션 여부 확인 후, 
	 * LOGIN 페이지 OR 메인 페이지로 노출하는 로직 개발 필요
	 * 
	 * @return LOGIN 화면(세션x) , MainPage(세션o)
	 */
    @RequestMapping(value="/", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView();
		if(userInfo.getUserId() == null) {
			mav.setViewName("/login/index");			
		} else {
			mav.setViewName("/home/index");
		}
		
		return mav;
	}
	
	/**
	 * 로그인 
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam HashMap<String,String> params) {
		loginService.login(params);
		return "redirect:/";
	}
	
	
}
