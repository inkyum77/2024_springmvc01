<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	margin: 10px auto;
	width: 600;
	border-collapse: collapse;
	font-size: 8pt;
	border-color: navy;
}

table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr bgcolor="#dedede">
				<th width="10%">제품번호</th>
				<th width="10%">이미지</th>
				<th width="35%">제품명</th>
				<th width="20%">제품가격</th>
				<th width="25%">비고</th>
			</tr>
		</thead>
		
		<tbody>
		
		</tbody>
		
			<c:choose>
				<c:when test="${empty shop_list}">
					<tr>
						<td colspan="6">등록된 상품이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${shop_list}" var="k">
						<tr align="center">
							<td>${k.p_num}</td>
							<td><img src="resources/images/${k.p_image_s}"></td>
							<td><a href="/shop_detail?shop_idx=${k.shop_idx}">${k.p_name}</a></td>
							<td><a href="product_content.jsp?prod_num="></a></td>
							<td>할인가 : 원<br> <font color="red">()</font></td>
							<td>시중 가격 : 원</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>


	</table>
</body>
</html>