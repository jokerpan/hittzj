$(function(){
	function iscsname(obj){
		var reg = /^[\S]{2,15}$/;
		if(!reg.test(obj)){
			return false;
		}
		return true;
	}

	function iscsdesc(obj){
		var reg = /^[\S]{5,100}$/;
		if(!reg.test(obj)){
			return false;
		}
		return true;
	}


	function iscsmoney(obj){
		var reg = /^[\S]{2,10}$/;
		if(!reg.test(obj)){
			return false;
		}
		return true;
	}

	function iscstime(obj){
		var reg = /^[\S]{2,10}$/;
		if(!reg.test(obj)){
			return false;
		}
		return true;
	}

	$('#addcs-desc').blur(function(event) {
		if (!iscsdesc($(this).val())) {
			$('#addcs-p1').html('商品描述为5~100字');
		}else{
			$('#addcs-p1').html('');
		}
	});

	$('#addcs-name').blur(function(event) {
		if (!iscsname($(this).val())) {
			$('#addcs-p2').html('商品名字为2~15字');
		}else{
			$('#addcs-p2').html('');
		}
	});

	$('#addcs-time').blur(function(event) {
		if (!iscstime($(this).val())) {
			$('#addcs-p4').html('使用时间为2~10字');
		}else{
			$('#addcs-p4').html('');
		}
	});

	$('#addcs-money').blur(function(event) {
		if (!iscsmoney($(this).val())) {
			$('#addcs-p3').html('期望价格为2~10字');
		}else{
			$('#addcs-p3').html('');
		}
	});

	$('#addcs-subm').click(function(event) {
		$('#addcs-form').attr('action', 'AddCS');
		if (iscsname($('#addcs-name').val()) && iscsmoney($('#addcs-money').val())
			&& iscstime($('#addcs-time').val()) && iscsdesc($('#addcs-desc').val())) {
			$('#addcs-form').submit();
		}
	});

	$('#addcs-sub').click(function(event) {
		$('#addcs-form').attr('action', 'ModifyCS');
		if (iscsname($('#addcs-name').val()) && iscsmoney($('#addcs-money').val())
			&& iscstime($('#addcs-time').val()) && iscsdesc($('#addcs-desc').val())) {
			$('#addcs-form').submit();
		}
	});

	$('#addcs-del').click(function(event) {
		$('#addcs-form').attr('action', 'DeleCS');
		$('#addcs-form').submit();
		/* Act on the event */
	});
})