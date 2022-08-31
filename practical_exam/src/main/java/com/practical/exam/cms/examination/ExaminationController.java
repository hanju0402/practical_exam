package com.practical.exam.cms.examination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practical.exam.cms.examination.service.ExaminationService;

/**
 * 시험 화면 Controller  
 * 
 * @author adgjl
 *
 */
@Controller
@RequestMapping(value="/examination", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ExaminationController {
	

	@Autowired
	ExaminationService examinationService;

	@RequestMapping(value = "/shamExam", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/examination/shamExam");
		mav.addObject("examList",examinationService.getExamination());
		return mav;
	}
	
	@RequestMapping(value = "", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView mun() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/examination/index");
		return mav;
	}
	
	
}
