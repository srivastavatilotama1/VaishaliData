angular.module('factorLink')
    .service('apiSrvc', function($http, $q, $location, errorMsg) {
        return {

            // creating the GET call
            // @pbergeron - added parameter that accepts arguments to be passed
            // to web api. see searchCtrl.js for usage.
            getData: function (url, args) {
                // this creates an object that will be expecting a set of asynchronous data
                var returnData = $q.defer();

                // here, we make the call to the database
                $http({
                    url: url,
                    method: 'GET',
                    // @pbergeron - Angular will serialize this object to query string on 'GET' request
                    params: args
                })
                    // the success method fires if the backend successfully returned data
                    .then(function (data) {
                        // we'll set the data that's returned to the object expecting asynchronous data.
                        returnData.resolve(data);
                    },
                    // if the backend returned an error, we pass the error to the client instead.
                    function (error) {
                        returnData.reject(error);
                    });
                // now we return the promise of the API call - whether successful or not
                return returnData.promise;
            },

            // creating the Post call
            // requires a data object to be passed.
            postData: function (url, data) {
                // this creates an object that will be expecting a set of asynchronous data
                var returnData = $q.defer();

                // here, we make the call to the server, including a data object
                $http({
                    url: url,
                    method: 'Post',
                    data: data
                })
                    // the success method fires if the backend successfully returned data
                    .then(function (data) {
                        // we'll set the data that's returned to the object expecting asynchronous data.
                        returnData.resolve(data);
                    },
                    // if the backend returned an error, we pass the error to the client instead.
                    function (error) {
                        returnData.reject(error);
                    });
                // now we return the promise of the API call - whether successful or not
                return returnData;
            },

            // error alerting and routing
            errorCheck: function(error, redirect, message) {
                var msg = message || "with your last request!";
                // a boolean passed as the second argument will determine whether or not ro redirect to the error page
                // note that the message passed will only be used if the redirect argument is false
                switch (redirect) {
                    case true: // redirect to the error page
                        console.error(error.status + " " + error.statusText + ": " + error.config.url);
                        $location.path('/error/' + error.status);
                        break;
                    case false: // set an alert at the top of the screen, no redirect
                        console.error(error.status + " " + error.statusText + ": " + error.config.url);
                        $('#fixed-page-alerts').addAlert({
                            type: 'danger',
                            autoDestroy: true,
                            destroyTimer: 6000,
                            message: '<strong>Uh oh!</strong> There was a problem ' + msg + ' <strong>' + error.status + ' ' + errorMsg[error.status].tag
                        });
                        break;
                }
            }
        };
    });