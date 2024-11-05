<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		width: 1000px;
		border-collapse: collapse;
		margin: 10px auto;
	}
	table, td, tr{
		border:1px solid #eee;
		border-collapse: collapse;
		margin: 10px auto;
		padding: 10px;
	}
	h1{
		text-align: center;
	}
</style>
</head>
<body>
	<h1> ${not empty list ? list[0].dname : '부서 정보 없음'}부서 정보 (${list.size()})</h1>

	<table>
		<thead>
			<colgroup>
				<col style="width: 10%;"></col>
				<col style="width: 10%;"></col>
				<col style="width: 10%;"></col>
				<col style="width: 30%;"></col>
				<col style="width: 40%;"></col>
			</colgroup>
			<tr>
				<td>번호</td>
				<td>사번</td>
				<td>이름</td>
				<td>직종</td>
				<td>부서</td>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty list}">
					<tr><td colspan="5">자료가 존재하지 않습니다.</td></tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="k" items="${list}" varStatus="vs">
						<tr>
							<td>${vs.count}</td>
							<td>${k.empno}</td>
							<td>${k.ename}</td>
							<td>${k.job}</td>
							<td>${k.dname}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>