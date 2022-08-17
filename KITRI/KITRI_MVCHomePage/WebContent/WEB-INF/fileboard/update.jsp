<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		action="${root}/fileboard/updateOk.do" method="post"
		onsubmit="return updFunc(this)">
		<div id="title">글목록</div>

		<div class="menu" style="border-bottom-width: 0px;">
			<input type="hidden" name="boardNumber" value="${boardDto.boardNumber}">
			<input type="hidden" name="groupNumber" value="${boardDto.groupNumber}">
			<input type="hidden" name="sequenceNumber" value="${boardDto.sequenceNumber}">
			<input type="hidden" name="sequenceLevel" value="${boardDto.sequenceLevel}">

			<div id="id">작성자</div>
			<span> <input type="text" name="name" size="12" value="${boardDto.writer}" readonly >
			</span>
		</div>

		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">제목</div>

			<span> <input type="text" name="subject" size="50" value="${boardDto.subject}">
			</span>
		</div>


		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">이메일</div>

			<span> <input type="email" name="email" size="50" value="${boardDto.email}">
			</span>
		</div>
		
		<div class="content" style="border-bottom-width: 0px;">
			<div id="text">내용</div>
			
			<span>
				<textarea name="content" rows="12" cols="65" >${boardDto.content}</textarea>
			</span>
		</div>
		
		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">비밀번호</div>
			
			<span>
				<input type="password" name="password" size="30" value="${boardDto.password}">
			</span>
		</div>
		
		  <div class="menu" style="border-bottom-width: 3px; text-align: center;">
         <span> 
            <input type="submit" value="수정">
            <input type="reset" value="다시작성">
            <input type="button" value="목록보기" onclick="location.href='${root}/fileboard/list.do'">
         </span>
      </div>

		
		
		
		
		
	</form>
</body>
</html>