<%--
  Created by IntelliJ IDEA.
  User: 千文sea
  Date: 2020/4/21
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br/>
    主体信息<br/>
    <%--
        <%@ include file=""%> 就是静态包含
        file 属性指定你要包含的 jsp 页面的路径
        地址中第一个斜杠 / 表示为 http://ip:port/工程路径/ 映射到代码的 web 目录
        静态包含的特点：
        1、静态包含不会翻译被包含的 jsp 页面。
        2、静态包含其实是把被包含的 jsp 页面的代码拷贝到包含的位置执行输出。
    --%>
    <%@ include file="/include/footer.jsp"%>
</body>
</html>
