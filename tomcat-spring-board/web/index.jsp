<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring Boot Board</title>
</head>
<body>
<h1>Spring Boot Board</h1>

<%-- 세션에서 userName 값 확인 --%>
<%
    String userName = (String) session.getAttribute("userName");
%>

<%-- 환영 메시지 표시 --%>
<% if (userName != null) { %>
<p><strong><%= userName %>님 환영합니다.</strong></p>
<ul>
    <li><a href="/sign-out">Sign Out</a></li>
</ul>
<% } else { %>
<ul>
    <li><a href="/sign-up">Sign Up</a></li>
    <li><a href="/sign-in">Sign In</a></li>
</ul>
<% } %>

</body>
</html>
