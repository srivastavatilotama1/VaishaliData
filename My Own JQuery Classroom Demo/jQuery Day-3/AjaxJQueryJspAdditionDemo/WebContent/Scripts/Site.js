var counter = 1;

$(function () {
    initialize();

});

var initialize = function () {
    jqueryUIInitialization();
    wireEvents();

};

var jqueryUIInitialization = function () {

    /*jQueryUi - Button*/
    $('#btnSimpleDialog').button();
    $('#btnModalDialog').button();

    /*Simple Dialog*/
    $('#simpleDialog').dialog({ autoOpen: false });

    /*Modal Dialog*/
    $('#modalDialog').dialog(
    {
        autoOpen: false,
        modal: true,
        resizable: false,
        draggable: false,
        buttons: {
            "OK": function () {
                $('#modalDialog').dialog('close');
                $('#modalTarget').text('OK Pressed');
            },
            "Cancel": function () {
                $('#modalDialog').dialog('close');
                $('#modalTarget').text('Cancel Pressed');
            }
        }
    });

    /*ProgressBar Inialization*/
    $('#prgBar').progressbar({ value: 0 });

    /*Calling Counter function*/
    progressCounter();

    /*Slider Inialization*/
    $('#sliderRed').slider({ min: 0, max: 255, value: 0, slide: changeSliderValue });
    $('#sliderGreen').slider({ min: 0, max: 255, value: 0, slide: changeSliderValue });
    $('#sliderBlue').slider({ min: 0, max: 255, value: 0, slide: changeSliderValue });

    /*Tab Initialization*/
    $("#tabs").tabs();

    /*Accordian Initialization*/
    $("#accordian").accordion({ autoHeight: false, collapsible: true });

    /*Autocomplete*/
    $('input[data-site-autocomplete]').each(createAutocomplete);

    /*DatePicker*/
    $('input[data-site-datepicker="true"]').each(createDatePicker);

    /*Draggables*/
    $('#one').draggable({});
    $('#two').draggable({ handle: "h3" });
    $('#three').draggable({ snap: "#one, #two" });

    $('#one, #two, #three').draggable("option", "stack", ".ui-draggable");

    /*Droppabble*/
    $('#dropTarget').droppable({
        drop: function (event, ui) {
            ui.draggable.remove();
        }
    });
};

var wireEvents = function () {

    $('#btnSimpleDialog').bind('click', function () {
        $('#simpleDialog').dialog('open');
    });

    $('#btnModalDialog').bind('click', function () {
        $('#modalDialog').dialog('open');
    });

    $('#effectsDiv').bind('click', function () {
        var options = {
            "width": "+=100",
            "height": "+=100",
            "background-color": "red"
        };

        $(this).animate(options, 1000, "easeInBounce").effect("explode", { pieces: 8 }, "slow");
    });



};

function progressCounter() {

    counter++;
    $('#prgBar').progressbar("option", "value", counter);
    $('#counterText').text(counter);
    if (counter < 100) {
        setTimeout(progressCounter, 10);

    }
    else {

        $('#counterText').text("Completed");
        $('#prgBar').progressbar("disabled");

    }
}

var r = 0, g = 0, b = 0;
function changeSliderValue(event, ui) {

    if (event.target.id == "sliderRed") {
        r = ui.value;
        $('#spanRed').text(r);
    }

    if (event.target.id == "sliderGreen") {
        g = ui.value;
        $('#spanGreen').text(g);
    }

    if (event.target.id == "sliderBlue") {
        b = ui.value;
        $('#spanBlue').text(b);
    }

    $('#colorDiv').css({ "background-color": "rgb(" + r + "," + g + "," + b + ")" });
}

var createAutocomplete = function () {
    $input = $(this);
    var options = {
        //source: $input.attr("data-site-autocomplete"),
		source:[{value:1,label:'BPO'},{value:2,label:'Finance'},{value:3,label:'HR'},{value:4,label:'IT'},{value:5,label:'Training'}],
        change: function (event, ui) {
            if (!ui.item) {
                $input.val("");
            };
        },
        select: selectAutoComplete,
        minLength: 1,
        delay: 500,
		
    };
    $input.autocomplete(options);
}

var selectAutoComplete = function (event, ui) {
    $input = $(this);
    $input.val(ui.item.label);
    $('#departmentId').text(ui.item.value);
    $('#departmentName').text(ui.item.label);
    return false; //prevent widget to insert value
};

var createDatePicker = function () {
    $input = $(this);
    var options = {
        dateFormat: 'd/m/yy',
        showAnim: "explode",
        numberOfMonths: 1,
        showWeek: true,
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        showTodayButton: true,
        minDate: new Date(2013, 0, 1),
        maxDate: new Date(2016, 11, 30)
    };
    $input.datepicker(options);
    $input.datepicker("setDate", new Date());

};
