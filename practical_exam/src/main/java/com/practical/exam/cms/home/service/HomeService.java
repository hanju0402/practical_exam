package com.practical.exam.cms.home.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.exam.cms.home.dao.HomeDao;
import com.practical.exam.common.auth.UserInfo;



@Service("homeService")
public class HomeService {
	
	@Autowired
	HomeDao homeDao;

	@Resource
	private UserInfo userInfo;
	
	public HashMap<String, Object> dash() {
		String userId = userInfo.getUserId();
		
		HashMap<String, Object> homeInfo = new HashMap<>();
		homeInfo.put("userName", userInfo.getUserNm());
		
		homeInfo.put("passPercent", homeDao.passPercent(userId));
		
		List<Map<String, Object>> barChart = homeDao.barChart(userId);
		HashMap<String, List<Object>> charts = new HashMap<String, List<Object>>();
		
		List<Object> score = new ArrayList<Object>();
		List<Object> testNum = new ArrayList<Object>();
		
		
		for (Map<String, Object> chart : barChart) {
			score.add(chart.get("score"));
			testNum.add(chart.get("testNum"));
		}
		charts.put("score", score);
		charts.put("testNum", testNum);
		
		homeInfo.put("barChart", charts);
		System.out.println("ddd/???" + homeInfo);
		
		return homeInfo;
		
	}
}
