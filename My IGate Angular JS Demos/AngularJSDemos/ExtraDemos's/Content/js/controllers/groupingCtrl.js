/**
 * Created by colinlacy on 2/25/15.
 */
angular.module('factorLink')
.controller('groupingCtrl', function($scope, $rootScope, apiSrvc, searchUrl, apiFact) {

        // ***************************************
        // Structuring the table layout and design
        // ***************************************

        $scope.$parent.groupArray = $scope.$parent.groupArray || [];
        $scope.$parent.childArray = $scope.$parent.childArray || [];
        $scope.$parent.futureParent = $scope.$parent.futureParent || null;
        $scope.search = {};

        // some jQuery to set the height of the add buttons
        var parentTable = $('#parent-table'),
            parentButton = $('#parent-button'),
            ptHeight = parentTable.height(),
            ptTop = parentTable.position(),
            buttonHeight = parentButton.height() +
                parseInt(parentButton.css("padding-top").replace("px", "")) +
                parseInt(parentButton.css("padding-bottom").replace("px", "")) +
                parseInt(parentButton.css("border-top").replace("px", "")) +
                parseInt(parentButton.css("border-bottom").replace("px", "")),
            childButton = $('#child-button'),
            childTable = $('#child-by-id'),
            ctHeight = childTable.height(),
            ctTop = childTable.position();

        parentButton.css({'margin-top': function() {
            return (ptTop.top + (ptHeight - buttonHeight)/2);
        }});

        childButton.css({'margin-top': function() {
            return ((ctTop.top - parseInt(parentButton.css("margin-top").replace("px", "")) - buttonHeight) + (ctHeight - buttonHeight)/2);
        }});

        // functions that will return the owner type
        $scope.getShortNodeType = function(num) {
            switch (num) {
                case "UltimateParent": return "UP";
                case "CommercialOwner": return "CO";
                case "LegalOwner": return "LO";
                case "Standalone": return "SA";
                case "Branch": return "BR";
            }
        };

        $scope.getLongNodeType = function(num) {
            switch (num) {
                case "UltimateParent": return "ultimate-parent";
                case "CommercialOwner": return "commercial-owner";
                case "LegalOwner": return "legal-owner";
                case "Standalone": return "standalone";
                case "Branch": return "branch";
            }
        };

        // *****************
        // Selecting Debtors
        // *****************

        $scope.selectDebtor = function(event, index) {
            if(($(event.target).hasClass('click-select'))) {
                $scope.$parent.groupArray[index].selected = !$scope.$parent.groupArray[index].selected;
            }
        };
        $scope.selectAll = function() {
            $scope.allSelected = $scope.allSelected ? !$scope.allSelected : true;
            console.log($scope.allSelected);
            var bool = $scope.allSelected;
            for (var i = 0; i < $scope.$parent.groupArray.length; i++) {
                $scope.$parent.groupArray[i].selected = bool;
            }
        };
        $scope.debtorsSelected = function() {
            for (var i = 0; i < $scope.$parent.groupArray.length; i++) {
                if($scope.$parent.groupArray[i].selected) {
                    return true;
                }
            }
            return false;

        };

        // ********************************
        // Adding and Removing from buckets
        // ********************************

        $scope.addDebtorsToChildren = function() {
            // add to the childArray
            for (var i = 0; i < $scope.$parent.groupArray.length; i++) {
                if($scope.$parent.groupArray[i].selected) {
                    console.log($scope.$parent.groupArray[i].DebtorNumber);
                    $scope.$parent.childArray.push($scope.$parent.groupArray[i]);
                    $scope.$parent.groupArray.splice(i, 1);
                    i--;
                }
            }
        };
        $scope.addDebtorToParent = function() {
            var selected = [],
                index = null;

            for (var i = 0; i < $scope.$parent.groupArray.length; i++) {
                if($scope.$parent.groupArray[i].selected) {
                    selected.push($scope.$parent.groupArray[i]);
                    index = i;
                }
            }
            if(selected.length > 1) {

            } else {
                $scope.$parent.futureParent = selected[0];
                $scope.$parent.groupArray.splice(index, 1);
            }
        };

        $scope.removeDebtorFromArray = function(debtor, list) {
            if(list === 'childArray') {
                debtor.selected = false;
                debtor.removedDebtor = true;
                $scope.$parent.groupArray.unshift(debtor);
            }
            for (var i = 0; i < $scope[list].length; i++) {
                if ($scope.$parent[list][i].DebtorNumber === debtor.DebtorNumber) {
                    $scope.$parent[list].splice(i, 1);
                    break;
                }
            }
        };
        $scope.removeDebtorFromParent = function() {
            //if ($scope.$parent.childArray.length > 0) {
            //
            //}
            $scope.$parent.futureParent.selected = false;
            $scope.$parent.futureParent.removedDebtor = true;
            $scope.$parent.groupArray.unshift($scope.$parent.futureParent);
            $scope.$parent.futureParent = null;
        };
        $scope.clearAll = function(list) {
            if (list === 'childArray') {
                for (var i = 0; i < $scope.$parent.childArray.length; i++) {
                    $scope.$parent.childArray[i].removedDebtor = true;
                    $scope.$parent.childArray[i].selected = false;
                }
                $scope.$parent.groupArray = $scope.$parent.childArray.concat($scope.$parent.groupArray);
            }
            $scope.$parent[list] = [];
        };

        // **************
        // Inline debtors
        // **************

        $scope.activateInline = function(type) {
            $scope[type + 'ByNumber'] = true;
        };
        $scope.cancelInline = function(type) {
            $scope[type + 'ByNumber'] = false;
        };
        $scope.findInlineParent = function() {
            $scope.findingParent = true;
            var args = new apiFact.searchObj();
            args.DebtorNumber = $scope.search.inlineParent;
            apiSrvc.getData(searchUrl, args).then(function(response) { // dev API
                if (response.data.length > 0) {
                    $scope.$parent.futureParent = response.data[0];
                    $scope.search.inlineParent = null;
                    $scope.parentByNumber = false;
                } else {
                    $('#fixed-page-alerts').addAlert({
                        type: 'danger',
                        autoDestroy: true,
                        destroyTimer: 6000,
                        message: '<strong>Uh oh!</strong> Your search didn\'t return any results!'
                    });                }
                $scope.search.inlineParent = null;
            }, function(response) {
                apiSrvc.errorCheck(response, false, "executing your search!");
            });
            $scope.findingParent = false;
        };
        $scope.findInlineChild = function() {
            $scope.findingChild = true;
            console.log($scope.findingChild);
            // runs the search
            var args = new apiFact.searchObj();
            args.DebtorNumber = $scope.search.inlineChild;
            apiSrvc.getData(searchUrl, args).then(function(response) { // dev API
                if (response.data.length > 0) {
                    $scope.$parent.childArray.unshift(response.data[0]);
                    $scope.search.inlineChild = null;
                    $scope.childByNumber = false;
                } else {
                $('#fixed-page-alerts').addAlert({
                    type: 'danger',
                    autoDestroy: true,
                    destroyTimer: 6000,
                    message: '<strong>Uh oh!</strong> Your search didn\'t return any results!'
                });                }
                $scope.search.inlineChild = null;
            }, function(response) {
                apiSrvc.errorCheck(response, false, "executing your search!");
            });
            $scope.findingChild = false;
        };
    });