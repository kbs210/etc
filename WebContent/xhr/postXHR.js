var xhr = null;
var arr = new Array();

function toServer(){
	var msg = document.getElementById("createform").msg.value;
	
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest;
	} else {
		xhr = new ActiveXObject("microsoft.XMLHTTP");
		}
	
	//get 방식
	//xhr.open("get", "command.jsp?msg=" + msg, true);
	//xhr.send();
	
	//post 방식
	xhr.open("POST", "command.jsp", true);
	//post이기 대문에 주소표시줄이 아닌 header에 담는다고 선언
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("msg="+msg);
	xhr.onreadystatechange = process;
}

function process(){
	
	if(xhr.readyState == 4 && xhr.status == 200){
		var disp = document.getElementById("disp");
		disp.innerHTML = xhr.responseText;		
	}
}