<%--
  Created by IntelliJ IDEA.
  User: 千文sea
  Date: 2020/4/21
  Time: 17:01
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
        <jsp:include page=""></jsp:include> 这是动态包含
        page 属性是指定你要包含的 jsp 页面的路径
        动态包含也可以像静态包含一样。把被包含的内容执行输出到包含位置
        动态包含的特点：
        1、动态包含会把包含的 jsp 页面也翻译成为 java 代码
        2、动态包含底层代码使用如下代码去调用被包含的 jsp 页面执行输出。
        JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false);
        3、动态包含，还可以传递参数
    --%>
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="bbj"/>
        <jsp:param name="password" value="root"/>
    </jsp:include>
</body>
</html>
