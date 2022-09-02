<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제 1</title>
<link href="css/examIndex.css" rel="stylesheet" type="text/css">

<script>
	function start() {
		document.getElementById("actionFrm").submit();
	}
</script>
</head>
<body>
	<div class="flex">

		<p>문제풀기 버튼을 누르면 무작위 20문제가 출제됩니다.</p>
		<form id="actionFrm" action="/examination/shamExam" method="post">
			<input type="hidden" id="hiddenData" value="OK">
			<button class="testStart" type="button" onclick="start()">문제풀기</button>
		</form>
	</div>



</body>
</html>