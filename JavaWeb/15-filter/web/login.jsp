<%--
  Created by IntelliJ IDEA.
  User: 千文sea
  Date: 2020/5/2
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是登录页面-login.jsp<br/>
    <form action="http://localhost:8080/15_filter/loginServlet" method="get">
        用户名: <input type="text" name="username"/> <br/>
        密码: <input type="password" name="password"> <br/>
        <input type="submit" name="提交">
    </form>
</body>
</html>
