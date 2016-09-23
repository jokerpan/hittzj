$(function(){
	function isname(obj){
		var reg=/^[0-9]{8,10}$/;
		if(!reg.test(obj))
		{
			return false;
		}
		return true;
	}


	function ispwd(obj){
		var reg=/^[0-9]{8,10}$/;
		if(!reg.test(obj))
		{
			return false;
		}
		return true;
	}

	function iscopy(obj1,obj2){
		if(obj1!=obj2){
			return false;
		}
		return true;
	}

	$('#pwd-user').blur(function(){
		if(!isname($(this).val())){
			$('.p1-user').html('用户名格式为8~10位数字');
		}else{
			$('.p1-user').html('');
		}
	})


	$('#pwd-pwd').blur(function(){
		if(!ispwd($(this).val())){
			$('.p1-pwd').html('密码格式为8~10位数字');
		}else{
			$('.p1-pwd').html('');
		}
	})

	$('#pwd-again').blur(function(){
		if(!iscopy($(this).val(),$('#pwd-pwd').val())){
			$('.p1-again').html('两次密码输入不一致');
		}else{
			$('.p1-again').html('');
		}
	})

	$('#pwd-sub').click(function(event) {
		if($('#pwd-ans').val() != '' && isname($('#pwd-user').val()) && ispwd($('#pwd-pwd').val()) && iscopy($('#pwd-again').val(),$('#pwd-pwd').val())){
			$('#pwdChange-form').submit();
		}else{
			myalert('请按要求填写');
		}/* Act on the event */
	});

	/*$('#pwdChange-form').submit(function(event) {
		if($('#pwd-ans').val() != '' && isright($('#pwd-user').val()) && isright($('#pwd-pwd').val()) && iscopy($('#pwd-again').val(),$('#pwd-pwd').val())){
		}else{
			myalert('请按要求填写');
		}
		return false;/* Act on the event /
	});*/
})