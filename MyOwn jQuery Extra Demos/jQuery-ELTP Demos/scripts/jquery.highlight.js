/*Method Plugin - 
It must return jQuery Object.
Method chaining supported
Directly extends the jQuery.fn object
*/
(function($){
	$.fn.highlight = function(foreColor,backcolor){
		return this.each(function(){
			$(this).css({
				'color':foreColor,
				'background-color':backcolor
			});
		});
	}
})(jQuery);