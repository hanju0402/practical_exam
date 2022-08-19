<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보처리기사 실기 사이트</title>
<link href="home.css" rel="stylesheet" type="text/css">
<script>

	function signIn() {
		document.getElementById('signUpTxt').className = 'nonactive';
		document.getElementById('signInTxt').className = 'active';
		
		
		const box = document.getElementById("pwDivId");
		box.remove();
		document.getElementById("findPw").style.display = "";
		document.getElementById("keepLogin").style.display = "";
		document.getElementById("keepLoginTxt").style.display = "";
		
		let x = document.getElementById("signin");
	    x.innerText="로그인"; 
	}
	
	function signUp() {
		
		if (document.getElementById('signUpTxt').className != 'active') {
			const box = document.getElementById("passwordDiv");
	       	const newP = document.createElement('div');
	        newP.innerHTML = "<input type='password' class='text' name='passwordChk'><span>비밀번호 확인</span>";
	        newP.id = 'pwDivId';
	        box.appendChild(newP);
	        document.getElementById("findPw").style.display = "none";
	        document.getElementById("keepLogin").style.display = "none";
	        document.getElementById("keepLoginTxt").style.display = "none";
	        
	        let x = document.getElementById("signin");
	        x.innerText="회원가입"; 
		} 
		
		document.getElementById('signUpTxt').className = 'active';
		document.getElementById('signInTxt').className = 'nonactive';
		
	}
	
	
	
</script>
</head>
<body>
	<div class="login">
		<h2 id="signInTxt" class="active" onclick='signIn()'>로그인</h2>
		<h2 id="signUpTxt" class="nonactive" onclick='signUp()'>회원가입</h2>
		<form>
			<input type="text" class="text" name="username"> <span>계정명</span>
			<input type="password" class="text" name="password"><span>비밀번호</span>
			<div id="passwordDiv"></div>
			<input type="checkbox" id="keepLogin" class="custom-checkbox" /><label id="keepLoginTxt" for="keepLogin">로그인 유지</label>
			<button id="signin" class="signin">로그인</button>
			<hr>
			<a id="findPw" href="#">비밀번호 찾기</a>
		</form>
	</div>
</body>
</html>