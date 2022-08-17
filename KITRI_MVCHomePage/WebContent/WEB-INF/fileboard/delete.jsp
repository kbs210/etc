<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/css/board/boardStyle.css">
<script type="text/javascript" src="${root}/javaScript/fileboard/board.js"></script>
</head>
<body>
	<form id="createform" name="createform"
		action="${root}/fileboard/deleteOk.do?pageNumber=${pageNumber}" method="post"
		onsubmit="return delFunc(this)">
		<h2 align="center">아래 게시글을 삭제하시겠습니까?</h2>
		<div id="createform">
			<div class="menu" style="border-bottom-width: 0px">
				<div id="id">글번호</div>
				${boardDto.boardNumber}
				<input type="hidden" name="boardNumber" value="${boardDto.boardNumber}">
				</div>
			<div class="menu" style="border-bottom-width: 0px">
				<div id="id">작성자</div>
				${boardDto.writer}
			</div>
			<div class="menu" style="border-bottom-width: 0px">
				<div id="id">조회수</div>
				${boardDto.readCount}
			</div>
			<div class="menu" style="border-bottom-width: 0px">
				<div id="id">작성일</div>
				<fmt:formatDate value="${boardDto.writeDate}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			</div>
			<div class="menu" style="border-bottom-width: 0px">
				<div id="id">제목</div>
				${boardDto.subject}
			</div>
			<div class="menu" style="border-bottom-width: 0px">
				<div id="id">내용</div>
				${boardDto.content}
			</div>
			
			
			
			<div class="menu"
				style="border-bottom-width: 3px; text-align: center">
				<input type="submit" value="삭제" />
				<%-- url이 완성될 수 있도록 경로에 대한 정보를 매개변수로 받아야 한다. 글번호, 페이지번호--%>
				<input type="button" value="취소"
					onclick="location.href='${root}/fileboard/read.do?boardNumber=${boardDto.boardNumber}&pageNumber=${pageNumber}'" />
			</div>
		</div>
	</form>
</body>
</html>