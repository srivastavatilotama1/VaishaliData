$.fn.addAlert = function(options) {

    var settings = $.extend({
        type: '',
        message: 'Alert Message',
        includeCloseBtn: true,
        autoDestroy: false,
        destroyTimer: 4000
    }, options);

    var formattedMessage = '';

    if ($.isArray(settings.message)) {
        $.each(settings.message, function(value) {
            formattedMessage += '<p>' + value + '</p>';
        });
    } else {
        formattedMessage = '<p>' + settings.message + '</p>';
    }

    var closeBtn = '';
    if (settings.includeCloseBtn) {
        closeBtn = '<button type="button" class="close" data-dismiss="alert"><i class="fa fa-fw fa-times"></i></button>';
    }

    var newAlert = $('<div class="alert alert-custom alert-' + settings.type + '">' + closeBtn + formattedMessage + '</div>').prependTo(this).css('display', 'none').fadeIn(200);

    if (settings.autoDestroy) {
        var clearAlert = setInterval(removeAlert, settings.destroyTimer);
    }
    function removeAlert() {
        newAlert.remove();
        clearInterval(clearAlert);
    }

};

$.fn.clearAlerts = function() {
    this.find('.alert').remove();
};

