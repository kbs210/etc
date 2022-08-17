<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta charset="UTF-8">
<title>파일보드 수정 페이지</title>
<link rel="stylesheet" href="${root}/css/board/boardStyle.css" />
<script type="text/javascript">
	function boardCheck(obj){
		//alert("OK");	
	}
	function updFunc(root, boardNumber, pageNumber){
		var url = root + "/fileBoard/update.do?boardNumber=" + boardNumber + "&pageNumber=" + pageNumber;		
		location.href = url;
	}
</script>
</head>
<body>
	<form id="createform" action="${root}/fileBoard/updateOk.do" method="post" enctype="multipart/form-data">
		<div id="title"><a href="${root}/fileBoard/list.do">글목록</a></div>

		${boardNumber}
		<div class="menu" style="border-bottom-width: 0px;">
			<input type="hidden" name="boardNumber" value="${boardDto.boardNumber}"/>
			<input type="hidden" name="groupNumber" value="${boardDto.groupNumber}" /> 
			<input type="hidden" name="sequenceNumber" value="${boardDto.sequenceNumber}" /> 
			<input type="hidden" name="sequenceLevel" value="${boardDto.sequenceLevel}" />
			<input type="hidden" name="pageNumber" value="${pageNumber}"/>
			
			<div id="id">작성자</div>
			<span>
				${boardDto.writer}
				<input type="hidden" name="writer" value="${boardDto.writer}"/>
			</span>
		</div>

		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">제목</div>
			<span> 
				<input type="text" name="subject" size="50" value="${boardDto.subject}"/>
			</span>
		</div>

		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">이메일</div>
			<span> 
				<input type="email" name="email" size="50" value="${boardDto.email}"/>
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
				<input type="password" name="password" size="30" value="${boardDto.password}"/>
			</span>
		</div>
		
		<!-- 파일명 -->
		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">파일명</div>
			<span> 
				${boardDto.fileName}
				&nbsp;&nbsp;&nbsp;
				<input type="file" name="file" size="50"/>
			</span>
		</div>

		<div class="menu" style="border-bottom-width: 3px; text-align: center;">
			<span> 
				<input type="submit" value="수정완료" /> 
				<input type="reset" value="다시작성"/> 
				<input type="button" value="목록보기" onclick="location.href='${root}/fileBoard/list.do'"/>
			</span>
		</div>
	</form>
</body>
</html>