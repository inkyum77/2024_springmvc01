<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<form action="/email_send" method="post">
			<input type="email" name="email"
	            pattern="[a-zA-Z0-9]+[@][a-zA-Z0-9]+[.]+[a-zA-Z]+[.]*[a-zA-Z]*" title="이메일 양식">
	        <input type="submit" value="전송">
		</form>
		<form action="/email_send_chk" onSubmit="return authNum()" method="post">
			<input type="number" name="authNumber" placeholder="인증번호" title="이메일 양식" maxlength="6" required>
	        <input type="submit" value="전송">
		</form>
	</body>
	
	<script type="text/javascript">
		function authNum(){
			const authNumber = document.querySelector("#authNumber").value;
			// 숫자가 6자리인지 확인
			if(authNumber.length != 6 || isNaN(authNumber)){
				alert("6자리 숫자만 입력해야합니다.");
				return false;
			}
			return true;
		}
	</script>

</html>