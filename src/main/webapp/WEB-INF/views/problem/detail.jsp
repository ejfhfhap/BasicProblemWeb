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

<c:forEach items="${problemDto.problemImageDtos}" var="problemImageDto">
	<a href = "./fileDown?problemImageId=${problemImageDto.problemImageId }">${problemImageDto.oriImageName}</a>
</c:forEach>

<c:import url="../template/common_body.jsp"></c:import>
</body>
</html>