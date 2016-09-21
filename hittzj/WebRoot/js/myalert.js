function windowsize(name,text){
	    
		var wsw=$(window).width() ; //屏幕宽度
		var wsh=$(window).height(); //屏幕高度
		$(name).text(text);
		var nh=$(name).height();
		var nw=$(name).outerWidth(true);
		$(name).css({"left":(wsw-nw)/2+"px","top":(wsh-nh)/2+"px"});
		
        $(name).fadeIn();
	
	
}
function myalert(text){ 
    $("<div></div>").addClass('myalert').appendTo($(document.body));
	
    windowsize('.myalert',text);
	setTimeout(function(){
	 $('.myalert').fadeOut(function(){
		     $(this).remove();
	 });  
	},2000);
}
