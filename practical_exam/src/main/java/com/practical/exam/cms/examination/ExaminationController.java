package com.practical.exam.cms.examination;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/shamExam", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(@RequestParam HashMap<String,String> reqData) {
		ModelAndView mav = new ModelAndView();
		if(reqData.get("hiddenData") == null) {
			mav.setViewName("redirect:/examination");
		} else {
			System.out.println("히든데이터???  " + reqData.get("hiddenData"));
			mav.setViewName("/examination/shamExam");
			mav.addObject("examList",examinationService.getExamination());
		}
		return mav;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView mun() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/examination/index");
		return mav;
	}
	
	@RequestMapping(value = "/marking", method = {RequestMethod.POST})
	public ModelAndView marking(@RequestParam HashMap<String,String> reqData) {
		ModelAndView mav = new ModelAndView();
	
		System.out.println("정답아레아???  " + reqData.get("answer-area"));
		
			mav.setViewName("/examination/marking");
		
		return mav;
	}
	
	
	
	
}
