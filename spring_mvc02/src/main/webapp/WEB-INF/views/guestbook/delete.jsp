<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h2>삭제하기</h2>
		<hr>
		<form action="${pageContext.request.contextPath}/GBController" method="post">
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">비밀번호</td>
					<td><input type="text" name="pwd"></td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="button" class="delete" value="삭제" onclick="delete_go(this.form)">
							<input type="button" class="cancel" value="취소" onclick="cancel_go(this.form)">
							<input type="hidden" name="p_idx" value="${p_idx}">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	
	
	<script type="text/javascript">
		function delete_go(f) {
			f.action="${pageContext.request.contextPath}/GBController?cmd=delete";
			f.submit()="";
		}
		function cancel_go(f) {
			f.action="${pageContext.request.contextPath}/GBController?cmd=list";
			f.submit()="";
		}
	</script>
</body>
</html>