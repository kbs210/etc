<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${root}/JavaScript/jquery.js"></script>
<script type="text/javascript" src="${root}/JavaScript/replyWrite.js"></script>
</head>
<body>

	<div>실시간 댓글이 가능합니다</div>
	<br>
	<br>
	<div>
		<input id="writeReply" type="text" name="write" size="50"> <input
			type="button" value="전송" onclick="writeToServer('${root}')">
	</div>
	<br>
	<div id="ListAllDiv">
		<c:forEach var="replyDto" items="${replyList}">
			<div id="replyDiv" id="${replyDto.bunho}">
				<span class="cssBunho">${replyDto.bunho}</span>
				<span class="cssReply">${replyDto.line_reply}</span>
				<span class="cssIP">${replyDto.user_ip}</span>
				<span class="cssUpdel">
					<a href="#">삭제 &nbsp</a>
					<a href="#">수정</a>
				</span>
				
			</div>
		</c:forEach>
	</div>



</body>
</html>