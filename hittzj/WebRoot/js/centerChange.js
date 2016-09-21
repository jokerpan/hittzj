$(function(){
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

	$('#centerChange-num').blur(function(event) {
		if(!isphone($(this).val())){
			myalert('电话号码格式错误')
		}
	});

	$('#centerChange-qq').blur(function(event) {
		if(!isqq($(this).val())){
			myalert('qq号码格式错误')
		}/* Act on the event */
	});

	$('#center-sub').click(function(event) {
		if(isphone($('#centerChange-num').val()) && isqq($('#centerChange-qq').val())){
			$('#centerChange-form').submit();
		}else{
			myalert('亲。别闹~~');
		}/* Act on the event */
	});

	/*$('#centerChange-form').submit(function(event) {
		if(isphone($('#centerChange-num').val()) && isqq($('#centerChange-qq').val())){
		}else{
			myalert('亲。别闹~~')
		}
		return false;
		/* Act on the event 
	});*/
})