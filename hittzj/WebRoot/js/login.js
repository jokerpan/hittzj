
$(function(){
	function ispwd(obj){
		var reg=/^[0-9]{8,10}$/;
		if(!reg.test(obj))
		{
			myalert('账号或密码格式不正确');
			return false;
		}
		return true;
	}


	function isname(obj){
		var reg=/^[0-9]{8,10}$/;
		if(!reg.test(obj))
		{
			return false;
		}
		return true;
	}


	$('.login-user').blur(function(){
		if($('.login-user').val() == "")
		{
			myalert('请填写用户名');
		}
	})

	$('#login-sub').click(function(event) {
		if(isname($('.login-user').val()) && ispwd($('.login-pwd').val())){
			$('#login-form').submit();
		}else{
			myalert('账号或密码错误');
		}/* Act on the event */
	});

	/*$('#login-form').submit(function(){
	if(isright($('.login-user').val()) && isright($('.login-pwd').val())){
	}else{
		myalert('账号或密码错误')
	}
	return false;
	})*/

})