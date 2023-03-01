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
<!-- 	private Integer problemListId;
	private String title;
	private String content;
	private String answer;
	private String difficulty;
	private String writer;
	private Integer goodCnt;
	private Integer badCnt;
	private Integer cnt; -->
<form class="was-validated" action="./insert" method="post" enctype="multipart/form-data">
  <div class="col-md-4">
    <label for="title" class="form-label">제목</label>
    <input type="text" class="form-control" id="title" name="title" required>
    <div class="valid-feedback">
      Looks good!
    </div>
  </div>
	
	<div class="col-md-4">
    <label for="content" class="form-label">내용</label>
    <input type="text" class="form-control" id="content" name="content" required>
    <div class="valid-feedback">
      Looks good!
    </div>
  </div>
  
  <div class="col-md-4">
    <label for="answer" class="form-label">정답</label>
    <input type="text" class="form-control" id="answer" name = "answer" required>
    <div class="valid-feedback">
      Looks good!
    </div>
  </div>
  <div class="col-md-4">
    <label for="difficulty" class="form-label">난이도</label>
    <input type="text" class="form-control" id="difficulty" name = "difficulty" required>
    <div class="valid-feedback">
      Looks good!
    </div>
  </div>
  
  
  <div class="mb-3">
    <input type="file" class="form-control" aria-label="file example" name = "images">
  </div>
  <div class="mb-3">
    <input type="file" class="form-control" aria-label="file example" name = "images">
  </div>
  
  <div class="mb-3">
    <button class="btn btn-primary" type="submit">Submit form</button>
  </div>
</form>

<c:import url="../template/common_body.jsp"></c:import>
</body>
</html>