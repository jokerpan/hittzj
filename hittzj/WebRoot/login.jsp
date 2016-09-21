<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta

<%session.removeAttribute("user"); %>
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport" id="viewport" />
<title>欢迎登陆</title>
<link rel="icon" href="img/title.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/myalert.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<p>${requestScope.loginResult}</p>
	<div class="login-continer">
		<div class="login-form">
			<form method="post" action="Login" id="login-form">
				<div class="login-input">
					<input class="login-user" type="text" name="count"
						placeholder="Username" maxlength="10" />
					<p>and</p>
					<input class="login-pwd" type="password" name="psd"
						placeholder="Password" maxlength="10" />
				</div>
				<div class="login-img">
					<img name="login-sub" id="login-sub" src="img/log_btn.png"
						width="150" height="150" />
				</div>
			</form>
		</div>

		<div class="login-foot">
			 <a href="index.jsp">不登录，去主页</a> <a href="changePassword.jsp">忘记密码</a> <a href="register.jsp">快速注册</a>  
		</div>
	</div>
</body>
</html>
