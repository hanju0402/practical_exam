package com.practical.exam.home;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	/**
	 * 로그인 페이지 이동
	 * 차후, '/' URL로 접근 시, 세션 여부 확인 후, LOGIN 페이지 OR 메인 페이지로 노출하는 로직 개발 필요
	 * 
	 * @return LOGIN 화면(세션x) , MainPage(세션o)
	 */
	@RequestMapping(value="/", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home/home");
		return mav;
	}
	
	/**
	 * 로그인 이벤트 발생 
	 * 
	 * @param params
	 * @return
	 */
	@PostMapping("/login")
	@ResponseBody
	public ModelAndView login(@RequestParam HashMap<String, Object> params) {
		System.out.println("params ==>"+params);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home/home");
		return mav;
	}
}
