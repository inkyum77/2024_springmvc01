<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" crossorigin="anonymous"></script>
</head>
<body>
	<h2>카카오 로그인 성공</h2>
	<div id="result"></div>
	
	<a href="https://kauth.kakao.com/oauth/logout?client_id=e07bb4b8d5b0f2531b6c6721df5ac8eb&logout_redirect_uri=http://localhost:8080/kakaologout">로그아웃</a>
<!-- 	
	<script type="text/javascript">
		$(function() {
			$("#result").empty();
			$.ajax({
				url :"/kakaoUserInfo",
				method : "post",
				dataType : "json",
				success : function(data){
					console.log("data :" + data);
					let str = "<li>닉네임: ${nickname}</li>";
						str+= "<li>이미지: <img src=${profileImage}></li>";
					$("#result").append(str);
				},
				error : function(){
					alert("읽기 실패");
				}
			})
		})
	</script>  -->
</body>
</html>