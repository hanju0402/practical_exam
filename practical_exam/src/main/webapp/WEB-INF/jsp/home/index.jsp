<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/common/barChart.js"></script>
<script>
	
	window.onload = function() {
		barChart('userWeekTestBarChart','최근 일주일 간의 기사시험 점수',[1,2,3,4,5,6,7],[1,2,3,4,5,5,6]);
		lineChart('userAvgLineChart', '과목별 회원 평균 점수와 사용자의 평균 점수', [1,2,3,4,5], '${homeInfo.userName}님', '회원 평균', [1,3,2,4,6],[1,2,5,3,4])
	}
	
	
</script>
</head>
<body>
	<div id="dashboard">
		<div id ="menuHeader">
			<h2>Dashboard</h2>
			<span id="userInfo">${homeInfo.userName}님 합격률 N %</span> <!-- 최근 5번의 시험으로 60점 이상을 받은 데이터로 계산. 0건인 경우, 확인이 필요 -->
			<div id="progessBar"></div> <!--  -->
		</div>
		<div id="fourCharts">
			<canvas id="userWeekTestBarChart"></canvas><!-- barChart 최근 일주일 간의 기사시험 점수 -->
			<canvas id="userAvgLineChart"></canvas>	<!-- lineChart 과목별 회원 평균 점수와 사용자의 평균 점수 -->
			<canvas id="userSubjectBarChart"></canvas> 	<!-- barChart 사용최근 3번의 시험 中 과목별 평균 점수 -->
			<canvas id="pieChart"></canvas>	<!-- pieChart 미정 -->
		</div>
	</div>
</body>
</html>