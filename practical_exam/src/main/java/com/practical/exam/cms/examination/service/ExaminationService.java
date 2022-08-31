package com.practical.exam.cms.examination.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.exam.cms.examination.dao.ExaminationDao;
import com.practical.exam.common.auth.UserInfo;

@Service("examinationService")
public class ExaminationService {
	
	@Resource
	UserInfo userInfo;
	
	@Autowired
	ExaminationDao examinationDao;
	
	public List<Map<String,String>> getExamination(){
		// 과목별 출제될 문제 갯수
		List<Map<String,String>> examCntList = examinationDao.getExaminationCnt();
		
		//사용자의 회차 조회 ( 갯수 + 1)
		int testNum = examinationDao.getUserTestCnt(userInfo.getUserId());
		
		// 랜덤 문제 20개 생성을 위한 params 기입
		HashMap<String,Object> params = new HashMap<String,Object>();
		
		params.put("testNum",testNum);
		params.put("userId", userInfo.getUserId());
		
		// 신규 문제 생성
		for (Map<String,String> data : examCntList) {
			params.put("q_type", data.get("q_type"));
			params.put("q_cnt", data.get("q_cnt"));
			examinationDao.setRandomExamination(params);
		}
		// 문제 넘버 랜덤으로 변경
		examinationDao.updateRandomNumExamination(params);
		
		// 생성된 문제 리스트 반환
		return examinationDao.getExamination(params);
	}
	
}
