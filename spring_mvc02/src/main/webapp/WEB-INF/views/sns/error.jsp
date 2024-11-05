<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공 사 중</h1>
	<form action="${pageContext.request.contextPath}/GBController" method="post">
		<input type="submit" value="guestbook2">
		<input type="hidden" name="cmd" value="list">
	</form>
</body>
</html>