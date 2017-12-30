/**
 * Created by colinlacy on 1/26/15.
 */
angular.module('factorLink')
    .controller('initCtrl', function($scope, $rootScope, $log, $location, $routeParams, apiSrvc) {
        // tells the search field to be open on first load.
        // revised to false once the search has been executed.
        $rootScope.firstLoad = true;
        $rootScope.loading = false;
        $scope.isLoading = function() {
            return $rootScope.loading;
        };

        // checks if a debtor is in the grouping array
        // used on the search screen and the connections screen
        $scope.inGroupingCheck = function(id) {
            if($scope.groupArray) {
                for (var i = 0; i < $scope.groupArray.length; i++) {
                    if ($scope.groupArray[i].DebtorNumber === id) {
                        return true;
                    }
                }
            }
            return false;
        };
    });
