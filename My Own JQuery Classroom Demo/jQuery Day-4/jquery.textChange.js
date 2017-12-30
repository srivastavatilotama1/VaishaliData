(function ($) {
	$.event.special.hastext = {
		
		setup: function (data, namespaces) {
			$(this).bind('textchange', $.event.special.hastext.handler);
		},
		
		teardown: function (namespaces) {
			$(this).unbind('textchange', $.event.special.hastext.handler);
		},
		
		handler: function (event, lastValue) {
			if ((lastValue === '') && lastValue !== $(this).val()) {
				$(this).trigger('hastext');
			}
		}
	};
	
	$.event.special.notext = {
		
		setup: function (data, namespaces) {
			$(this).bind('textchange', $.event.special.notext.handler);
		},
		
		teardown: function (namespaces) {
			$(this).unbind('textchange', $.event.special.notext.handler);
		},
		
		handler: function (event, lastValue) {
			if ($(this).val() === '' && $(this).val() !== lastValue) {
				$(this).trigger('notext');
			}
		}
	};	

})(jQuery);
