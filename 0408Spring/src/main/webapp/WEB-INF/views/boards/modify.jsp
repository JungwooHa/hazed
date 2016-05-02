<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form role="form" action="modify" method="post" >
	  <input type="hidden" name ="page" value="${cri.page }">
	  <input type="hidden" name ="perPageNum" value="${cri.perPageNum }">

		<div class="box-body">
			<div class="f-g">
				<input type="text" name="bno" value="${boardVO.bno }" readonly="readonly">
			</div>
			<div class="f-g">
				<input type="text" name="title" value="${boardVO.title }">
			</div>
			<div class="f-g">
				<input type="text" name="content" value="${boardVO.content }">
			</div>
			<div class="f-g">
				<input type="text" name="writer" value="${boardVO.writer }">
			</div>
		</div>

	</form>
	<div class="box-footer">
		<button type="submit" class="btn-primary">save</button>
		<button type="submit" class="btn-warning">cancle</button>

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");
			console.log(formObj);

			$(".btn-warning").on("click", function() {
				self.location = "/boards/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
				console.log("dasdas");
			});
			$(".btn-primary").on("click", function() {
				console.log("ccccccc");
				formObj.submit();
			});

		});
	</script>

</body>
</html>