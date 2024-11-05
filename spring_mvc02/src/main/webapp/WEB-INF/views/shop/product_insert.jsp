<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 등록</title>
    <style type="text/css">
    	table, tr, th, td{
    		border: 1px solid black;
    		padding : 10px;
    		border-collapse: collapse;
    	}
    	body{
    		display: flex;
    		justify-content: center;
    		align-content: center;
    		align-items: center;
    	}
    </style>
</head>
<body>
	<table>
		<form action="/shop_add_product" method="post" enctype="multipart/form-data">
			<tr>
				<th>분류</th>
				<td>
					<input type="radio" name="category" value="comp001"> 컴퓨터
					<input type="radio" name="category" value="ele002"> 가전제품
					<input type="radio" name="category" value="sp003"> 스포츠 
				</td>
			</tr>
			<tr>
				<th>제품번호</th>
				<td>
					<input type="text" name="p_num">
				</td>
			</tr>
			<tr>
				<th>제품명</th>
				<td>
					<input type="text" name="p_name">
				</td>
			</tr>
			<tr>
				<th>판매사</th>
				<td>
					<input type="text" name="p_company">
				</td>
			</tr>
			<tr>
				<th>상품가격</th>
				<td>
					<input type="text" name="p_price">
				</td>
			</tr>
			<tr>
				<th>할인가</th>
				<td>
					<input type="text" name="p_saleprice">
				</td>
			</tr>
			<tr>
				<th>상품이미지s</th>
				<td>
					<input type="file" name="mp_image_s">
				</td>
			</tr>
			<tr>
				<th>상품이미지L</th>
				<td>
					<input type="file" name="mp_image_L">
				</td>
			</tr>
			<tr>
				<th colspan="2">상품내용</th>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="p_content" style="width: 100%"></textarea>			
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록"> 
				</td>
			</tr>
			
		</form>
	</table>

</body>
</html>