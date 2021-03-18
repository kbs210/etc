function checkform(obj){
	if(obj.irum.value==""){
		alert("이름을 입력하세요");
		obj.irum.focus();
		return false;
	}
	
	if(obj.irum.value.length != 3){
		alert("이름을 정확히 입력하세요")
		obj.irum.focus();
		return false;
	}
	if(obj.siteUrl.value==""){
		alert("이동할 사이트를 선택하세요");
		obj.siteUrl.focus();
		return false;
	} else {
		document.getElementById("url").setAttribute("action",obj.siteUrl.value);
	}
	
	var flag1 = false;
	for(var i=0; i<obj.fruit.length; i++){
		if(obj.fruit[i].checked==true){
			flag1 = true;
		}
	}
	
	if(flag1 == false){
		alert("좋아하는 과일을 하나 선택하세요");
		obj.fruit[0].focus();
		return false;
	}
	
	var flag2 = false;
	
	for(var i=0; i<obj.interest.length; i++){
		if(obj.interest[i].checked !=""){
			flag2 = true;
		}
	}
	
	if(flag2 == false){
		alert("관심사를 하나 선택하세요");
		obj.interest[0].focus();
		return false;
	}
}

