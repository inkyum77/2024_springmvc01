<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="UTF-8">
<title>방 명 록</title>
<style type="text/css">
a {
	text-decoration: none;
}

table {
	width: 600px;
	border-collapse: collapse;
	text-align: center;
}

table, th, td {
	border: 1px solid black;
	padding: 3px
}

div {
	width: 600px;
	margin: auto;
	text-align: center;
}
</style>
</head>
<body>
	<div>
		<h2>방 명 록</h2>
		<hr>
		<a href="/gb_write_page">
			[방명록 쓰기]
		</a>
		<table>
			<thead>
				<tr style="background-color: #99ccff">
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}">
						<tr>
							<td colspan="4">
								<h2>데이터가 존재하지 않습니다.</h2>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${list}" var="k" varStatus="i">
							<tr>
								<td>${i.count}</td>
								<td>${k.gb_writer}</td>
								<td><a href="/gb_detail?gb_idx=${k.gb_idx}">${k.gb_subject}</a></td>
								<td>${k.gb_date}</td>
								<input type="hidden" name="gb_pwd" value="${k.gb_pwd}">
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>