<%--
  Created by IntelliJ IDEA.
  User: 千文sea
  Date: 2020/4/29
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="registServlet" method="get">
    用户名: <input type="text" name="username" > <br/>
    验证码: <input type="text" style="width: 60px" name="code">
    <img src="kaptcha.jpg" style="width: 80px;height: 28px"><br/>
    <input type="submit" value="提交">
  </form>
  </body>
</html>
