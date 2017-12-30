(function($) {
	$.fn.optionPlugin = function(options) {
		var defaults = {
			fgColor : 'white',
			bgColor : 'crimson'
		};

	var option = $.extend(defaults, options);
		
	return this.each(function() {
		var element = $(this);
		element.css({
					'font-weight': 'bold', 
					'color': option.fgColor,
					'background-color': option.bgColor
					});
		});
	}
})(jQuery);



