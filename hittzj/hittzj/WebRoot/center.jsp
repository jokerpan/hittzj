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
<link rel="stylesheet" type="text/css" href="css/button.css" />
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/center.js"></script>
</head>
<body>
	<p>${requestScope.changeUserInfoResult}</p>
	<div class="login-continer">
		<div class="register-continer center">
			<div class="center-a">
				<a href="userInfoChange.jsp">编辑</a>
			</div>
			<div class="center-info">
				<p>昵称</p>
				<p class="center-name">${sessionScope.user.nickName}</p>
				<p>qq账号:</p>
				<p class="center-qq">${sessionScope.user.qq}</p>
				<p>手机号码:</p>
				<p class="center-num">${sessionScope.user.phone}</p>
			</div>
			<!--  
			<button class="btn btn-Borderblack" id="wantsale">我收藏的卖品</button>
			<button class="btn btn-Borderblack" id="wantbuy">我收藏的求购</button>-->
			<button class="btn btn-Borderblack" id="pwdchange">密码修改</button>
			<button class="btn btn-Borderblack" id="mysale">我发布的卖品</button>
			<button class="btn btn-Borderblack" id="mybuy">我发布的求购</button>
		</div>
		<div class="menu">
			<div class="menu-btn"></div>
			<ul class="menu-list">
				<li class="menu-name">${SessionScope.user.nickName}</li>
				<li><a href="login.jsp">登陆/注销</a>
				</li>
				<li><a href="center.jsp">个人信息</a>
				</li>
				<li><a href="addCS.jsp">添加出售商品</a>
				</li>
				<li><a href="addCN.jsp">添加求购商品</a>
				</li>
				<li><a href="lang.html">浪圈</a>
				</li>
				<li><a href="index.jsp">跳蚤街</a>
				</li>
				<li><a href="connect.html">bug反馈/联系我们</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
