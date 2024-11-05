<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
    <h2>로그인</h2>
    <form method="post" action="/login_login">
        <table>
            <thead>
                <tr>
                    <th>아이디</th>
                    <th>패스워드</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" size="14" name="m_id" required></td><br>
                    <td><input type="password" size="14" name="m_pw" id="m_pw" required></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="4" align="center">
                    <input type="submit" value="가입하기"></td>
                </tr>
            </tfoot>
        </table>
    </form>
    <h2><a href="/login_joinForm">회원가입</a></h2>
</body>
</html>