<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모의 시험</title>


<script defer type="text/javascript" src="/js/common/shamExam.js"></script>

<link href="/css/shamExamStyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/common/ajax.js"></script>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/css/swiper.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/js/swiper.min.js"></script>

<script>
	function markingCallback(response) {

		if (response.responseCode == 200) {
			alert("성공" + response.responseData);
			window.location.href = '/examination/marking';
		} else {
			alert("답전송 오류" + response.responseData);

		}

	}

	function markingAnswer() {

		var areas = document.getElementsByClassName('answerBox');
		
		var map = new Map();

		<c:forEach var="a" items="${examList}" varStatus="status">

/* 		map.put("회차", "${a.testNum}"");
		map.put("${a.qNo}", areas) */
		alert("${a.qAnsType}.length");
		
		</c:forEach>

/* 		for (i = 0; i < areas.length; i++) {
			
			
		} */
		
		
		
		var answers = new Array();
		
/* 		for (i = 0; i < areas.length; i++) {

			map.put("회차", ${testNum})
			answers.push(areas[i].value);
		}

		let jsonStr = JSON.stringify(answers);

		alert(jsonStr);

		callPostData('/examination/marking', jsonStr, markingCallback); */



	}
</script>

</head>
<body>
	<div class="swiper-container">

		<div class="swiper-wrapper">
			<c:forEach var="data" items="${examList}" varStatus="status">

				<div class="swiper-slide">

					<div class="slide-inner">
						<div id="question-txt">${data.qNo}.${data.qTitle}</div>

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
							<p>정답 ${data.testNum}, 시퀀스${data.qSeq}</p>

							<c:choose>
								<c:when test="${data.qAnsType == null }">
									<textarea id="answer-area" name="answer-area" class="answerBox"
										cols="50" rows="10"></textarea>
								</c:when>
								<c:otherwise>
									<c:forEach var="data" items="${data.qAnsType}"
										varStatus="status">
										<c:out value="${data}" />
										<input type="text" class="answerBox"
											style="width: 200px; height: 45px;" />
									</c:forEach>
								</c:otherwise>
							</c:choose>


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
		<button onclick="markingAnswer()">제출하기</button>
	</div>

</body>
</html>