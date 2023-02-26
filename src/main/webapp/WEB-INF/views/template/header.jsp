<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="/"><img src="/resources/images/mainLogo.png" style="height: 50px; width: 70px;"></a>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	             <a class="nav-link active" aria-current="page" href="/">홈페이지</a>
	        </li>
	        <li class="nav-item">
                 <a class="nav-link" href="/member/agree">회원가입</a>
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