<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#bbs table {
	width:580px;
	margin:0 auto;
	margin-top:20px;
	border: 1px solid black;
	border-collapse: collapse;
	font-size: 14px;
}

#bbs table caption {
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 10px;
}

#bbs table th, #bbs table td {
	text-align: center;
	border: 1px solid black;
	padding: 4px 10px;
}

.no { width: 15% }
.subject { 	width: 30% }
.writer {	width: 20% }
.reg {	width: 20% }
.hit {	width: 15% }
.title {	background: lightsteelblue }
.odd {	background: silver }

/* paging */
table tfoot ol.paging {
	list-style: none;
}

table tfoot ol.paging li {
	float: left;
	margin-right: 8px;
}

table tfoot ol.paging li a {
	display: block;
	padding: 3px 7px;
	border: 1px solid #00B3DC;
	color: #2f313e;
	font-weight: bold;
}

table tfoot ol.paging li a:hover {
	background: #00B3DC;
	color: white;
	font-weight: bold;
}

.disable {
	padding: 3px 7px;
	border: 1px solid silver;
	color: silver;
}

.now {
	padding: 3px 7px;
	border: 1px solid #ff4aa5;
	background: #ff4aa5;
	color: white;
	font-weight: bold;
}
</style>
</head>
<body>
	<h2>BBS 리스트</h2>
	<table width="700">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${empty board_list}">
					<tr>
						<td colspan="5"><h3>게시물이 존재하지 않습니다.</h3></td>
					</tr>
				</c:when>
				
				<tbody>
				
				<c:otherwise>
					<c:forEach var="k" items="${board_list" varStatus="c">
						<tr>
							<td>${paging.totalRecord - ((paging.nowPage)* paging.numPerPage + c.index)}</td>
							<td>${k.title}</td>
							<td>${k.writer}</td>
							<td>${k.regdate}</td>
							<td>${k.hit}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		</tr>
	</table>
</body>
</html>