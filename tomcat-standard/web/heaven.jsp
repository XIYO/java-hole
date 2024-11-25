<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Heaven Page</title>
</head>
<body>
<h1>Heaven Page</h1>

<%-- 파라미터 받기 --%>
<%
    String name = request.getParameter("name"); // "name" 파라미터 받기
    if (name == null || name.isEmpty()) {
        name = "Guest"; // 기본값 설정
    }
%>

<p>Welcome, <strong><%= name %></strong>!</p>

<%-- 추가 정보 표시 --%>
<p>오늘은 <%= new java.util.Date() %> 입니다.</p>

</body>
</html>
