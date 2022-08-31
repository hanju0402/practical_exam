<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모의 시험</title>


<script defer type="text/javascript" src="/js/common/shamExam.js"></script>

<link href="/css/shamExamStyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/common/ajax.js"></script>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/css/swiper.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/js/swiper.min.js"></script>


</head>
<body>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<div class="slide-inner"
					style="background-image: url(https://mblogthumb-phinf.pstatic.net/MjAxODAzMTFfOSAg/MDAxNTIwNzE1NzE3NjI4.y_QwGKV-kEtog6M_ROz2J2FyZhFVF1Qe42_jftAFw_Ag.dT8gI-dJeOCwEzcHj7GxV0xZ1Nzybhh815BWuiaZL-8g.PNG.osy2201/35.png?type=w800)">
					
					<div id="question-txt">
					문제텍스트
					</div>
					<div class="question-picture-box">
					<img class="question-picture" src="../practice_img/2020_4/13.PNG">
					</div>
					<div>
					<p>정답</p>
					<textarea id="answer-area"cols="50" rows="10" onfocus="textClear(this.id)" onblur="answerRequestTxt(this.id)"></textarea>
					</div>
						
					

				</div>

			</div>
			<div class="swiper-slide">
				<div class="slide-inner"
					style="background-image: url(https://mblogthumb-phinf.pstatic.net/MjAxODAzMTFfOSAg/MDAxNTIwNzE1NzE3NjI4.y_QwGKV-kEtog6M_ROz2J2FyZhFVF1Qe42_jftAFw_Ag.dT8gI-dJeOCwEzcHj7GxV0xZ1Nzybhh815BWuiaZL-8g.PNG.osy2201/35.png?type=w800)"></div>
			</div>
			<div class="swiper-slide">
				<div class="slide-inner"
					style="background-image: url(https://pp.userapi.com/c637331/v637331691/48f5f/spHnV42iYVw.jpg)"></div>
			</div>

		</div>
		<div class="swiper-button-next swiper-button-black"></div>
		<div class="swiper-button-prev swiper-button-black"></div>
	</div>

	<div class="copy">
		Photos by <a target="_blank" href="https://500px.com/udovichenko">Dmitry
			Udovichenko</a>
		<button id="data-toggle">toggle</button>
	</div>

</body>
</html>