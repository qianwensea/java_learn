<%--
  Created by IntelliJ IDEA.
  User: qianwensea
  Date: 2020/9/23
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>跳转成功了!!!</h3>

    ${requestScope.get("name")}
    <br/>
    ${sessionScope.get("name")}
</body>
</html>
