/**
 * 
 */

function createXHR(){
	if(window.XMLHttpRequest){
		return new XMLHttpRequest()
	} else {
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
}

var xhr = null;
var arr = new Array();

function sendRequest(method, url, params, callback){
	//callback함수
	//파라미터로 함수를 전달해 해당 함수 내부에서 실해되는 함수
	
	var httpMethod = method.toUpperCase();
	var httpUrl = url;
	var httpParams = (params==null||params=="") ? null : params;
	
	if(httpMethod=="GET" && httpParams!=null){
		httpUrl += "?" + httpParams;
	}
	
	arr.push(httpMethod + "," + httpUrl + "," + httpParams);
	
	xhr = createXHR();
	xhr.open(httpMethod, httpUrl, true);
	
	//post일수도 있기에 post일 때는
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	//kakao map api 사용하기 위한 헤더 설정
	xhr.setRequestHeader("Authorization", "KakaoAK f793350b2be5d31eb0f59052e9531f74");
	
	xhr.send(httpMethod=="POST"?httpParams:null);
	xhr.onreadystatechange = callback;
	
}