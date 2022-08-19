package com.practical.exam.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView homeIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home/home");
		return mav;
	}
	
}
