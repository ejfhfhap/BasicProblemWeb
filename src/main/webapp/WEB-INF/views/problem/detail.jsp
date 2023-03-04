<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/common_header.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<h2>제목 ${problemDto.title}</h2>
<h2>내용 ${problemDto.content}</h2>
<h2>정답 ${problemDto.answer}</h2>
<h2>난이도 ${problemDto.difficulty}</h2>
<h2>추천 수 <h2 id="goodCnt">${problemDto.goodCnt}</h2></h2>
<h2>비추천 수 <h2 id="badCnt">${problemDto.badCnt}</h2></h2>

<button id="goodCntAdd" data-problemListId="${problemDto.problemListId}">Good</button>
<button id="badCntAdd" data-problemListId="${problemDto.problemListId}">Bad</button>

<c:forEach items="${problemDto.problemImageDtos}" var="problemImageDto">
	<a href = "./fileDown?problemImageId=${problemImageDto.problemImageId }">${problemImageDto.oriImageName}</a>
</c:forEach>

<form action="../comment/insert" method="post" class="row col-md-5">
	<input type="hidden" name="problemListId" value="${problemDto.problemListId}">
	<div class="mb-3">
	  <label for="content" class="form-label">댓글</label>
	  <input type="text" class="form-control" id="content" placeholder="댓글을 입력 하세요." name="content">
  	  <button id="commentBtn" type="button" class="btn btn-primary">등록</button>
	</div>
</form>

<div id="commentList">

</div>


<script src="/resources/js/problem/detail.js"></script>
<c:import url="../template/common_body.jsp"></c:import>
</body>
</html>