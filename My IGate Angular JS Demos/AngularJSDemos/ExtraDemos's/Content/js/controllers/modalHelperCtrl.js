/**
 * Created by colinlacy on 1/30/15.
 */
angular.module('factorLink')
.controller('modalHelperCtrl', function($scope, $modalInstance, dataArray, message) {
        $scope.dataArray = dataArray;
        $scope.message = message;

        // choosing a key/value pair
        $scope.selectRow = function(row) {
            $scope.chosenRow = row;
        };

        // is the row in question the chosenRow?
        $scope.repeatCompare = function(value, scopeValue) {
            return value === $scope[scopeValue];
        };

        // cancel operation
        $scope.cancel = function() {
            $modalInstance.dismiss('cancel');
            $('#fixed-page-alerts').clearAlerts();
        };

        // select operation
        $scope.selectOption = function() {
            $modalInstance.close($scope.chosenRow);
        };

    });