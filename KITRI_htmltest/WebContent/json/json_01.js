

var xhr = null;
var arr = new Array;

function toServer(){
	
	//request 생성
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest;
	} else {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}

	//데이터 읽어오기
	//open 함수를 사용하여 request객체를 open을 통해 초기화 후 데이터 로드
	
	xhr.open("GET", "json_01.txt", true);
	
	//해당데이터를 보내기
	//데이터 요청
	
	xhr.send();
	
	//받은 데이터를 가공하여 사용자에게 전달
	//결과에 따라 가공된 데이터를 받아들이는 속성
	//readystate는
	
	/*
		0 - 요청을 만들었지만 open을 통해 초기화 하지 않은 상태
		1 - 객체를 만들고 초기화 했지만 send를 통해 요청하기 전
		2 - send를 사용해 요청하고 난 직후
		3 - 데이터가 일부 도착
		4 - 모든데이터 도착
	*/
	
	xhr.onreadystatechange = resultProcess;
}

	/*
	readyState가 4라고 하더라도 데이터가 제대로 로드된것인지 알 수 가 없다
	요청 url에서 에러가 난 경우 http status code를 참조해서 판단해야한다
	100대 - 처리중
	200대 - 성공
	300대 - redirect(페이지 이동 중)
	400대 - 클라이언트 오류(사용자측) -> Bad Request
	500대 - 서버오류 -> Internal Server Error
	*/
	
		
function resultProcess(){
	if(xhr.readyState==4 && xhr.status==200){
		//상태가 정상임으로 화면 생성
		
									//json_01.txt
		var obj = JSON.parse(xhr.responseText)
		
		var disp = document.getElementById("disp");
		
		var ul = document.createElement("ul");
		
		var liNode1 = document.createElement("li");
		liNode1.innerHTML = obj.name;
		var liNode2 = document.createElement("li");
		liNode2.innerHTML = obj.age;
		var liNode3 = document.createElement("li");
		liNode3.innerHTML = obj.height;
		
		ul.appendChild(liNode1);
		ul.appendChild(liNode2);
		ul.appendChild(liNode3);
		
		disp.appendChild(ul);
	}
	
}

