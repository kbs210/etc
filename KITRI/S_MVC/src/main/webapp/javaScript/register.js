function createFrom(obj){

	check = false;
	var str="";
	for(var i=0; i<obj.interest.length; i++){
		if(obj.interest[i].checked==true){
			str+=obj.interest[i].value + ",";
		}
		
	}	
	obj.resultInterest.value=str;
	
}
