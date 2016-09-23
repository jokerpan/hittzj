<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isErrorPage="true"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>抱歉，遇到了问题</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	抱歉，服务器出现了一些问题，我们正在抓紧时间抢修，错误的原因是：<%=exception.toString()%>
	<br>
</body>
</html>
