<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="/"><img src="/resources/images/mainLogo.png" style="height: 50px; width: 70px;"></a>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
                 <div class="dropdown">
					  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
					    문제 보기
					  </button>
					  <ul class="dropdown-menu">
					    <li><a class="dropdown-item" href="/problem/list">전체 문제</a></li>
					    <li><a class="dropdown-item" href="#">Another action</a></li>
					    <li><a class="dropdown-item" href="#">Something else here</a></li>
					  </ul>
				  </div>
	        </li>
	        
	        <c:if test="${not empty loginInfo}">
	        	 <li class="nav-item">
              		 <a class="nav-link" href="/member/myPage">마이페이지</a>
       			 </li>
  		       	 <li class="nav-item">
              		 <a class="nav-link" href="/member/logout">로그아웃</a>
       			 </li>
	        </c:if>
	         <c:if test="${empty loginInfo}">
  		       	 <li class="nav-item">
              		 <a class="nav-link" href="/member/login">로그인</a>
       			 </li>
	        </c:if>
   	        <li class="nav-item">
                 <a class="nav-link" href="/member/agree">회원가입</a>
	        </li>
	      </ul>
	    </div>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	  </div>
	</nav>
	<c:if test="${not empty loginInfo}">
		<h5>${loginInfo.memberId}님 환영합니다</h5>
	</c:if>