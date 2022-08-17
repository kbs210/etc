/**
 * 
 */
function boardCheck(obj){
	//alert("OK");	
}
function replyFunc(root, boardNumber, groupNumber, sequenceNumber, sequenceLevel){
	var url = root + "/board/write.do?boardNumber=" + boardNumber +
			"&groupNumber=" + groupNumber + "&sequenceNumber=" + sequenceNumber +
			"&sequenceLevel=" + sequenceLevel;
	//alert(url);
	
	location.href = url;
}
function delFunc(root, boardNumber, pageNumber){
	var url = root+ "/board/delete.do?boardNumber=" + boardNumber + "&pageNumber=" + pageNumber;
	//alert(url);
	
	location.href = url;
	/*var value = confirm("삭제하시겠습니까?");
	
	if(value == true){
		var url = root+ "/board/deleteOk.do?boardNumber=" + boardNumber + "&pageNumber=" + pageNumber;
		alert(url);
	}else{
		alert("취소되었습니다.");
	}*/
}
function updFunc(root, boardNumber, pageNumber){
	var url = root + "/board/update.do?boardNumber=" + boardNumber + "&pageNumber=" + pageNumber;
	//alert(url);
	
	location.href = url;
}