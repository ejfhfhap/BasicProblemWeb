<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_header.jsp"/>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<form class="row g-3" action="./insert" method="post" enctype="multipart/form-data" id="submitForm">
	  <div class="col-md-4">
	    <label for="inputId" class="form-label">아이디</label>
	    <input type="text" class="form-control" id="inputId" name="memberId" required>
		<div id="idMsg"></div>
	  </div>
	  
	  <div class="row g-3 align-items-center">
		    <label for="inputPassword1" class="col-form-label">비밀번호</label>
		  <div class="col-auto">
		    <input type="password" id="inputPassword1" name="pw" class="form-control" aria-describedby="passwordHelpInline">
		  </div>
		  <div class="col-auto">
		    <span id="PasswordMsg1" class="form-text">
		      8 ~ 20글자 사이의 비밀번호를 입력 해 주세요
		    </span>
		  </div>
		</div>

		<div class="row g-3 align-items-center">
		    <label for="inputPassword2" class="col-form-label">비밀번호 확인</label>
		  <div class="col-auto">
		    <input type="password" id="inputPassword2" class="form-control" aria-describedby="passwordHelpInline">
		  </div>
		  <div class="col-auto" id="PasswordMsg2"></div>
		</div>

	  
  	  <div class="form-floating">
		  <textarea class="form-control" name="myIntro" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
		  <label for="floatingTextarea2">소개</label>
	  </div>
	  
  	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">이메일</label>
	    <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp">
	    <div id="emailHelp" class="form-text">이메일을 공유하지 마세요.</div>
	  </div>

  	  <div class="mb-3">
		  <label for="formFile" class="form-label">프로필 사진</label>
		  <input class="form-control" type="file" id="formFile" name="image">
	  </div>
	  
	  <div class="col-12">
	    <button class="btn btn-primary" type="button" id="submitBtn">Submit form</button>
	  </div>
	</form>
	
	<script src="../resources/js/member/insert.js"></script>
<c:import url="../template/common_body.jsp"></c:import>
</body>
</html>