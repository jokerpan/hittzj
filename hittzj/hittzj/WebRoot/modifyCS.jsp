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
<script src="js/addCS.js"></script>  
</head>  
<body>  
<div data-role="page">  
  <div data-role="header" data-position="fixed">  
    <h1>修改卖品</h1>  
  </div>  
  <div class="ui-content"> 
    <img src="img/head.png" width="100%" />
    <div class="file-box">  
        <form id="addcs-form" method="post" enctype="multipart/form-data"  data-ajax="false">  
            <p style="font-size:13px;">商品编号：</p>
            <input type="text" name="CSId" value="${requestScope.thisCS.id }" placeholder="${requestScope.thisCS.id }" readonly="true" />
            <p style="font-size:13px;">商品种类：</p>
            <select name="typeId">
              <option value="1">男装</option>
              <option value="2">女装</option>
              <option value="3">包</option>
              <option value="4">数码电器</option>
              <option value="5">游戏</option>
              <option value="6">户外运动</option>
              <option value="7">学习</option>
              <option value="8">日常用品</option>
              <option value="9">收藏品</option>
              <option value="10">食品</option>  
              <option value="11">其他</option>            
            </select>
            <p style="font-size:13px;">商品名字：</p>
            <p style="font-size:12px;color:red;" id="addcs-p2"></p>
            <input type="text" id="addcs-name" name="name" placeholder="商品名字" maxlength="15" value="${requestScope.thisCS.name }" />
            <p style="font-size:13px;">商品描述：</p>
            <p style="font-size:12px;color:red;" id="addcs-p1"></p>
            <input type="text" id="addcs-desc" name="desc" placeholder="商品描述" maxlength="100" value="${requestScope.thisCS.desc }" />
            <p style="font-size:13px;">期望价格：</p>
            <p style="font-size:12px;color:red;" id="addcs-p3"></p>
            <input type="text" id="addcs-money" name="money" placeholder="期望价格" maxlength="10" value="${requestScope.thisCS.money }" />
            <p style="font-size:13px;">数量：</p>
            <input type="text" name="number" placeholder="数量" maxlength="10" value="${requestScope.thisCS.number }" />
            <p style="font-size:13px;">使用时间：</p>
            <p style="font-size:12px;color:red;" id="addcs-p4"></p>
            <input type="text" id="addcs-time" name="useTime" placeholder="使用时间" maxlength="10" value="${requestScope.thisCS.useTime }" />
            <p style="font-size:13px;">缺点：</p>
            <input type="text" name="flaw" placeholder="缺点" maxlength="40" value="${requestScope.thisCS.flaw }" />
            <p style="font-size:13px;">期望交易地址：</p>
            <input type="text" name="location" placeholder="期望交易地址" maxlength="40" value="${requestScope.thisCS.location }" />
            <p style="font-size:13px;">上传新照片：</p>
            <input type="file" accept="image/*" name="fileField" value="重新上传" />  
            <input type="button" id="addcs-sub" class="btn" value="上传" /> 
            <input type="button" id="addcs-del" class="btn" value="删除该商品" /> 
        </form>  
    </div>   
  </div>  
  <div data-role="footer" data-position="fixed">  
    <h4>哈工大最大的二手皮革厂</h4>  
  </div>  
</div>  
</body>  
</html>  


