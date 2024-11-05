<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .signup-container {
            background-color: white;
            padding: 40px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            width: 350px;
        }

        .signup-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .signup-container input[type="text"],
        .signup-container input[type="password"],
        .signup-container input[type="number"],
        .signup-container input[type="date"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .signup-container button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .signup-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <div class="signup-container">
        <h2>회원가입</h2>
        <form action="/join" method="POST">
            <label for="m_id">아이디</label>
            <input type="text" id="m_id" name="m_id" placeholder="아이디 입력" required>

            <label for="m_pw">비밀번호</label>
            <input type="password" id="m_pw" name="m_pw" placeholder="비밀번호 입력" required>

            <label for="m_name">이름</label>
            <input type="text" id="m_name" name="m_name" placeholder="이름 입력" required>

            <label for="m_age">나이</label>
            <input type="number" id="m_age" name="m_age" placeholder="나이 입력" required>
            
            <button type="submit">회원가입</button>
        </form>
    </div>

</body>
</html>
