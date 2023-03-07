<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
  <thead>
  	<tr>
  		<td>내용</td>
  		<td>추천 수</td>
  		<td>비추천 수</td>
  		<td>작성자</td>
  	</tr>
  </thead>
  <tbody>
  	<c:forEach items="${dtos}" var="dto" varStatus="i">
  		<tr>
			<td id="oriContent${dto.commentId}">${dto.content}</td>
			<td>${dto.goodCnt}</td>
			<td>${dto.badCnt}</td>
			<td>${dto.writer}</td>
			<td><button type="button" class="btn btn-primary del" data-commentId="${dto.commentId}">DELETE</button></td>
			<td><button type="button" class="btn btn-primary update" data-commentId="${dto.commentId}" data-bs-toggle="modal" data-bs-target="#exampleModal">UPDATE</button></td>
		<tr>
	</c:forEach>
  </tbody>
</table>
<nav aria-label="Page navigation example">
	<ul class="pagination">
	  <li class="page-item">
		<a class="page-link" href="#" aria-label="Previous" data-curPageNum="1">
		  <span aria-hidden="true" data-curPageNum="1">&laquo;</span>
		</a>
	  </li>
	  <li class="page-item">
		<a class="page-link" href="#" aria-label="Previous" data-curPageNum="${pager.startBlock - 1}">
		  <span aria-hidden="true" data-curPageNum="${pager.startBlock - 1}">&lsaquo;</span>
		</a>
	  </li>
	  <c:forEach begin="${pager.startBlock}" end="${pager.lastBlock}" var="i">
			 <li class="page-item"><a class="page-link" href="#" data-curPageNum="${i}">${i}</a></li>
	  </c:forEach>
	  
	  <li class="page-item">
		<a class="page-link" href="#" aria-label="Next" data-curPageNum="${pager.lastBlock + 1}"> 
		  <span aria-hidden="true" data-curPageNum="${pager.lastBlock + 1}">&rsaquo;</span>
		</a>
	  </li>
	  
	  <li class="page-item">
		<a class="page-link" href="#" aria-label="Next" data-curPageNum="${pager.totalPageCnt}">
		  <span aria-hidden="true" data-curPageNum="${pager.totalPageCnt}">&raquo;</span>
		</a>
	  </li>
	</ul>
  </nav>
