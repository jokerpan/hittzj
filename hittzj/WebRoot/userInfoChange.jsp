<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport" id="viewport" />
<title>工大跳蚤街</title>
<link rel="icon" href="img/title.png" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/myalert.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/centerChange.js"></script>
</head>
<body>
	<p>${requestScope.changeUserInfoResult}</p>
	<div class="login-continer">
		<div class="register-continer">
			<form class="centerChange-form" id="centerChange-form"
				action="ModifyUserInfo" method="post" accept-charset="utf-8">

				<table class="centerChange" cellpadding="0" cellspacing="0">
					<tr>
						<th>昵称</th>
						<td><input type="text" id="centerChange-name" name="nickName"
							value="${sessionScope.user.nickName}" maxlength="10" /></td>
					</tr>
					<tr>
						<th>qq账号</th>
						<td><input type="text" id="centerChange-qq" name="qq"
							value="${sessionScope.user.qq}" /></td>
					</tr>
					<tr>
						<th>手机号码</th>
						<td><input id="centerChange-num" type="text" name="phone"
							value="${sessionScope.user.phone}" /></td>
					</tr>
				</table>
				<input class="center-sub" id="center-sub" type="button"
					name="centerinfo-sub" value="确认修改" />
			</form>

		</div>
		<div class="menu">
			<div class="menu-btn"></div>
			<ul class="menu-list">
				<li class="menu-name">${SessionScope.user.nickName}</li>
				<li><a href="login.jsp">登陆/注销</a></li>
				<li><a href="center.jsp">个人信息</a></li>
				<li><a href="addCS.jsp">添加出售商品</a></li>
				<li><a href="addCN.jsp">添加求购商品</a></li>
				<li><a href="lang.html">浪圈</a></li>
				<li><a href="index.jsp">跳蚤街</a></li>
				<li><a href="connect.html">bug反馈/联系我们</a></li>
			</ul>
		</div>
	</div>
</body>
</html>