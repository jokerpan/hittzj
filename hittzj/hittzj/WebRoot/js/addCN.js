$(function(){
	function iscnname(obj){
		var reg = /^[\S]{2,15}$/;
		if(!reg.test(obj)){
			return false;
		}
		return true;
	}

	$('#addcn-name').blur(function(){
		if(!iscnname($(this).val())){
			$('#addcn-p').html('请输入2~15位商品名字');
		}else{
			$('#addcn-p').html('');
		}
	})

	$('#addcn-subm').click(function(event) {
		$('#addcn-form').attr('action', 'AddCN');
		if(iscnname($('#addcn-name').val())){
			$('#addcn-form').submit();
		}else{
			$('#addcn-p').html('请输入2~15位商品名字');
		}/* Act on the event */
	});

	$('#addcn-sub').click(function(event) {
		$('#addcn-form').attr('action', 'ModifyCN');
		if(iscnname($('#addcn-name').val())){
			$('#addcn-form').submit();
		}else{
			$('#addcn-p').html('请输入2~15位商品名字');
		}/* Act on the event */
	});

	$('#addcn-del').click(function(event) {
		$('#addcn-form').attr('action','DeleCN')
;
		$('#addcn-form').submit();/* Act on the event */
	});
})