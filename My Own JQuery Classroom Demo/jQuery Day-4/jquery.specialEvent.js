/*Special Event API*/
(function ($) {
	$.event.special.hovercursor = {
	   setup: function() {
		$(this).bind('mouseenter', $.event.special.hovercursor.handler);
		  
	   },
	   teardown: function() {
		  $(this).unbind('mouseenter', $.event.special.hovercursor.handler);
	   },
	   handler: function () {
			$(this).css('cursor','pointer');
		}
	};
})(jQuery);
