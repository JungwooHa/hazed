<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>list page입니다</h1>

<c:forEach items="${list}" var="boardVO">
<table>
                     <tr>
                        <td>${boardVO.bno}</td>
                        <td><a
                           href='/boards/readpage?bno=${boardVO.bno }'>
                              ${boardVO.title}</a></td>
                        <td>${boardVO.writer}</td>
                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
                              value="${boardVO.regdate}" /></td>
                       
                     </tr>

                  </c:forEach>
</table>
</body>
</html>