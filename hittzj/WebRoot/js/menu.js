$(function(){
	$('.menu-btn').click(function(){
		if($('.menu-list').css('display')=='none'){
			$('.menu-list').stop().show(600);
		}
		else{
			$('.menu-list').stop().hide(600);
		}
	})
})