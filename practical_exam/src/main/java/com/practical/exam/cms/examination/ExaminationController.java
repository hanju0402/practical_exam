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
	public ModelAndView marking(@RequestBody List<String> params) {
		String userId = examinationService.getUserId();
		int testCnt = examinationService.getTestCnt(userId);
		List<Map<String,Object>> seq = examinationService.getAnswerSeq(userId, testCnt);
		List<String> answer = examinationService.getAnswer(seq);
		ModelAndView mav = new ModelAndView();
				
		mav.setViewName("/examination/marking");
		System.out.println("seq list??" + seq);
		System.out.println("seq intdex??" + (Integer)seq.get(0).get("seq"));
		System.out.println("현재 회차는???" + testCnt);
		System.out.println("현재 아이디는???" + userId);
		System.out.println("정답아레아???  " + params);
		System.out.println("문제정답 리스트" + answer);
		System.out.println("1번문제 제출답??" + params.get(0));
		System.out.println("1번문제 실제정답??" + answer.get(0));
		
		
		return mav;
	}
	
	
	
	
}
