<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link rel="icon" href="img/title.png" type="image/x-icon" />
<meta
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport" id="viewport" />
<title>工大跳蚤街</title>
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
	function postwith1(action,name1,value1,name2,value2)  
			{  
			  
			    // 创建一个 form  
			    var form1 = document.createElement("form");  
			    form1.id = "form1";  
			    form1.name = "form1";  
			  
			    // 添加到 body 中  
			    document.body.appendChild(form1);  
			  
			    // 创建一个输入  
			    var input1 = document.createElement("input");  
			    var input2 = document.createElement("input");
			    // 设置相应参数  
			    input1.type = "text";  
			    input1.name = name1;  
			    input1.value = value1; 
			    input2.type = "text";   
			    input2.name = name2;  
			    input2.value = value2; 
			  
			    // 将该输入框插入到 form 中  
			    form1.appendChild(input1);  
			    form1.appendChild(input2);
			  
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
<script type="text/javascript">
	$(function(){
				$('#index-solr').click(function(event) {
					if($('#index-txt').val() != '')
						{
							context = $('#index-txt').val();
							postwith1('Search','searchId','1','context',context);
						}/* Act on the event */
				});

				$('#index-solr2').click(function(event) {
					if($('#index-txt').val() != '')
						{
							context = $('#index-txt').val();
							postwith1('Search','searchId','1','context',context);
						}/* Act on the event */
				});
			})

</script>
</head>
<body>
	<p>${requestScope.loginResult}</p>
	<p>${requestScope.modifyCNResult}</p>
	<p>${requestScope.modifyCSResult}</p>
	<p>${requestScope.addCSResult}</p>
	<p>${requestScope.addCNResult}</p>
	<p>${requestScope.changePsdResult }</p>

	<div class="login-continer index">
			<input type="text" id="index-txt" class="index-solr" name="context"
				placeholder="     跳蚤一下" /> <input type="button" id="index-solr"
				class="index-btn" value="搜出售" /> <input type="button"
				id="index-solr2" class="index-btn1" value="搜求购" />
		<button class="btn btn-Borderblack"
			style="position:absolute;top:520px;background:rgba(0,0,0,0.3);color:#fff;">
			<a href="javascript:postwith('ShowCS','name','id')">显示所有待出售的商品</a>
		</button>
		<button class="btn btn-Borderblack"
			style="position:absolute;top:550px;margin-bottom:50px;background:rgba(0,0,0,0.3);color:#fff;">
			<a href="javascript:postwith('ShowCN','name','id')">显示所有求购的商品</a>
		</button>
		<div class="index-back index-cloth">
			<img src="img/cloth.png" height="60px" /> <a class="man"
				href="javascript:postwith('ShowCSByType','tpyeId','1')">男装</a> <a
				class="woman"
				href="javascript:postwith('ShowCSByType','tpyeId','2')">女装</a> <a
				class="bag" href="javascript:postwith('ShowCSByType','tpyeId','3')">包</a>
		</div>
		<div class="index-back index-game">
			<img src="img/key.png" height="70px" width="30%"
				style="position:absolute;top:10px;left:0;" /> <img
				src="img/hand.png" height="70px" width="30%"
				style="position:absolute;top:10px;left:35%;" /> <img
				src="img/pc.png" height="70px" width="30%"
				style="position:absolute;top:10px;right:5%;" /> <a class="shuma"
				href="javascript:postwith('ShowCSByType','tpyeId','4')">数码电器</a> <a
				class="game" href="javascript:postwith('ShowCSByType','tpyeId','5')">游戏</a>
		</div>
		<div class="index-back index-sport">
			<img src="img/sport.png" height="50px" /> <a
				href="javascript:postwith('ShowCSByType','tpyeId','6')">户外运动</a>
		</div>
		<div class="index-back index-book">
			<img src="img/head.png" height="50px" /> <a
				href="javascript:postwith('ShowCSByType','tpyeId','7')">学习</a>
		</div>
		<div class="index-back index-other">
			<a href="javascript:postwith('ShowCSByType','tpyeId','10')">食品</a> <a
				href="javascript:postwith('ShowCSByType','tpyeId','8')">日常用品</a> <a
				href="javascript:postwith('ShowCSByType','tpyeId','9')">收藏品</a> <a
				href="javascript:postwith('ShowCSByType','tpyeId','11')">其他</a>
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