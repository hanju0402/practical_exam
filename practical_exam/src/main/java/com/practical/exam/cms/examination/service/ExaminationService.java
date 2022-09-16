package com.practical.exam.cms.examination.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.assembler.MethodExclusionMBeanInfoAssembler;
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
	
	public String getUserId() {
		return userInfo.getUserId();
	}
	
	// 채점시 testCnt 가져오기
	public int getTestCnt(String userId) {
		int testCnt = examinationDao.getUserTestCnt(userId) - 1;
		return testCnt;
	}
	
	// 출제된 20문제의 각각의 seq 가져오기
	public List<Map<String,Object>> getAnswerSeq(String userId, int testCnt) {
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		params.put("testCnt", testCnt);
		System.out.println(examinationDao.getAnswerSeq(params));
		return examinationDao.getAnswerSeq(params);
	}
	
	// seq를 이용하여 각각문제의 실제 정답 List 가져오기
	public List<String> getAnswer(List<Map<String,Object>> seqList) {
		
		List<String> answers = new ArrayList<>();
		for (int i = 0; i < seqList.size(); i++) {
			String answer = examinationDao.getAnswer((Integer)seqList.get(i).get("seq"));
			answers.add(answer);
		}
		System.out.println("이것만되면된다  " + answers);
		return answers;
		
	}
	
}
