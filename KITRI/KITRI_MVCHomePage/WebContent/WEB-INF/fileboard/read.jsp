<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	<div id="createform">
		<div class="menu" style="border-bottom-width: 0px">
			<div id="id">글번호</div>
			${boardDto.boardNumber}
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
			<fmt:formatDate value="${boardDto.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</div>
		<div class="menu" style="border-bottom-width: 0px">
			<div id="id">제목</div>
			${boardDto.subject}
		</div>
		<div class="menu" style="border-bottom-width: 0px">
			<div id="id">내용</div>
			${boardDto.content}
		</div>
		<div class="menu" style="border-bottom-width: 0px">
			<div id="id">파일이름</div>
			<c:if test="${boardDto.fileName!=null}">
			<a href="${root}/fileboard/downLoad.do?boardNumber=${boardDto.boardNumber}">${boardDto.fileName}</a>
			</c:if>
		</div>
		
		<div class="menu" style="border-bottom-width: 3px; text-align: center">
			<input type="button" value="글수정" onclick="updFunc('${root}','${boardDto.boardNumber}','${pageNumber}')"/> <%-- url이 완성될 수 있도록 경로에 대한 정보를 매개변수로 받아야 한다. 글번호, 페이지번호--%>
			<input type="button" value="글삭제" onclick="delFunc('${root}','${boardDto.boardNumber}','${pageNumber}')"/> <%-- url이 완성될 수 있도록 경로에 대한 정보를 매개변수로 받아야 한다. 글번호, 페이지번호--%>
			<input type="button" value="답글" onclick="replyFunc('${root}','${boardDto.boardNumber}','${boardDto.groupNumber}','${boardDto.sequenceNumber}','${boardDto.sequenceLevel}')"/> <%-- url, 글번호, 그룹번호, 시퀀스번호, 시퀀스레벨--%>
			<input type="button" value="글목록" onclick="location.href='${root}/fileboard/list.do?pageNumber=${pageNumber}'"/>
		</div>
	</div>

</body>
</html>