<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	<c:set var = "id" value="${id}" scope="session"/>
	
	<a href="${root}/member/test.do">Spring MVC Start!!!</a>
	
	<c:if test="${memberLevel==null}">
		<h3>회원관리</h3>
			<a href="${root}/member/register.do">회원가입</a>
		<h3>로그인</h3>
			<a href="${root}/member/login.do">로그인</a>
	</c:if>
	
	<c:if test="${memberLevel!=null}">
    	<a href="${root}/member/delete.do">회원탈퇴</a>
    	<a href="${root}/member/update.do">회원수정</a>
  		<a href="${root}/member/logout.do">로그아웃</a>	
  		
  		<c:if test="${memberLevel=='MA'}">
  			<h3>관리자 페이지</h3>
  			<a href="">회원관리</a>
  		</c:if>
   </c:if>
   
   <br/><br/>
   
   <h3>파일 게시판</h3>
   <a href="${root}/fileBoard/write.do">파일게시판 쓰기</a>
  	<br/><br/>
  	
  	<a href="${root}/fileBoard/list.do">파일 리스트</a> 
  
	
	
</body>
</html>