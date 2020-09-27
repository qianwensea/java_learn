<%--
  Created by IntelliJ IDEA.
  User: qianwensea
  Date: 2020/9/27
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询了所有账户的信息</h3>
    <c:forEach items="${accounts}" var="account">
        ${account.name}
    </c:forEach>
</body>
</html>
