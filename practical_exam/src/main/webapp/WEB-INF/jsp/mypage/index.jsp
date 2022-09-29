<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보처리기사 실기 사이트</title>
<script type="text/javascript" src="js/common/ajax.js"></script>
<script>
	
</script>
</head>
<body>
	<div>
		<h2 id="signInTxt">${userNm}님 정보 변경</h2>
		<form onsubmit="return false" id="dataForm" method="post">
			<input type="password" class="text" id="password" name="password"><span>현재 비밀번호</span>
			<input type="password" class="text" id="newPassword" name="newPassword"><span>변경 비밀번호</span>
			<input type="password" class="text" id="newPasswordChk" name="newPasswordChk"><span>변경 비밀번호 확인</span>
			<button type="button" class="signin" onclick="changeMyInfo()">정보 변경</button>
			<hr id="bottomLine">
		</form>
	</div>
</body>
</html>