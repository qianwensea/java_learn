<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">

	$(function () {
		//给注册绑定单击事件
		$("#sub_btn").click(function () {
			// 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
			// alert("成功进入");
			//1.获取用户输入内容
			var username = $("#username").val();
			//2.创建正则表达式对象
			var usernamePatt = /^\w{5,12}$/;
			//3.使用test()方法验证
			if (!usernamePatt.test(username)) {
				//4.给予用户提示
				$("span.errorMsg").text("用户名不合法!");
				return false;
			}
			// 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
			//1.获取用户输入内容
			var password = $("#password").val();
			//2.创建正则表达式对象
			var passwordPatt = /^\w{5,12}$/;
			//3.使用test()方法验证
			if (!passwordPatt.test(password)) {
				//4.给予用户提示
				$("span.errorMsg").text("密码不合法!");
				return false;
			}
			// 验证确认密码：和密码相同
			//1.获取用户输入内容
			var repwd = $("#repwd").val();
			if (repwd != password) {
				//4.给予用户提示
				$("span.errorMsg").text("密码输入不一致!");
				return false;
			}
			//信息校验都正确,清空提示信息
			$("span.errorMsg").text("");
		});
	});
</script>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
</head>
<body>
<div>
	<span class="errorMsg">
<%--<%=request.getAttribute("msg") == null ? "请输入用户名和密码" : request.getAttribute("msg")%>--%>
		${empty requestScope.msg ? "请输入用户名和密码" : requestScope.msg}
	</span>
</div>
<div class="form">
	<form action="userServlet" method="post">
		<input type="hidden" name="action" value="regist">
		<label>用户名称：</label>
		<input id="username" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
			   name="username" value="${requestScope.username}"/>
		<br/>
		<br/>
		<label>用户密码：</label>
		<input id="password" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
			   name="password"/>
		<br/>
		<br/>
		<label>确认密码：</label>
		<input id="repwd" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
			   name="repwd"/>
		<br/>
		<br/>
		<input type="submit" value="注册" id="sub_btn" />
	</form>
</div>
<div>
	<a href="index.jsp">
		<button>立即登录</button>
	</a>
</div>

</body>
</html>
