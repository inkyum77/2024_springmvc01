<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
		<h2>방명록 : 작성화면</h2>
		<hr>
		<p><a href="/gb_list">[목록으로 이동]</a></p>
		<form action="/gb_detail" method="post">
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">작성자</td>
					<td>${gbvo.gb_writer}</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">제 목</td>
					<td>${gbvo.gb_subject}</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">email</td>
					<td>${gbvo.gb_email}</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">비밀번호</td>
					<td>${gbvo.gb_pwd}</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">첨부파일</td>
					<c:choose>
						<c:when test="${empty gbvo}">
							<td><b>첨부 파일 없음</b></td>
						</c:when>
						<c:otherwise>
							<td>
								<a href="/gb_down?f_name=${gbvo.gb_file}">
									<img src="resources/upload/${gbvo.gb_file}">
								</a>
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr align="center">
					<td colspan="2">
						<pre>${gbvo.gb_content}</pre>
					</td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="hidden" name="gb_idx" value="${gbvo.gb_idx}">
							<input type="button" onclick="update_go(this.form)" value="수정"> 
							<input type="button" onclick="delete_go(this.form)" value="삭제">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		function update_go(f) {
			f.action="/gb_update_page?gb_idx=${gbvo.gb_idx}";
			f.submit()="";
		}
		function delete_go(f) {
			f.action="/gb_detete_page";
			f.submit()="";
		}
	</script>
</body>
</html>