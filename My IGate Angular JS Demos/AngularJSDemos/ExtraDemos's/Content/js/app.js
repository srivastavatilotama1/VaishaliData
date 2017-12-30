/**
 * Created by colinlacy on 1/26/15.
 */
angular.module('factorLink', [
    'ngRoute',
    'ui.bootstrap',
    'infinite-scroll',
    'ngTable'
])
    .config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider, $window) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/search.html',
                controller: 'searchCtrl'
            })
            .when('/connections/:id', {
                templateUrl: 'views/connections.html',
                controller: 'connectCtrl'
            })
            .when('/group', {
                templateUrl: 'views/grouping.html',
                controller: 'groupingCtrl'
            })
            .when('/error/:code', {
                templateUrl: 'views/error.html',
                controller: 'errorCtrl'
            })
            .otherwise({
                redirectTo: '/error/404'
            });
    }])
    .provider('errorMsg', function () {
        var values = {
            400: {
                tag: 'Bad Request',
                msg: 'The request you\'ve submitted is invalid and could not be understood by our server.'
            },
            401: {
                tag: 'Unauthorized',
                msg: 'You have reached a page that you are not authorized to view.  Please contact your administrator if you feel you should not have received this message.'
            },
            403: {
                tag: 'Forbidden',
                msg: 'You have reached a page that is not publicly accessible.  Please try a different request.'
            },
            404: {
                tag: 'Not Found',
                msg: 'Our server couldn\'t find any data at the URL you\'ve accessed.  Maybe you\'ve arrived here by mistake?'
            },
            500: {
                tag: 'Internal Server Error',
                msg: 'Our server has encountered an internal error.  This has been logged and our development team has been notified.'
            }
        };
        return {
            $get: function () {
                return values;
            }
        };
    })
    .provider('sortFields', function() {
        return {
            $get: function() {
                return {
                    hellerSort: [
                        {
                            sortField: 'DebtorName',
                            sortDisplay: 'Name',
                            sortAscend: true
                        },
                        {
                            sortField: 'DebtorCountry',
                            sortDisplay: 'Country',
                            sortAscend: true
                        }
                    ],
                    clientSort: [
                        {
                            sortField: 'DebotrBalance',
                            sortDisplay: 'Balance',
                            sortAscend: true
                        },
                        {
                            sortField: 'DebtorName',
                            sortDisplay: 'Name',
                            sortAscend: true
                        },
                        {
                            sortField: 'DebtorCountry',
                            sortDisplay: 'Country',
                            sortAscend: true
                        }
                    ],
                    hellerOptions: [
                        {
                            sortField: 'DebtorIdNumber',
                            sortDisplay: 'Debtor Heller',
                            sortAscend: true
                        },
                        {
                            sortField: 'DebtorName',
                            sortDisplay: 'Name',
                            sortAscend: true
                        },
                        {
                            sortField: 'DebtorAddress',
                            sortDisplay: 'Address',
                            sortAscend: true
                        },
                        {
                            sortField: 'DebtorCity',
                            sortDisplay: 'City',
                            sortAscend: true
                        },
                        {
                            sortField: 'DebtorZip',
                            sortDisplay: 'Zip',
                            sortAscend: true
                        },
                        {
                            sortField: 'DebtorCountry',
                            sortDisplay: 'Country',
                            sortAscend: true
                        },
                        {
                            sortField: 'DebtorLimit',
                            sortDisplay: 'Limit',
                            sortAscend: true
                        }
                    ],
                    ordinals: [
                        "Primary",
                        "Secondary",
                        "Tertiary",
                        "Quaternary"
                    ]
                };
            }
        };
    })
    //.directive('loading',   ['$http' ,function ($http)
    //{
    //    return {
    //        restrict: 'A',
    //        templateUrl: 'views/loading.html',
    //        link: function (scope, elm, attrs)
    //        {
    //            scope.isLoading = function () {
    //                return $http.pendingRequests.length > 0;
    //            };
    //
    //            scope.$watch(scope.isLoading, function (v)
    //            {
    //                if(v){
    //                    elm.show();
    //                }else{
    //                    elm.hide();
    //                }
    //            });
    //
    //            scope.loading = "Loading...";
    //
    //        }
    //    };
    //
    //}])
    .directive('clearModel', function() {
        return {
            scope: false,
            require: 'ngModel',
            restrict: 'A',
            link: function (scope, elm, attrs, ngModel)
            {
                scope.$watch(
                    function(){
                        return ngModel.$modelValue;
                    }, function(newValue, oldValue){
                    if(!newValue){
                        scope.search[attrs.clearModel] = null;
                    }
                });
            }
        };
    })
    .filter('capitalize', function() {
        return function(input, all) {
            return (!!input) ? input.replace(/([^\W_]+[^\s-]*) */g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();}) : '';
        };
    })
    .filter('flCurrency',
    [ '$filter', '$locale', function(filter, locale) {
        var currencyFilter = filter('currency');
        var formats = locale.NUMBER_FORMATS;
        formats.DECIMAL_SEP = ",";
        formats.GROUP_SEP = ".";
        formats.CURRENCY_SYM = " ";
        return function(amount, currencySymbol) {
            var value = currencyFilter(amount, currencySymbol);
            var sep = value.indexOf(formats.DECIMAL_SEP);
            console.log(amount, value);
            if(amount >= 0) {
                return value.substring(0, sep);
            }
            return value.substring(0, sep) + ')';
        };
    } ]);

