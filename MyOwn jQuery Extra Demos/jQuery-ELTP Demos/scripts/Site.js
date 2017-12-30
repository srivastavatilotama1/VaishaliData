var counter = 1;
$(function(){
	initialize();
});

var initialize = function(){
	jQueryUIInitialization();
	wireEvents();
}

var jQueryUIInitialization = function(){
	/* jQuery-UI buttons */
	$('#btnSimpleDialog').button();
	$('#btnModalDialog').button();
	
	/* jQuery-UI Simple Dialog */
	$('#simpleDialog').dialog({autoOpen: false});
	
	/* jQuery-UI Modal Dialog */
	$('#modalDialog').dialog({
		width:300,
		height:250,
		autoOpen: false,
		modal:true,
		resizable:false,
		draggable:false,
		buttons:{
			"OK":function(){
				$('#modalDialog').dialog('close');
				$('#modalTarget').text('OK Pressed');
			},
			"Cancel":function(){
				$('#modalDialog').dialog('close');
				$('#modalTarget').text('Cancel Pressed');
			}
		}
	});

	/*ProgressBar Initialization*/

	$("#prgBar").progressbar({
		value: 0
	});
	
	/*Calling Counter function*/
	progressCounter();
	
	/*Slider Initialization*/
	$('#sliderRed').slider({min:0,max:255,value:0,slide:changeSliderValue});
	$('#sliderGreen').slider({min:0,max:255,value:0,slide:changeSliderValue});
	$('#sliderBlue').slider({min:0,max:255,value:0,slide:changeSliderValue});
	
	/*DatePicker*/
	$(':text[data-site-datepicker="true"]').each(createDatePicker);
	
	/*Tab Initialization*/
	$('#tabs').tabs();
	
	/*accordion Initialization*/
	$('#accordion').accordion({
		autoHeight:false,
		collapsible:true
	});
	
	/*Autocomplete*/
	$(':text[data-site-autocomplete]').each(createAutoComplete);

	/*Tooltip*/
	$(':text').tooltip();
	
	/*Draggables*/
	$('#one').draggable();
	$('#two').draggable({handle:"h3"});
	$('#three').draggable({snap:"#one"});
	
	$('#one,#two,#three').draggable("option","stack",".ui-draggable");
	
	/*Droppable*/
	$('#dropTarget').droppable({
		drop:function(event,ui){
			ui.draggable.remove();
		}
	});
}


var wireEvents = function(){
	$('#btnSimpleDialog').bind('click',function(){
		$('#simpleDialog').dialog('open');
	});
	
	$('#btnModalDialog').bind('click',function(){
		$('#modalDialog').dialog('open');
	});
	
	$('#effectsDiv').bind('click',function(){
		var options ={
			"width":"+=100",
			"height":"+=100",
			"background-color":"green"
		}
		$(this).animate(options,5000,"easeInBounce").effect("explode",{pieces:4},5000,function(){
			alert('Animation Completed');
		});
	});
}

function progressCounter(){
	counter++;
	$('#prgBar').progressbar("value",counter);
	$('#counterText').text(counter);
	if(counter<100){
		setTimeout(progressCounter,10);
	}
	else{
		$('#counterText').text("Completed");
	}
}
var r=0, g=0, b=0;
function changeSliderValue(event,ui){
	if(event.target.id=="sliderRed"){
		r = ui.value;
		$('#spanRed').text(r);
	}
	if(event.target.id=="sliderBlue"){
		b = ui.value;
		$('#spanBlue').text(b);
	}
	if(event.target.id=="sliderGreen"){
		g = ui.value;
		$('#spanGreen').text(g);
	}
	$('#colorDiv').css({"background-color":"rgb("+r+","+g+","+b+")"})
}


var createDatePicker=function(){
	var $input = $(this);
	var minimumDate = new Date();
	minimumDate.setMonth(minimumDate.getMonth()-1);
	var options = {
		dateFormat:'d/m/yy',
		changeMonth:true,
		changeYear:true,
		numberOfMonths:1,
		showWeek:true,
		showButtonPanel:true,
		showTodayButton:true,
		minDate:minimumDate,
		maxDate:new Date(2016,11,30)
	}
	$input.datepicker(options);
	$input.datepicker("setDate",new Date(2016,1,1));
}

var createAutoComplete = function(){
	var $input = $(this);
	var options = {
		source:[{value:1,label:'BPO'},{value:2,label:'Finance'},{value:3,label:'HR'}, {value:4,label:'IT'},{value:5,label:'Training'}],
		minLength:1,
		change:function(event,ui){
			if(!ui.item)
				$input.val("");
		},
		select:selectAutoComplete,
		delay:500
	}
	$input.autocomplete(options);
}

var selectAutoComplete = function(event,ui){
	var $input = $(this);
	$input.val(ui.item.label);
	$('#departmentId').text(ui.item.value);
	$('#departmentName').text(ui.item.label);
	return false;
}