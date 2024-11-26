<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <style>
        form {
            display: flex;
            flex-direction: column;
            width: 300px;
            gap: 10px;
        }
        .error {
            color: red;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
<h1>Sign Up</h1>

<!-- 에러 메시지 표시 -->
<div class="error">${error}</div>

<form action="/sign-up" method="post">
    <label for="username">Username</label>
    <input type="text" id="username" name="username" placeholder="아이디를 입력하세요." minlength="4" maxlength="16" required>

    <label for="password">Password</label>
    <input type="password" id="password" name="password" maxlength="12" required>
    <label for="password2">Password 를 한번 더 입력하세요.</label>
    <input type="password" id="password2" name="password2" maxlength="12" required>

    <label for="name">Name</label>
    <input type="text" id="name" name="name" placeholder="이름을 입력하세요." minlength="2" maxlength="16" required>

    <label for="email">Email</label>
    <input type="email" id="email" name="email" placeholder="이메일을 입력하세요." required>

    <button id="sign-up" type="submit">Sign Up</button>
</form>

<script>
    const password = document.getElementById("password");
    const password2 = document.getElementById("password2");
    const sign_up = document.getElementById("sign-up");

    password2.addEventListener("input", function () {
        if (password.value !== password2.value) {
            password2.setCustomValidity("비밀번호가 일치하지 않습니다.");
            sign_up.disabled = true;
        } else {
            password2.setCustomValidity("");
            sign_up.disabled = false;
        }
    });
</script>
</body>
</html>
