<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Out</title>
    <script>
        // 3초 후 루트("/")로 이동
        setTimeout(function () {
            window.location.href = "/";
        }, 3000);
    </script>
</head>
<body>
<h1>로그아웃 완료</h1>

<%-- 사용자 이름 표시 --%>
<p>안녕히 가세요, <strong>${userName}</strong>님.</p>

<p>성공적으로 로그아웃되었습니다. 3초 후 메인 페이지로 이동합니다.</p>
<p>즉시 이동하려면 <a href="/">여기</a>를 클릭하세요.</p>
</body>
</html>
