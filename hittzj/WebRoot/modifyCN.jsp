<%@page import="top.hittzj.entity.Commodity_Need"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>  
<head><title>工大跳蚤街</title>  
<link rel="icon" href="img/title.png" type="image/x-icon"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<meta name="viewport" content="width=device-width, initial-scale=1.0">  
<link rel="stylesheet" href="css/jquery.mobile-1.3.2.min.css">  
<script src="js/jquery-1.8.3.min.js"></script>  
<script src="js/jquery.mobile-1.3.2.min.js"></script>
<script src="js/addCN.js"></script>  
</head>  
<body>  
<div data-role="page">  
  <div data-role="header" data-position="fixed">  
    <h1>修改求购</h1>  
  </div>  
  <div class="ui-content"> 
    <img src="img/head.png" width="100%" />
    <div class="file-box">  
        <form id="addcn-form" action="ModifyCN" method="post" enctype="multipart/form-data"  data-ajax="false">  
            <p style="font-size:13px;">商品id：</p>
            <input type="text" name="CNId" value="${requestScope.thisCN.id }" placeholder=" placeholder="${requestScope.thisCN.id }" readonly="true" />
            <p style="font-size:13px;">商品名字：</p>
            <p style="font-size:12px;color:red;" id="addcn-p"></p>
            <input type="text" id="addcn-name" name="name" placeholder="商品名字" maxlength="15" value="${requestScope.thisCN.name }" />
            <p style="font-size:13px;">商品描述：</p>
            <input type="text"name="desc" placeholder="商品描述" maxlength="100" value="${requestScope.thisCN.desc}" />
            <p style="font-size:13px;">期望价格：</p>
            <input type="text"name="money" placeholder="期望价格" maxlength="10" value="${requestScope.thisCN.money }" />
            <p style="font-size:13px;">期望数量：</p>
            <input type="text" name="number" placeholder="数量" maxlength="10" value="${requestScope.thisCN.number }" />
            <p style="font-size:13px;">期望交易地址：</p>
            <input type="text" name="location" placeholder="期望交易地址" maxlength="40" value="${requestScope.thisCN.location }" />
            <p style="font-size:13px;">上传新照片：</p>
            <input type="file" accept="image/*" name="fileField" value="重新上传" /> 
            <input type="button" id="addcn-sub" class="btn" value="确认修改" /> 
            <input type="button" id="addcn-del" class="btn" value="撤销该求购" />  
        </form>  
    </div>   
  </div>  
  <div data-role="footer" data-position="fixed">  
    <h4>哈工大最大的二手皮革厂</h4>  
  </div>  
</div>  
</body>  
</html>  