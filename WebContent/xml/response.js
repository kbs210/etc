var xhr = null;
var arr = new Array();

function startRequest(){
	/*alert("버튼누름")*/
	

	
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest;
	} else {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xhr.open("GET", "response.xml", true);
	xhr.send();
	xhr.onreadystatechange = process;
}

function process(){
	debugger;
	if(xhr.readyState==4 && xhr.status==200){
		//xml데이터를 받아왔는지 확인
		alert(xhr.responseXML);
	
	// XML데이터를 그대로 받아옴, json과 달리 변환할 필요가 없음
	/*var data = JSON.parse(xhr.responseText);*/
	var xmlDoc = xhr.responseXML;
	
	//tag이름이 student인 데이터 배열을 studentList에 담음
	var studentList = xmlDoc.getElementsByTagName("student");
	
	var disp = document.getElementById("disp");
	
	for(var i=0; i<studentList.length; i++){
		var student = studentList[i];
		
		//자식에 대한 속성을 꺼내옴
		var subElement = student.children;
		
		var div = document.createElement("div");
		
		for(var j=0; j<subElement.length; j++){
			
			var span = document.createElement("span");
			span.innerHTML = subElement[j].childNodes[0].nodeValue + "&nbsp";
			
			div.appendChild(span);
			
			}
				disp.appendChild(div);
		}
		
	
		
	}
	
	

}














