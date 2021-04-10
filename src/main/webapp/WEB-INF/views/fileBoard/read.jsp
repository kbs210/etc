<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>파일보드 읽기 페이지</title>
<link rel="stylesheet" href="${root}/css/board/boardStyle.css" />
<script type="text/javascript">
	function boardCheck(obj){
		//alert("OK");	
	}
	function replyFunc(root, boardNumber, groupNumber, sequenceNumber, sequenceLevel){
		var url = root + "/fileBoard/write.do?boardNumber=" + boardNumber +
				"&groupNumber=" + groupNumber + "&sequenceNumber=" + sequenceNumber +
				"&sequenceLevel=" + sequenceLevel;
		
		location.href = url;
	}
	function delFunc(root, boardNumber, pageNumber){
		var url = root+ "/fileBoard/delete.do?boardNumber=" + boardNumber + "&pageNumber=" + pageNumber;
		
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
		var url = root + "/fileBoard/update.do?boardNumber=" + boardNumber + "&pageNumber=" + pageNumber;		
		location.href = url;
	}
</script>
</head>
<body>
	<div id="createform">
		<div class="menu" style="border-bottom-width: 0px;"> 
			<div id="id">글번호</div>
			${boardDto.boardNumber}
		</div>
		
		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">작성자</div>
			${boardDto.writer}
		</div>
		
		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">조회수</div>
			${boardDto.readCount}
		</div>
		
		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">작성일</div>
			<fmt:formatDate value="${boardDto.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</div>

		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">제목</div>
			${boardDto.subject}
		</div>

		<div class="content" style="border-bottom-width: 0px;">
			<div id="text">내용</div>
			${boardDto.content}
		</div>
		
		<c:if test="${boardDto.fileSize!=0}">
			<div class="menu" style="border-bottom-width: 0px;">
				<div id="id">파일명</div>
				<a href="${root}/fileBoard/downLoad.do?boardNumber=${boardDto.boardNumber}">${boardDto.fileName}</a>
			</div>
		</c:if>

		<div class="menu" style="border-bottom-width: 3px; text-align: center;">
			<input type="button" value="글수정" onclick="updFunc('${root}','${boardDto.boardNumber}','${pageNumber}')"/>	
			<input type="button" value="글삭제" onclick="delFunc('${root}','${boardDto.boardNumber}','${pageNumber}')"/>	
			<input type="button" value="답글" onclick="replyFunc('${root}','${boardDto.boardNumber}','${boardDto.groupNumber}','${boardDto.sequenceNumber}','${boardDto.sequenceLevel}')"/>	
			<input type="button" value="글목록" onclick="location.href='${root}/fileBoard/list.do?pageNumber=${pageNumber}'"/>	
		</div>
	</div>
</body>
</html>