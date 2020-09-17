<%--
  Created by IntelliJ IDEA.
  User: qianwensea
  Date: 2020/9/10
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<div class="msg_cont">
    <b></b>
    <span class="errorMsg">
<%--<%=request.getAttribute("msg") == null ? "请输入用户名和密码" : request.getAttribute("msg")%>--%>
		${empty requestScope.msg ? "请输入用户名和密码" : requestScope.msg}
	</span>
</div>
<div class="form">
    <form action="userServlet" method="post">
        <input type="hidden" name="action" value="login">
        <label>用户名称：</label>
        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
               name="username" value="${requestScope.username}"/>
        <br/>
        <br/>
        <label>用户密码：</label>
        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
               name="password"/>
        <br/>
        <br/>
        <input type="submit" value="登录" id="sub_btn"/>
    </form>
</div>
<div>
    <a href="regist.jsp"><button>立即注册</button></a>
</div>

</body>
</html>
