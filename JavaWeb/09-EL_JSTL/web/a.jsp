<%--
  Created by IntelliJ IDEA.
  User: 千文sea
  Date: 2020/4/22
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","value");
    %>
    表达式脚本输出key的值:<%=request.getAttribute("key")==null?"":request.getAttribute("key")%><br/>
    EL表达式输出key的值:${key}
</body>
</html>
