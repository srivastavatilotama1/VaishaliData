(function($) {
	$.displayAlert = function(message) {
			alert(message);
	};
	
	$.enableDisable=function(state){
	if(state)
		return true;
		else	
		return false;
	}
})(jQuery);
