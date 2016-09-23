$(function(){
	var action;
	function postwith(action,name,value)  
			{  
			  
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


	$('#pwdchange').click(function(event) {
		window.location="changePassword.jsp"/* Act on the event */
	});

	$('#wantsale').click(function(event) {
		action = 'ShowCSByCollector';
		postwith(action, 'nextPage', '1');
	});

	$('#wantbuy').click(function(event) {
		action = 'ShowCNByCollector';
		postwith(action, 'nextPage', '1');
	});

	$('#mysale').click(function(event) {
		action = 'ShowCSByUser';
		postwith(action, 'nextPage', '1');
	});

	$('#mybuy').click(function(event) {
		action = 'ShowCNByUser';
		postwith(action, 'nextPage', '1');
	});
})