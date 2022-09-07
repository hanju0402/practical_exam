<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모의 시험</title>


<script defer type="text/javascript" src="/js/common/shamExam.js"></script>

<link href="/css/shamExamStyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/common/ajax.js"></script>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/js/swiper.min.js"></script>

</head>
<body onbeforeunload="return '해당 화면을 벗어나는 경우, 즉시 제출됩니다. 괜찮으십니까?';">
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<c:forEach var="data" items="${examList}" varStatus="status">

				<div class="swiper-slide">

					<div class="slide-inner">
						<div id="question-txt">${data.qNo}. ${data.qTitle}</div>

						<c:choose>
							<c:when test="${empty data.imgUrl }">
								<div class="question-picture-box">${data.qContent}</div>								
							</c:when>
							<c:otherwise>
								<div class="question-picture-box">
									<img src="${data.imgUrl}" alt="실기 문제 ">
								</div>
							</c:otherwise>
						</c:choose>
						<div>
							<p>정답</p>
							<textarea id="answer-area" cols="50" rows="10"></textarea>
						</div>
						
						
						
					</div>

				</div>
			</c:forEach>
		</div>

		<div class="swiper-button-next swiper-button-black"></div>
		<div class="swiper-button-prev swiper-button-black"></div>
		
	</div>

	<div id="pagination" class="swiper-pagination"></div>
	<div class="copy">
		<button id="submit">제출하기</button>
	</div>

</body>
</html>