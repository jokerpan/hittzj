<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport" id="viewport" />
<title>HITtzj</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/myalert.js"></script>
<script type="text/javascript" src="js/pwdChange.js"></script>
</head>
<body>
	<p>${requestScope.changePsdResult}</p>
	<div class="login-continer">
		<div class="register-continer">
			<h1 class="register-h1">修改密码</h1>
			<div class="register-form">
				<form id="pwdChange-form" method="post" action="ModifyPassword">
					<p class="p1-user"></p>
					<div class="register-div">
						用户名： <input type="text" id="pwd-user" name="count" maxlength="26" />
					</div>
					<p class="p1-pwd"></p>
					<div class="register-div">
						新密码： <input type="password" id="pwd-pwd" name="newpsd"
							maxlength="26" />
					</div>
					<p class="p1-again"></p>
					<div class="register-div">
						重复密码： <input type="password" id="pwd-again" name="psd"
							maxlength="26" />
					</div>
					<div class="register-div">
						密保问题： <select name="qid">
							<option value="1">你的生日</option>
							<option value="2">你的真实姓名</option>
							<option value="3">你父亲的真实名字</option>
							<option value="4">你母亲的真实名字</option>
							<option value="5">你的住址</option>
						</select>
					</div>
					<div class="register-div">
						密保答案： <input type="text" id="pwd-ans" name="answer" maxlength="26" />
					</div>
					<div class="register-sub">
						<input type="button" id="pwd-sub" name="pwd-sub" value="更改密码" />
					</div>
					<div style="position:absolute;bottom:0;right:5.5%;width:100%;text-align:right;">
						<a style="color:black;" herf="index.jsp">直接去主页</a> <a style="color:black;" href="register.jsp">快速注册</a> <a style="color:black;" herf="login.jsp">登录/注销</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>