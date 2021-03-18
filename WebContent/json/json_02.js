var xhr = null;

var arr = new Array;

function toServer(){
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest;
	} else {
		//익스플로러 구버전에서 사용(5?6?)
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	/*alert(xhr.readyState);*/
	
	
	//open메소드는 서버로 보낼 요청의 형식을 설정(전달방식,URL주소,동기여부)
	xhr.open("GET", "json_02.txt", true);
	
	//서버로 전달
	//get
	xhr.send();
	
	//post
	//xhr.send(queryString);
	
	//readyState 값이 변할때마다 호출되는 속성
	//process는 callback함수 ()없음
	xhr.onreadystatechange = process;
	
	function process(){
		debugger;
		if(xhr.readyState==4 && xhr.status==200){
			
		//잘 들어 왔는지 출력해보기
			/*arr.push(xhr.responseText);
			alert(arr[0]);*/
			
		//응답 받은 json_02.txt의 데이터를 json데이터로 변환하여 obj에 입력
		var data = JSON.parse(xhr.responseText);
		
		//화면에 위치한 id="disp"인 div의 정보를 가져온다
		var disp = document.getElementById("disp");
		
		//새롭운 div를 생성
		var divName = document.createElement("div");
		
		//새롭게 만들어진 div인 divName에 obj가 가진 name 입력
		divName.innerHTML = data.name;
		
		var divAge = document.createElement("div");
		divAge.innerHTML = data.age;
		
		//disp에 divName과divage를 자식요소로 넣어준다
		disp.appendChild(divName);
		disp.appendChild(divAge);
		
		//배열로 존재하는 데이터를 반복문을 통해 데이터를 얻어온다
		for(var i=0; i<data.cars.length ; i++){
			var ul = document.createElement("ul");
			var li = document.createElement("li");
			li.innerHTML = data.cars[i].name;
			ul.appendChild(li);
			disp.appendChild(ul);
			for(var j=0; j<data.cars[i].model.length; j++){
				var ul2 = document.createElement("ul");
				var li2 = document.createElement("li");
				li2.innerHTML = data.cars[i].model[j];
				ul2.appendChild(li2);
				li.appendChild(ul2);
			}
		}
		
		}
	}
}





















