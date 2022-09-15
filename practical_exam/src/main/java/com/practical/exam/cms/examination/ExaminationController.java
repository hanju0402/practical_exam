package com.practical.exam.cms.examination;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practical.exam.cms.examination.service.ExaminationService;

import net.sf.json.*;



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
	
	@RequestMapping(value = "/marking", method = RequestMethod.POST)
	public ModelAndView marking(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String jsonStr = request.getParameter("jsonEle");
		
		JSONArray jsonArr = new JSONArray();
		
		  // 문자열 형식의 데이터를 JSONArray로 가공
	    jsonArr =  JSONArray
	    
		// 데이터의 길이만큼 반복 및 JSONObject로 변환하며 확인
	    for(int i=0;i<jsonArr.size();i++){
	    	JSONObject jsonObj = jsonArr.getJSONObject(i);
	        System.out.println("id : "+jsonObj.get("id")+", addr"+jsonObj.get("addr"));
	    }
		mav.setViewName("/examination/marking");
		
		System.out.println("정답아레아???  " + params);
		
		
		return mav;
	}
	
	
	
	
}
