<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <c:choose>
        <c:when test="${idx == 1}">시번 검색 결과</c:when>
        <c:when test="${idx == 2}">이름 검색 결과</c:when>
        <c:when test="${idx == 3}">직종 검색 결과</c:when>
        <c:when test="${idx == 4}">부서 검색 결과</c:when>
    </c:choose>
    <h2>인원 ${list.size()} 명</h2>
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