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
<script type="text/javascript">
	function postwith(action, name, value) {

		// 创建一个 form  
		var form1 = document.createElement("form");
		form1.id = "form1";
		form1.name = "form1";

		// 添加到 body 中  
		document.body.appendChild(form1);

		// 创建一个输入  
		var input = document.createElement("input");
		// 设置相应参数  
		input.type = "text";
		input.name = name;
		input.value = value;

		// 将该输入框插入到 form 中  
		form1.appendChild(input);

		// form 的提交方式  
		form1.method = "POST";
		// form 提交路径  
		form1.action = action;

		// 对该 form 执行提交  
		form1.submit();
		// 删除该 form  
		document.body.removeChild(form1);
	}
</script>
</head>
<body>
	<div class="over"></div>
	<div class="login-continer">
		<div class="register-continer">
			<div class="center-a">
				<a
					href="javascript:postwith('ModifyCSForward','CSId','${requestScope.thisCS.id }')">编辑</a>
			</div>
			<div>
				<div class="amplifyImg">
					<img src="${requestScope.thisCS.img}" width="100%" />
				</div>
				<table border="2">
					<tbody>
						<tr>
							<th width="40%">商品编号</th>
							<td>${requestScope.thisCS.id}</td>
						</tr>
						<tr>
							<th>商品名：</th>
							<td>${requestScope.thisCS.name}</td>
						</tr>
						<tr>
							<th>商品描述：</th>
							<td>${requestScope.thisCS.desc}</td>
						</tr>
						<tr>
							<th>期望价格：</th>
							<td>${requestScope.thisCS.money}</td>
						</tr>
						<tr>
							<th>出售数量：</th>
							<td>${requestScope.thisCS.number}</td>
						</tr>
						<tr>
							<th>使用时间：</th>
							<td>${requestScope.thisCS.useTime}</td>
						</tr>
						<tr>
							<th>缺点：</th>
							<td>${requestScope.thisCS.number}</td>
						</tr>
						<tr>
							<th>联系电话：</th>
							<td>${requestScope.thisCS.user.phone}</td>
						</tr>
						<tr>
							<th>联系qq：</th>
							<td>${requestScope.thisCS.user.qq}</td>
						</tr>
						<tr>
							<th>期望交易地址：</th>
							<td>${requestScope.thisCS.location}</td>
						</tr>
					</tbody>
				</table>
			</div>
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
				<li><a href="">bug反馈/联系我们</a></li>
			</ul>
		</div>
	</div>
</body>
</html>




