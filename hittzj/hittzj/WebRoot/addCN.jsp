<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>工大跳蚤街</title>

<link rel="icon" href="img/title.png" type="image/x-icon"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/jquery.mobile-1.3.2.min.css">
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/jquery.mobile-1.3.2.min.js"></script>
<script src="js/addCN.js"></script>
</head>
<body>
	<p>${requestScope.addCNResult}</p>
	<div data-role="page">
		<div data-role="header" data-position="fixed">
			<h1>添加求购信息</h1>
		</div>
		<div class="ui-content">
			<div class="file-box">
				<form id="addcn-form" action="AddCN" method="post"
					enctype="multipart/form-data" data-ajax="false">
					<input type="text" name="desc" placeholder="商品描述" maxlength="100" />
					<p style="font-size:12px;" id="addcn-p"></p>
					<input type="text" id="addcn-name" name="name" placeholder="商品名字"
						maxlength="15" /> <input type="text" name="money"
						placeholder="期望价格" maxlength="10" /> <input type="text"
						name="number" placeholder="期望数量" maxlength="10" /> <input
						type="text" name="location" placeholder="期望交易地址" maxlength="40" />
					<input type="file" accept="image/*" name="fileField" id="fileField" />
					<input type="button" id="addcn-subm" class="btn" value="上传" />
				</form>
			</div>
		</div>
		<div data-role="footer" data-position="fixed">
			<h1>工大最大的跳蚤市场</h1>
		</div>
	</div>
</body>
</html>
