<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport" id="viewport" />
<title>欢迎注册</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="icon" href="img/title.png" type="image/x-icon"/>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/myalert.js"></script>
<script type="text/javascript" src="js/register.js"></script>
</head>
<body>
	<p>${requestScope.registerResult}</p>
	<div class="login-continer">
		<div class="register-continer">
			<h1 class="register-h1">个人信息</h1>
			<div class="register-form">
				<form id="register-form" method="post" action="Register">
					<p class="p-user"></p>
					<div class="register-div">
						账号： <input type="text" id="reg-user" name="count" maxlength="16" />
					</div>
					<div class="register-div">
						昵称： <input type="text" name="nickName" maxlength="26" />
					</div>
					<p class="p-pwd"></p>
					<div class="register-div">
						密码： <input type="password" id="reg-pwd" name="psd" maxlength="16" />
					</div>
					<p class="p-again"></p>
					<div class="register-div">
						重复密码： <input type="password" id="reg-again" name="register-pwd"
							maxlength="16" />
					</div>
					<p class="p-num"></p>
					<div class="register-div">
						手机号码： <input type="text" id="reg-num" name="phone" maxlength="11" />
					</div>
					<p class="p-qnum"></p>
					<div class="register-div">
						qq账号： <input type="text" id="reg-qnum" name="qq" maxlength="10" />
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
					<p></p>
					<div class="register-div">
						密保答案： <input type="text" id="reg-ans" name="answer" maxlength="26" />
					</div>
					<div class="register-sub">
						<input type="button" id="reg-sub" name="register-sub" value="戳我注册" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="login-foot">
			 <a href="index.jsp">不注册，直接去主页</a> <a href="changePassword.jsp">忘记密码</a> <a href="register.jsp">快速注册</a>  
		</div>
</body>
</html>
</html>
