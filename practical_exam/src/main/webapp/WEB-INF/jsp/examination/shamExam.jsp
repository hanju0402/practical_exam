<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/js/swiper.min.js"></script>

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
		let areas = document.getElementsByClassName('answerBox');
		let map = new Map();
	
 		let jsonStr = {
				"cycleNum": "aa",
				
				"questionA": [
		
				{ "1번": { "seq":2, "answer":["aaa", "bbb"] } },
				
				{"2번": { "seq":3, "answer":["ccc","ddd"] } }
		
				]
						
		}
 		
 		var arrayT = [];
 		
 		for(var i=0; i<4; i++) {
 			arrayT.push('name'+i);
 		}
 		
 		var keyt = arrayT[1];
 		alert('keyt:: ' + keyt);
 		
 		alert(jsonStr.questionA[0][keyt]);
 		
/*  		for(var ele in jsonStr) {
 			 console.log(jsonStr[ele].questionA)
 		}
 		 */
 		 
 		
 		
/*  		console.log(jsonStr);
 		console.log(jsonStr);
 		
 		for(var ele in i){
 	        for(var ele2 in i[ele]){
 	            console.log(i[ele][ele2]);
 	        } 
 	        console.log(i[ele].t_no);
 	        console.log(i[ele].t_content);
 	        console.log(i[ele].t_writer);
 	        console.log(i[ele].obtain);
 	        console.log(i[ele].t_date);
 	    }
 */
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
									<textarea id="answer-area" name="answer-area" class="answerBox" cols="50" rows="10"></textarea>
								</c:when>
								<c:otherwise>
									<c:forEach var="data" items="${data.qAnsType}" varStatus="status">
										<c:out value="${data}" />
										<input type="text" class="answerBox" style="width: 200px; height: 45px;" />
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
		<input type="hidden" id="testa" value="개줫같다" />
		<button onclick="markingAnswer()">제출하기</button>
	</div>

</body>
</html>