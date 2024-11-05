<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.login_btn{
		width: 300px;
		height: auto;
	}
</style>
</head>
<body>
	<h1>SNS 로그인</h1>
	<div>
		
	</div>
	<a href="https://kauth.kakao.com/oauth/authorize?client_id=e07bb4b8d5b0f2531b6c6721df5ac8eb&redirect_uri=http://localhost:8080/kakaologin&response_type=code">
		<img class="login_btn" alt="카카오" src="resources/images/kakao_login_large_wide.png">
	</a>
	<a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=Z9z3XtS3_Aa7O41NNIG9&redirect_uri=http://localhost:8080/naverlogin&state=STATE_STRING">
		<img class="login_btn" alt="카카오" src="resources/images/naver_login_btn_complete.png">
	</a>
	<hr>
	<button type="button" onclick="kakao_map01()">카카오 지도 연습 1</button>
	<button type="button" onclick="kakao_map02()">카카오 지도 연습 2</button>
	<button type="button" onclick="kakao_map03()">카카오 지도 연습 3</button>
	<button type="button" onclick="kakao_map04()">카카오 지도 연습 4</button>
	<button type="button" onclick="kakao_map05()">카카오 지도 연습 5</button>
	<button type="button" onclick="daum_addr()">다음 API</button>
	
	
	<script type="text/javascript">
	
		function kakao_map01(params) {
			location.href = "/kakao_map01";
		}
		function kakao_map02(params) {
			location.href = "/kakao_map02";
		}
		function kakao_map03(params) {
			location.href = "/kakao_map03";
		}
		function kakao_map04(params) {
			location.href = "/kakao_map04";
		}
		function daum_addr(params) {
			location.href = "/kakao_map05";
		}
	</script>
</body>
</html>