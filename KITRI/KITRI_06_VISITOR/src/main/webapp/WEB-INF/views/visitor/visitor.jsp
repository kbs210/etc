<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="visitor">
		<h1>환영합니다 나의 방명록입니다</h1>
		<a href="${path}/member/login">로그인</a> <a href="${path}/member/logout">로그아웃</a>
		<%-- ${세션값 담기} --%>
		${sessionScope.login}님
		<hr>
		<h3>방명록 작성</h3>
		<div class="visitor-box">
			<form action="" method="post">
				<textarea name="vContent" rows="10" cols="60"></textarea>
				<br>
				<input type="text" name="vAuth" placeholder="작성자" size="10">
				<input type="password" name="vPwd" placeholder="글 수정/삭제 비밀번호"
					size="20"> <input type="submit" value="등록">
			</form>
		</div>
		<hr>
		<h3>방명록 목록</h3>
		<div id="visitor-list"></div>
	</div>
</body>
</html>