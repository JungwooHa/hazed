<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form  role="form" method = "post">
	
	<input type="hidden" name="cno" value="${childVO.cno }"/>

	<input type = "text" name ="cname" value ="${childVO.cname}" readonly="readonly">
	<input type = "text" name ="school" value = "${childVO.school}" readonly="readonly">
	<input type = "text" name ="age" value = "${childVO.age}" readonly="readonly">
	<input type = "text" name ="clevel" value = "${childVO.clevel}" readonly="readonly">

		
   </form>
   
   <div class="box-footer">
   	<button type="submit" class="btn-warning">Modify</button>
   	<button type="submit" class="btn-danger">Remove</button>
   	<button type="submit" class="btn-primary">List All</button>
   </div>
   
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
   <script>
   $(document).ready(function () {
	    var formObj = $("form[role='form']");
	        console.log(formObj);

	    $(".btn-warning").on("click",function () {
	        formObj.attr("action","/child/modify");
	        formObj.attr("method","get");
	        formObj.submit();
	    });

	    $(".btn-danger").on("click",function () {
	        formObj.attr("action","/child/remove");
	        formObj.submit();
	    });

	    $(".btn-primary").on("click",function () {
	        self.location ="/child/listAll";
	    });
	})
   </script>
   
</body>
</html>