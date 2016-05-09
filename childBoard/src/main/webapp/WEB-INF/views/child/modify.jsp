<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form role = "form" method="POST">
	<p1>수정</p1>
	
	
	<button type="submit" class="btn btn-danger">저장</button>
	<button type="submit" class="btn btn-primary">취소</button>
</form>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script>

$(document).ready(function(){
	
	 var formObj = $("form[role='form']");
	    console.log(formObj);

	$(".btn-danger").on("click", function() {
	   self.location = "/child/listAll";
	});

	$(".btn-primary").on("click", function() {
		   self.location = "/child/listAll";
		});


})


</script>
</html>