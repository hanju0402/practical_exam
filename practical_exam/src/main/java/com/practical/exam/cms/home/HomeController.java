package com.practical.exam.cms.home;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practical.exam.cms.home.service.HomeService;
import com.practical.exam.common.auth.UserInfo;

@Controller
public class HomeController {
	
	@Autowired
	HomeService homeService;
	
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
			System.out.println("세션 없음");
			mav.setViewName("/home/home");			
		} else {
			System.out.println("로그인 계정 세션 정보 ===>"+userInfo.getUserId());
			mav.setViewName("/home/home");
		}
		
		return mav;
	}
	
	/**
	 * 로그인 이벤트 발생 
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam HashMap<String,String> params) {
		homeService.login(params);
		return "redirect:/";
	}
}
