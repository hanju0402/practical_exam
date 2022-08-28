package com.practical.exam.cms.examination;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 시험 화면 Controller  
 * 
 * @author adgjl
 *
 */
@Controller
@RequestMapping(value="/examination", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ExaminationController {
	
	
	@RequestMapping(value = "", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/examination/index");
		return mav;
	}
	
	
}
