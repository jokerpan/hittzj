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

	function isphone(obj){
		var reg1=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
		var reg2=/^(\+\d{2,3}\-)?\d{11}$/;
		if (reg1.test(obj) || reg2.test(obj)) {
			return true;
		}
		return false;
	}

	function isqq(obj){
		var reg=/[1-9][0-9]{4,}/;
		if(!reg.test(obj))
		{
			return false;
		}
		return true;
	}


	$('#reg-user').blur(function(){
		if(!isname($(this).val())){
			$('.p-user').html('用户名格式为8~10位数字');
		}else{
			$('.p-user').html('');
		}
	})

	$('#reg-pwd').blur(function(){
		if(!ispwd($(this).val())){
			$('.p-pwd').html('密码格式为8~10位数字');
		}else{
			$('.p-pwd').html('');
		}
	})

	$('#reg-again').blur(function(){
		if(!iscopy($(this).val(),$('#reg-pwd').val())){
			$('.p-again').html('两次密码输入不一致');
		}else{
			$('.p-again').html('');
		}
	})

	$('#reg-num').blur(function(){
		if(!isphone($(this).val())){
			$('.p-num').html('电话号码格式不正确');
		}else{
			$('.p-num').html('');
		}
	})

	$('#reg-qnum').blur(function(){
		if(!isqq($(this).val())){
			$('.p-qnum').html('QQ号码格式不正确');
		}else{
			$('.p-qnum').html('');
		}
	})

	$('#reg-sub').click(function(event) {
		if($('#reg-ans').val() != '' && isname($('#reg-user').val()) && ispwd($('#reg-pwd').val()) && isphone($('#reg-num').val()) && isqq($('#reg-qnum').val())){
			$('#register-form').submit();
		}else{
			myalert('请按要求填写');
		}/* Act on the event */
	});

	/*$('#register-form').submit(function(event) {
		if($('#reg-ans').val() != '' && isright($('#reg-user').val()) && isright($('#reg-pwd').val()) && isphone($('#reg-num').val()) && isqq($('#reg-qnum').val())){
		}else{
			myalert('请按要求填写');
		}
		return false;
	})*/
})