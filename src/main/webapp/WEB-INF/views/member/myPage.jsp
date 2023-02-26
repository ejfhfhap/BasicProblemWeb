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

<img src="/resources/upload/member/${memberDto.fileName}">

<h5>아이디: ${memberDto.memberId}</h5>
<h5>소개: ${memberDto.myIntro}</h5>
<h5>이메일: ${memberDto.email}</h5>

<a href="./update" class = "btn btn-primary">수정하기</a>
<a href="./delete" class = "btn btn-primary">회원탈퇴</a>
<c:import url="../template/common_body.jsp"></c:import>
</body>
</html>