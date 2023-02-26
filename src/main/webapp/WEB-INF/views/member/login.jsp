<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_header.jsp"/>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<form class="row g-3" action="./login" method="post" id="submitForm">
	  <div class="col-md-4">
	    <label for="inputId" class="form-label">아이디</label>
	    <input type="text" class="form-control" id="inputId" name="memberId" value="${memberId}" required>
		<div id="idMsg">${not empty memberId ? "아이디 또는 비밀번호가 다릅니다":""}</div>
	  </div>
	  
	  <div class="row g-3 align-items-center">
		    <label for="inputPassword1" class="col-form-label">비밀번호</label>
		  <div class="col-auto">
		    <input type="password" id="inputPassword1" name="pw" class="form-control" aria-describedby="passwordHelpInline">
		  </div>
		  <div class="col-auto">
		    <span id="PasswordMsg1" class="form-text"></span>
		  </div>
		</div>
	  <div class="col-12">
	    <button class="btn btn-primary" type="submit" id="submitBtn">로그인</button>
	  </div>
	</form>

<script src="../resources/js/member/login.js"></script>
<c:import url="../template/common_body.jsp"></c:import>
</body>
</html>