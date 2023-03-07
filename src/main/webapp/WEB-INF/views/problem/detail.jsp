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
<div id="datas" hidden></div>
<h2>제목 ${problemDto.title}</h2>
<h2>내용 ${problemDto.content}</h2>
<h2>정답 ${problemDto.answer}</h2>
<h2>난이도 ${problemDto.difficulty}</h2>

<form action="./ansSubmit" method="post">
	<input type="hidden" name="problemListId" value="${problemDto.problemListId }">
	정답<input type="text" name="answer">
	<button type="submit">제출하기</button>
</form>

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

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
	Launch demo modal
  </button>
  
  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="contentUpdateForm" aria-hidden="true">
	<div class="modal-dialog">
	  <div class="modal-content">
		<div class="modal-header">
		  <h1 class="modal-title fs-5" id="contentUpdateForm">Modal title</h1>
		  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		</div>
		<div class="form-floating">
			<textarea class="form-control" placeholder="Leave a comment here" id="updatedContent"></textarea>
		</div>
		<div class="modal-footer">
		  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="closeBtn">Close</button>
		  <button type="button" class="btn btn-primary" id="updateBtn">수정하기</button>
		</div>
	  </div>
	</div>
  </div>

<script src="/resources/js/problem/detail.js"></script>
<c:import url="../template/common_body.jsp"></c:import>

</body>
</html>