<%--
  Created by IntelliJ IDEA.
  User: qianwensea
  Date: 2020/9/27
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">测试查询</a>

    <br/>
    <h3>测试保存</h3>
    <form action="account/save" method="post">
       姓名: <input type="text" name="name"/><br/>
       金额: <input type="text" name="money"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
