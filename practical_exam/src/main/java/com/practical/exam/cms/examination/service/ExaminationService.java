package com.practical.exam.cms.examination.service;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public List<Map<String,Object>> getExamination(){
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

		// 생성된 문제 리스트 
		List<Map<String,Object>> result = examinationDao.getExamination(params);
		
		// 문제 유형이 2개 이상 인풋란이 있어야 하는 문제인 경우,
		for (Map<String,Object> data : result) {
			Object ansType = data.get("qAnsType");
			
			
			if (ansType != null) {
				try {
					int ansTypeNum = Integer.parseInt((String)ansType);
					ArrayList<Integer> ansTypes = new ArrayList<Integer>();
					
					for(int i=1;i <= ansTypeNum;i++) {
						ansTypes.add(i);
					}
					data.put("qAnsType", ansTypes);
				} catch (NumberFormatException  e) {
					String[] ansTypesToArr= ((String)ansType).split(",");
					
					ArrayList<String> ansTypes = new ArrayList<String>();
					
					for(String ansTypeStr : ansTypesToArr) {
						ansTypes.add(ansTypeStr);
					}
					data.put("qAnsType", ansTypes);
				}
			}
		}
		
		return result;
	}
	
	public int marking(HashMap<String,Object> reqData) {
	
		// 유저가 입력한 답 DB에 입력
		int testNum = Integer.parseInt((String)reqData.get("testNum"));
		// 유저가 입력한 정답
		List<HashMap<String,Object>> markData = (List<HashMap<String,Object>>)reqData.get("markData");
		// 실제 정답
		List<Map<String, Object>> correctAnswers = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			int seq = Integer.parseInt((String)markData.get(i).get("seq"));
			ArrayList<String> userAnswer= (ArrayList<String>)markData.get(i).get("answer");
			String arrayToString = String.join(",", userAnswer);
			examinationDao.updateUserInputAnswer(testNum, seq, arrayToString);
			
			Map<String,Object> correctAnswer = examinationDao.correctAnswer(seq, i+1);
			correctAnswers.add(correctAnswer);

			
		}
		String str = "EAIss";
		String[] result = str.split(",");
		System.out.println("1번쨰" + result[0]);
		System.out.println("2번쨰" + result[1]);
		System.out.println("3번쨰" + result[2]);
		
		
		
		System.out.println("사용자 입력답ㅂㅂㅂㅂㅂ: " + markData);
		System.out.println("찾아아아아앙ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ카나나" + correctAnswers);
		correctAnswers.get(0).get("correctAnswer");
		
		return 1;
		
		
		
		
	}
	
}
