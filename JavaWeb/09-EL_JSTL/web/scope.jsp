<%--
  Created by IntelliJ IDEA.
  User: 千文sea
  Date: 2020/4/22
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key1", "pageContext1");
        pageContext.setAttribute("key2", "pageContext2");
        request.setAttribute("key2", "request");
        session.setAttribute("key2", "session");
        application.setAttribute("key2", "application");
    %>
    ${pageScope.key1}
    ${requestScope.key2}
    ${sessionScope.key2}
    ${applicationScope.key2}
</body>
</html>
