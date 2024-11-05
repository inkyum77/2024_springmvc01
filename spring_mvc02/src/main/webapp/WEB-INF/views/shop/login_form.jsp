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
		<div id="login" style="margin: 30px;">
	        <form action="/login" method="post">
	            <p>    ID : <input type="text" name="m_id" required>    </p>
	            <p>    PW : <input type="password" name="m_pw" required></p>
	            <input type="submit" value="로그인">
	        </form>
	        <input type="button" onclick="join_page()" value="회원가입">
		</div>
	<a href="https://kauth.kakao.com/oauth/authorize?client_id=e07bb4b8d5b0f2531b6c6721df5ac8eb&redirect_uri=http://localhost:8080/kakaologin&response_type=code">
		<img class="login_btn" alt="카카오" src="resources/images/kakao_login_large_wide.png">
	</a>
	<a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=Z9z3XtS3_Aa7O41NNIG9&redirect_uri=http://localhost:8080/naverlogin&state=STATE_STRING">
		<img class="login_btn" alt="카카오" src="resources/images/naver_login_btn_complete.png">
	</a>
	<script type="text/javascript">
		function join_page(param){
			location.href = "/join_page";
		}
	</script>
</body>
</html>