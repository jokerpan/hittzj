<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>  
<head><title>工大跳蚤街</title>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<meta name="viewport" content="width=device-width, initial-scale=1.0">  
<link rel="stylesheet" href="css/jquery.mobile-1.3.2.min.css">  
<script src="js/jquery-1.8.3.min.js"></script>  
<script src="js/jquery.mobile-1.3.2.min.js"></script>
<script src="js/addCS.js"></script>  
</head>  
<body>  
<p>${requestScope.addCSResult}</p>
<div data-role="page">  
  <div data-role="header" data-position="fixed">  
    <h1>发布出售信息</h1>  
  </div>  
  <div class="ui-content"> 
    <div class="file-box">  
        <form id="addcs-form" action="AddCS" method="post" enctype="multipart/form-data"  data-ajax="false">  
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
            <p style="font-size:12px;color:red;" id="addcs-p1"></p>
            <input type="text" id="addcs-desc" name="desc" placeholder="商品描述" maxlength="100" />
            <p style="font-size:12px;color:red;" id="addcs-p2"></p>
            <input type="text" id="addcs-name" name="name" placeholder="商品名字" maxlength="15" />
            <p style="font-size:12px;color:red;" id="addcs-p3"></p>
            <input type="text" id="addcs-money" name="money" placeholder="期望价格" maxlength="10" />
            <input type="text" name="number" placeholder="数量" maxlength="10" />
            <p style="font-size:12px;color:red;" id="addcs-p4"></p>
            <input type="text" id="addcs-time" name="useTime" placeholder="使用时间" maxlength="10" />
            <input type="text" name="flaw" placeholder="缺点" maxlength="40" />
            <input type="text" name="location" placeholder="期望交易地址" maxlength="40" />
            <input type="file" accept="image/*" name="fileField"  />  
            <input type="button" id="addcs-subm" class="btn" value="发布！" />  
        </form>  
    </div>   
  </div>  
  <div data-role="footer" data-position="fixed">  
    <h4>哈工大最大的二手皮革厂</h4>  
  </div>  
</div>  
</body>  
</html>  