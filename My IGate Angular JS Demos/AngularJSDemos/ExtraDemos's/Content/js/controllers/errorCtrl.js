/**
 * Created by colinlacy on 2/4/15.
 */
angular.module('factorLink')
.controller('errorCtrl', function($scope, $rootScope, $routeParams, errorMsg) {
        $scope.errorCode = $routeParams.code;
        $scope.errorInfo = errorMsg[$scope.errorCode];
    });