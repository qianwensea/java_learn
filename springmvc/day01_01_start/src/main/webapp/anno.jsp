<%--
  Created by IntelliJ IDEA.
  User: qianwensea
  Date: 2020/9/23
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>常用的注解</h3>

    <a href="anno/testRequestParam?username=hehe">测试RequestParam</a>

<br>
    <form action="anno/testRequestBody" method="post" accept-charset="UTF-8">
        用户姓名:<input type="text" name="uname"/>
        用户年龄:<input type="text" name="age"/>
                <input type="submit" name="提交"/>
    </form>

<br/>
    <a href="anno/testPathVariable/10">测试PathVariable</a>
<br/>
    <a href="anno/testRequestHeader">测试RequestHeader</a>
<br/>
    <a href="anno/testCookieValue">测试CookieValue</a>
<br/>
    <form action="anno/testModelAttribute" method="post" accept-charset="UTF-8">
        用户姓名:<input type="text" name="uname"/>
        用户年龄:<input type="text" name="age"/>
        <input type="submit" name="提交"/>
    </form>
<br/>
    <a href="anno/testSessionAttributes">测试SessionAttributes</a>
    <br/>
    <a href="anno/getSessionAttributes">测试getSessionAttributes</a>
<br/>
    <a href="anno/deleteSessionAttributes">测试deleteSessionAttributes</a>
</body>
</html>
