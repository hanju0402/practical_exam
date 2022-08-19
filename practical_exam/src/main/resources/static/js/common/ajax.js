/**
 * AJAX 전송 공통 모듈 
 *
 * jsonValidation(jsonStr) : JSON 검증
 * callPostData(url, jsonStr) : POST방식의 데이터 전송 (parameter가 없는 경우, JSON Parsing Exception)
 * callPost(url) : POST방식의 데이터 전송 (Parameter 기입 받지 않음)
 * 
 * @author : 이동준 (blog.naver.com/adgjl1125 )
 */

//JSON String 검증
function jsonValidation(jsonStr){
	// json 검증
	try { 
		JSON.parse(jsonStr);
	} catch (e) {
		console.log("JSON Validation Error");
		return false;
	}
	
	return true;
}

//POST 방식 데이터 전송 
function callPostData(url , jsonStr){

	//호출한 데이터가 JSON이 아닌 경우, 실행하지 않음
	if(!jsonValidation(jsonStr)){
		return ;
	}
	
	var httpRequest = new XMLHttpRequest();
	
	httpRequest.open("POST", url , true);
	httpRequest.setRequestHeader('Content-Type', 'application/json');
	//send메소드에 인수 전달
	httpRequest.send(jsonStr);
	
	httpRequest.onreadystatechange = function(){
		// 요청과 응답에 성공했을 때
		if(httpRequest.readyState == XMLHttpRequest.DONE){
			// 응답 값을 받아온다.
			if(httpRequest.status == 200){
				console.log(httpRequest);
				return httpRequest.responseText;
			} else {
				alert("서버 에러!!");
				console.log(httpRequest);
				return ;
			}
		}
	}
}

//POST 방식 데이터 전송 (parameter 없음)
function callPost(url){
	var httpRequest = new XMLHttpRequest();
	
	httpRequest.open("POST", url , true);
	httpRequest.setRequestHeader('Content-Type', 'application/json');
	httpRequest.responseType = "json";
	//send메소드에 인수 전달
	httpRequest.send();
	
	httpRequest.onreadystatechange = function(){
		if(httpRequest.readyState == XMLHttpRequest.DONE){
			// 요청과 응답에 성공했을 때
			if(httpRequest.status == 200){
				console.log(httpRequest);
				return httpRequest.response.hi;
			} else {
				alert("서버 에러!!");
				console.log(httpRequest);
				return ;
			}
		}
	}
}