/*Function Plugin - 
It does not return jQuery Object.
Method chaining not supported
Directly extends the jQuery object
*/
(function($){
	$.displayAlert = function(msg){
		alert(msg);
	}
})(jQuery);