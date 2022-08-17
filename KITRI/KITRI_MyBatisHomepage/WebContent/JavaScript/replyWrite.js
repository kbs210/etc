/**
 * 
 */

var arr = new Array();
var root = null;

function writeToServer(requestRoot){
	root = requestRoot;
	var writeReply = $("#writeReply").val();
	var param = "writeReply=" + writeReply;
	var url = root + "/reply/replyWrite.do?" + param; 

	arr.push(url);
	alert(arr);
	
	$.ajax({
		url: url,
		type: "GET",
		dataType: "text",
		success: writeProcess
	})
	
	function writeProcess(data){
		var obj = $.parseJSON(data);
		arr.push(obj.bunho);
		arr.push(obj.line_Reply);
		arr.push(obj.user_ip);
		
		alert(arr.join("\n"));
		
		var bunho = obj.bunho;
		var reply = obj.line_reply;
		var user_ip = obj.user_ip;
		
		$("#writeReply").val("");
		
		var newReplyText = "<div class = 'replyDiv' id='" + bunho + "'>";

			newReplyText += "<span class = 'cssBunho'>" + bunho + "</span>";
			newReplyText += "<span class = 'cssReply'>" + reply + "</span>";
		
			newReplyText += "<span class = 'cssUpDel'>";
				newReplyText += "<a href='javascript:deleteToServer("+ bunho + ",\"" + root + ")'>삭제</a>&nbsp";
				newReplyText += "<a href='javascript:selectToServer()'>수정</a>&nbsp";
			newReplyText += "</span>";
		newReplyText += "</div>";
		
		$("#ListAllDiv").prepend(newReplyText);
	}
		
}