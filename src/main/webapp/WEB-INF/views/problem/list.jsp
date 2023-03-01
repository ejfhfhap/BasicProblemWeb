<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_header.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<table class="table">
  <thead>
    <tr>
      <th scope="col">문제 번호</th>
      <th scope="col">난이도</th>
      <th scope="col">제목</th>
      <th scope="col">추천 수</th>
      <th scope="col">비추천 수</th>
      <th scope="col">조회수</th>
      <th scope="col">작성자</th>
    </tr>
  </thead>
  <tbody class="table-group-divider">
  	<c:forEach items="${problemDtos}" var="problemDto">
  		<tr>
  			<td scope="row">${problemDto.problemListId}</td>
  			<td>${problemDto.difficulty}</td>
  			<td><a href = "./detail?problemListId=${problemDto.problemListId}">${problemDto.title}</a></td>
  			<td>${problemDto.goodCnt }</td>
  			<td>${problemDto.badCnt }</td>
  			<td>${problemDto.cnt }</td>
  			<td>${problemDto.writer }</td>
  		</tr>
  	</c:forEach>
  </tbody>
</table>

<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="./list?curPageNum=1&searchKind=${pager.searchKind}&searchContent=${pager.searchContent}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item">
      <a class="page-link" href="./list?curPageNum=${pager.startBlock - 1}&searchKind=${pager.searchKind}&searchContent=${pager.searchContent}" aria-label="Previous">
        <span aria-hidden="true">&lsaquo;</span>
      </a>
    </li>
    <c:forEach begin="${pager.startBlock}" end="${pager.lastBlock}" var="i">
   	    <li class="page-item"><a class="page-link" href="./list?curPageNum=${i}&searchKind=${pager.searchKind}&searchContent=${pager.searchContent}">${i}</a></li>
    </c:forEach>
    
	<li class="page-item">
      <a class="page-link" href="./list?curPageNum=${pager.lastBlock + 1}&searchKind=${pager.searchKind}&searchContent=${pager.searchContent}" aria-label="Next">
        <span aria-hidden="true">&rsaquo;</span>
      </a>
    </li>
    
    <li class="page-item">
      <a class="page-link" href="./list?curPageNum=${pager.totalPageCnt}&searchKind=${pager.searchKind}&searchContent=${pager.searchContent}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
<form class="row g-3">
	<div class="col-auto">
		<select name="searchKind" class="form-select" aria-label="Default select example">
		  <option value="problemListId">문제 번호</option>
		  <option value="title">제목</option>
		  <option value="writer">작성자</option>
		</select>
	</div>
  <div class="col-auto">
    <input type="text" class="form-control" name="searchContent" placeholder="검색어 입력">
  </div>
  <div class="col-auto">
    <button type="submit" class="btn btn-primary mb-3">검색하기</button>
  </div>
</form>

<a href="./insert">추가하기</a>

<c:import url="../template/common_body.jsp"></c:import>
</body>
</html>