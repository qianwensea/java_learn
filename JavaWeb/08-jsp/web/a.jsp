<%--
  Created by IntelliJ IDEA.
  User: 千文sea
  Date: 2020/4/21
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         errorPage="/error500.jsp"
         language="java" %>

<!--
errorPage 表示错误后自动跳转去的路径 <br/>
这个路径一般都是以斜杠打头，它表示请求地址为 http://ip:port/工程路径/
映射到代码的 Web 目录
-->
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是一个html页面数据
    <%
//        int i = 1/0;
    %>

    <!-- 这是 html 注释 -->
    <%
        // 单行 java 注释
        /* 多行 java 注释 */
    %>
    <%-- 这是 jsp 注释 --%>
</body>
</html>
