<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}" />
	<c:if test="${check > 0 }">
		<script type="text/javascript">
			alert("게시글이 수정되었습니다.");
			if(${pageNumber!=null}){
				location.href="${root}/board/list.do?pageNumber=${pageNumber}";
				} else{
					location.href="${root}/board/list.do"
				}
		</script>
	</c:if>
	<c:if test="${check == 0 }">
		<script type="text/javascript">
			alert("게시글이 수정되지 않았습니다.");
			if(${pageNumber!=null}){
				location.href="${root}/board/list.do?pageNumber=${pageNumber}";
				} else{
					location.href="${root}/board/list.do"
				}
		</script>
	</c:if>
</body>
</html>