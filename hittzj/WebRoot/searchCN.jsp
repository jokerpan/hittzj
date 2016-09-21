<%@page import="top.hittzj.entity.Commodity_Need"%>
<%@page import="top.hittzj.entity.TzjList"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<link rel="icon" href="img/title.png" type="image/x-icon"/>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport" id="viewport" />
<title>工大跳蚤街</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
<style type="text/css">
.float {
	box-sizing: border-box;
	float: left;
	font-size: 13px;
}

.color {
	color: #000;
}
</style>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/list.js"></script>
</head>
<body>
	<div class="login-continer">
		<div class="register-continer">
			<h3 id="flag">${requestScope.tag}</h3>
			<ul style="width:100%; margin-top:10px;" id="list" class = "list">
				<li><img src="${requestScope.CNList.list[0].img}" alt=""
					width="100px" height="100px;" />
					<div>
						<h4>${requestScope.CNList.list[0].name }</h4>
						<p>
							期望价格：<strong>${requestScope.CNList.list[0].money}</strong>
						</p>
						<p>
							商品编号：<small class="num">${requestScope.CNList.list[0].id
								}</small>
						</p>
						<p>
							求购人：<small>${requestScope.CNList.list[0].user.nickName }</small>
						</p>
					</div></li>
				<li><img src="${requestScope.CNList.list[1].img}" alt=""
					width="100px" height="100px;" />
					<div>
						<h4>${requestScope.CNList.list[2].name }</h4>
						<p>
							期望价格：<strong>${requestScope.CNList.list[2].money}</strong>
						</p>
						<p>
							商品编号：<small class="num">${requestScope.CNList.list[2].id
								}</small>
						</p>
						<p>
							求购人：<small>${requestScope.CNList.list[2].user.nickName }</small>
						</p>
					</div></li>
				<li><img src="${requestScope.CNList.list[3].img}" alt=""
					width="100px" height="100px;" />
					<div>
						<h4>${requestScope.CNList.list[3].name }</h4>
						<p>
							期望价格：<strong>${requestScope.CNList.list[3].money}</strong>
						</p>
						<p>
							商品编号：<small class="num">${requestScope.CNList.list[3].id
								}</small>
						</p>
						<p>
							求购人：<small>${requestScope.CNList.list[3].user.nickName }</small>
						</p>
					</div></li>
				<li><img src="${requestScope.CNList.list[4].img}" alt=""
					width="100px" height="100px;" />
					<div>
						<h4>${requestScope.CNList.list[4].name }</h4>
						<p>
							期望价格：<strong>${requestScope.CNList.list[4].money}</strong>
						</p>
						<p>
							商品编号：<small class="num">${requestScope.CNList.list[4].id
								}</small>
						</p>
						<p>
							求购人：<small>${requestScope.CNList.list[4].user.nickName }</small>
						</p>
					</div></li>
				<li><img src="${requestScope.CNList.list[5].img}" alt=""
					width="100px" height="100px;" />
					<div>
						<h4>${requestScope.CNList.list[5].name }</h4>
						<p>
							期望价格：<strong>${requestScope.CNList.list[5].money}</strong>
						</p>
						<p>
							商品编号：<small class="num">${requestScope.CNList.list[5].id
								}</small>
						</p>
						<p>
							求购人：<small>${requestScope.CNList.list[5].user.nickName }</small>
						</p>
					</div></li>
				<li><img src="${requestScope.CNList.list[6].img}" alt=""
					width="100px" height="100px;" />
					<div>
						<h4>${requestScope.CNList.list[6].name }</h4>
						<p>
							期望价格：<strong>${requestScope.CNList.list[6].money}</strong>
						</p>
						<p>
							商品编号：<small class="num">${requestScope.CNList.list[6].id
								}</small>
						</p>
						<p>
							求购人：<small>${requestScope.CNList.list[6].user.nickName }</small>
						</p>
					</div></li>
				<li><img src="${requestScope.CNList.list[7].img}" alt=""
					width="100px" height="100px;" />
					<div>
						<h4>${requestScope.CNList.list[7].name }</h4>
						<p>
							期望价格：<strong>${requestScope.CNList.list[7].money}</strong>
						</p>
						<p>
							商品编号：<small class="num">${requestScope.CNList.list[7].id
								}</small>
						</p>
						<p>
							求购人：<small>${requestScope.CNList.list[7].user.nickName }</small>
						</p>
					</div></li>
				<li><img src="${requestScope.CNList.list[8].img}" alt=""
					width="100px" height="100px;" />
					<div>
						<h4>${requestScope.CNList.list[8].name }</h4>
						<p>
							期望价格：<strong>${requestScope.CNList.list[8].money}</strong>
						</p>
						<p>
							商品编号：<small class="num">${requestScope.CNList.list[8].id
								}</small>
						</p>
						<p>
							求购人：<small>${requestScope.CNList.list[8].user.nickName }</small>
						</p>
					</div></li>
				<li><img src="${requestScope.CNList.list[9].img}" alt=""
					width="100px" height="100px;" />
					<div>
						<h4>${requestScope.CNList.list[9].name }</h4>
						<p>
							期望价格：<strong>${requestScope.CNList.list[9].money}</strong>
						</p>
						<p>
							商品编号：<small class="num">${requestScope.CNList.list[9].id
								}</small>
						</p>
						<p>
							求购人：<small>${requestScope.CNList.list[9].user.nickName }</small>
						</p>
					</div></li>
				<li><img src="${requestScope.CNList.list[0].img}" alt=""
					width="100px" height="100px;" />
					<div>
						<h4>${requestScope.CNList.list[0].name }</h4>
						<p>
							期望价格：<strong>${requestScope.CNList.list[0].money}</strong>
						</p>
						<p>
							商品编号：<small class="num">${requestScope.CNList.list[0].id
								}</small>
						</p>
						<p>
							求购人：<small>${requestScope.CNList.list[0].user.nickName }</small>
						</p>
					</div></li>
			</ul>
		</div>
		<div class="menu">
			<div class="menu-btn"></div>
			<ul class="menu-list">
				<li class="menu-name">${sessionScope.user.nickName}</li>
				<li><a href="login.jsp">登陆/注销</a></li>
				<li><a href="center.jsp">个人信息</a></li>
				<li><a href="addCN.jsp">我想买</a></li>
				<li><a href="addCS.jsp">我想卖</a></li>
				<li><a href="lang.html">浪圈</a></li>
				<li><a href="index.jsp">跳蚤街</a></li>
				<li><a href="connect.html">bug反馈/联系我们</a></li>
			</ul>
		</div>
	</div>
</body>
</html>

