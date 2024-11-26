<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign In</title>
    <style>
        .error {
            color: red;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
<h1>Sign In</h1>

<!-- 에러 메시지 표시 -->
<div class="error">${error}</div>

<form action="/sign-in" method="post">
    <label for="username">Username</label>
    <input type="text" id="username" name="username" placeholder="아이디를 입력하세요." minlength="4" maxlength="16" required>
    <label for="password">Password</label>
    <input type="password" id="password" name="password" maxlength="12" required>
    <button type="submit">Sign In</button>
</form>
</body>
</html>
