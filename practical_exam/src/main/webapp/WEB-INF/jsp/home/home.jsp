<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>정보처리기사 실기 사이트</title>
<link href="home.css" rel="stylesheet" type="text/css">
<script>

	function signIn() {
		document.getElementById('signUpTxt').className = 'nonactive';
		document.getElementById('signInTxt').className = 'active';
	}
	
	function signUp() {
		document.getElementById('signUpTxt').className = 'active';
		document.getElementById('signInTxt').className = 'nonactive';
		
		 var input = document.createElement("input");
		 input.type = "text";
		 input.className = "css-class-name";
		
		
	}
	
	
	
</script>
</head>
<body>
	<div class="login">
		<h2 id="signInTxt" class="active" onclick='signIn()'>로그인</h2>
		<h2 id="signUpTxt" class="nonactive" onclick='signUp()'>회원가입</h2>
		<form>
			<input type="text" class="text" name="username"> <span>계정명</span>
			<br>
			<br> <input type="password" class="text" name="password"><span>비밀번호</span>
			
			
			<br> <input type="checkbox" id="checkbox-1-1"
				class="custom-checkbox" /> <label for="checkbox-1-1">로그인 유지</label>
			<button class="signin">로그인</button>
			<hr>
			<a href="#">비밀번호 찾기</a>
		</form>
	</div>
</body>
</html>