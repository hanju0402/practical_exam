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
		
		try{
			return 1;
		}catch (ek){
			console.log("JSON Validation Error");
			return 2;
		}
		console.log("JSON Validation Error");
		return 2;
	}
	
	return 0;
}

//POST 방식 데이터 전송 
function callPostData(url , jsonStr , callback){

	//호출한 데이터가 JSON이 아닌 경우, 실행하지 않음
	if(jsonValidation(jsonStr)==2){
		return ;
	}
	if(jsonValidation(jsonStr)==1){
		jsonStr = JSON.stringify(jsonStr);
	}
	
	var httpRequest = new XMLHttpRequest();
	
	httpRequest.open("POST", url , true);
	httpRequest.setRequestHeader('Content-Type', 'application/json');
	//send메소드에 인수 전달
	httpRequest.send(jsonStr);
	
	httpRequest.onreadystatechange = function(){
		if(httpRequest.readyState == XMLHttpRequest.DONE){
			let responseData = {
				"responseData":httpRequest.responseText,
				"responseCode":httpRequest.status
			};
			callback(responseData);
		}
	}
}


//POST 방식 데이터 전송 (parameter 없음)
function callPost(url,callback){
	var httpRequest = new XMLHttpRequest();
	
	httpRequest.open("POST", url , true);
	httpRequest.setRequestHeader('Content-Type', 'application/json');
	httpRequest.responseType = "json";
	//send메소드에 인수 전달
	httpRequest.send();
	
	httpRequest.onreadystatechange = function(){
		if(httpRequest.readyState == XMLHttpRequest.DONE){
			let responseData = {
				"responseData":httpRequest.responseText,
				"responseCode":httpRequest.status
			};
			callback(responseData);
		}
	}
}