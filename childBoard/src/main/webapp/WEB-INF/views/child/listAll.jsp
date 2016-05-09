<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th style="width:40px">CNO</th>
		<th>cname</th>
		<th>school</th>
		<th>regdate</th>
		
		<c:forEach items="${list}" var ="childVO">ㄱㄱ
		
		<tr>
			<td>${childVO.cno }</td>
			<td><a href='/child/read?cno=${childVO.cno }'>${childVO.cname }</a></td>
			<td>${childVO.school }</td>
			<td><fmt:formatDate pattern="yyyy-MM-DD HH:mm" value="${childVO.regdate }"/></td>
			
		</c:forEach>
		
		
	</tr>
</table>
<button onClick="self.location='/child/register';">자녀등록</button>
</body>
</html>