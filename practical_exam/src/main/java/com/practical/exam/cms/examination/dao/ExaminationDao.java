package com.practical.exam.cms.examination.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExaminationDao {
	
	//과목별 출제될 문제갯수
	List<Map<String,String>> getExaminationCnt();
	
	// 사용자 시험 회차
	int getUserTestCnt(String userId);
	
	//과목별 랜덤으로 문제 생성
	void setRandomExamination(Map<String,Object> params);
	
	// 사용자ID 및 TEST_NUM 으로 문제번호 RANDOM으로 변경
	void updateRandomNumExamination(Map<String,Object> params);
	
	// 1번 ~ 20번 정렬 후 LIST 출력
	List<Map<String,String>> getExamination(Map<String,Object> params);
}
