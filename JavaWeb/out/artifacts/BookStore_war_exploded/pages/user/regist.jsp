<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>书城会员注册页面</title>
	<%-- 静态包含 base标签 css样式 JQuery文件	--%>
	<%@include file="/pages/common/head.jsp"%>

		<script type="text/javascript">
		$(function () {

			$("#username").blur(function (){
				//1.获取用户名
				var username = this.value;
				//2.发起ajax请求
				$.getJSON("${basePath}userServlet","action=ajaxExistsUsername&username=" + username,function (data){
					if (data.exitsUsername == true){
						$("span.errorMsg").text("用户名已存在!");
					}else{
						$("span.errorMsg").text("用户名可用!");
					}
				})
			})

			//给验证码的图片绑定单击事件
			$("#code_img").click(function () {
				//在事件响应的function函数中有一个this对象,这个this对象时当前正在响应事件的dom对象
				this.src = "${basePath}kaptcha.jpg";
				// src 属性表示验证码 img 标签的 图片路径。它可读，可写
				// alert(this.src);
				//加上时间戳,就可以跳过浏览器的缓存
				this.src = "${basePath}kaptcha.jpg?d=" + new Date();
			})

			//给注册绑定单击事件
			$("#sub_btn").click(function () {
				// 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
					//1.获取用户输入内容
				var username = $("#username").val();
					//2.创建正则表达式对象
				var usernamePatt = /^\w{5,12}$/;
					//3.使用test()方法验证
				if (!usernamePatt.test(username)){
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
				if (!passwordPatt.test(password)){
					//4.给予用户提示
					$("span.errorMsg").text("密码不合法!");
					return false;
				}
				// 验证确认密码：和密码相同
				//1.获取用户输入内容
				var repwd = $("#repwd").val();
				if (repwd != password){
					//4.给予用户提示
					$("span.errorMsg").text("密码输入不一致!");
					return false;
				}

				// 邮箱验证：xxxxx@xxx.com
				//1.获取用户输入内容
				var emailText = $("#email").val();
				//2.创建正则表达式对象
				var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)$/;
				//3.使用test()方法验证
				if (!emailPatt.test(emailText)){
					//4.给予用户提示
					$("span.errorMsg").text("邮箱格式不合法!");
					return false;
				}

				// 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
				var codeText = $("#code").val();
				//去掉验证码前后的空格
				codeText = $.trim(codeText);
				if (codeText == "" || codeText == null){
					//4.给予用户提示
					$("span.errorMsg").text("验证码不能为空!");
					return false;
				}
				//信息校验都正确,清空提示信息
				$("span.errorMsg").text("");
			})
		})
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册书城会员</h1>
								<span class="errorMsg">
<%--									<%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>--%>
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
											value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
											value="${requestScope.email}" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 80px;" id="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width: 100px;height: 35px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--	静态包含页脚内容 --%>
		<%@include file="/pages/common/foot.jsp"%>
</body>
</html>