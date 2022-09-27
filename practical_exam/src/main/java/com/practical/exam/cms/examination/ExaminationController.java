package com.practical.exam.cms.examination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@RequestMapping(value = "/marking", method = RequestMethod.POST, consumes="application/json;")
	public ModelAndView marking(@RequestBody HashMap<String,Object> params) {
		
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/examination/marking");
		mav.addObject("markingList", examinationService.marking(params));
		
		return mav;
	}
	
	
	
	
}
