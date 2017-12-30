/**
 * Created by colinlacy on 2/23/15.
 */
angular.module('factorLink')
.controller('connectCtrl', function($scope, $rootScope, $routeParams, $modal, $location, apiSrvc, apiFact, cxUrl, currencyUrl) {
        console.log("CX");
        // create the history array
        $scope.$parent.cxHistory = $scope.$parent.cxHistory || [];

        $scope.activeDebtor = $routeParams.id;

        // currency modal
        apiSrvc.getData(currencyUrl).then(function (response) {
            $scope.currencyData = response.data;
        });

        $scope.currency = $scope.$parent.currency || "EUR"; // sets an initial value
        $scope.openHelper = function(helperString) {
            var modalInstance = $modal.open({
                templateUrl: 'views/helperModal.html',
                controller: 'modalHelperCtrl',
                backdrop: 'static',
                size: 'md',
                resolve: {
                    dataArray: function() {
                        return $scope[helperString + 'Data'];
                    },
                    message: function() {
                        return "Select a Currency";
                    }
                }
            });
            modalInstance.result.then(function(modalData) {
                $scope.currency = modalData.code;
                $scope.$parent.currency = modalData.code;

                var args = new apiFact.connectObj(),
                    getUrl = cxUrl + $scope.activeDebtor;

                args.CurrencyCode = $scope.currency;

                $rootScope.loading = true;
                apiSrvc.getData(getUrl, args).then(function(response) {
                    buildTree(response.data);
                    $rootScope.loading = false;
                }, function(response) {
                    $rootScope.loading = false;
                    apiSrvc.errorCheck(response, false, "executing your search!");
                });
            });
        };

        $scope.getNodeTypeFromLabel = function (lbl) {
            switch (lbl) {
                case "UltimateParent": return 1;
                case "CommercialOwner": return 2;
                case "LegalOwner": return 3;
                case "Standalone": return 4;
                case "Branch": return 5;
            }
            return 0;
        }

        $scope.getShortNodeType = function (num) {
            if (isNaN(num * 1)) {
                num = $scope.getNodeTypeFromLabel(num);
            }
            switch (num) {
                case 1: return "UP";
                case 2: return "CO";
                case 3: return "LO";
                case 4: return "SA";
                case 5: return "BR";
            }
        };

        $scope.getLongNodeType = function (num) {
            if (isNaN(num * 1)) {
                num = $scope.getNodeTypeFromLabel(num);
            }
            switch (num) {
                case 1: return "ultimate-parent";
                case 2: return "commercial-owner";
                case 3: return "legal-owner";
                case 4: return "standalone";
                case 5: return "branch";
            }
        };

        // a function that will build out the connection tree
        var buildTree = function(data) {
            // start some local data building
            var debtorTree = data, // store the API data
                debtorArray = [],           // the array that will be looped through to display the debtors in the Cx table
                treeParents = [];           // the parents array, which will be used to set vertical travel through the tree

            if (debtorTree.Ancestors) {
                // loop through the parents
                for(var i = 0; i < debtorTree.Ancestors.length; i++) {
                    // add to the treeParents array
                    treeParents.push(debtorTree.Ancestors[i]);
                    // set a property specifying that this is a parent
                    debtorTree.Ancestors[i].isParent = true;
                    // add to the debtor array
                    debtorArray.push(debtorTree.Ancestors[i]);
                }
            }
            // set some info regarding the current target so that it will display as the current target
            debtorTree.CurrentDebtor.isTarget = true;
            // add the current debtor to the $parent scope so it can be accessed from the top nav
            $scope.$parent.currentConnection = debtorTree.CurrentDebtor; // !!! TEMPORARY, NEEDS TO BE REMOVED WHEN API IS HOOKED UP
            //$scope.$parent.currentConnection = debtorTree.CurrentDebtor.DebtorNumber;
            // add to the debtor array
            debtorArray.push(debtorTree.CurrentDebtor);

            if (debtorTree.Children) {
                // add each child to the debtor array
                for(var j = 0; j < debtorTree.Children.length; j++) {
                    debtorTree.Children[j].isChild = true;
                    debtorTree.Children[j].isParent = false;
                    debtorArray.push(debtorTree.Children[j]);
                }
            }

            // store the TotalRecords number for this Cx search
            $scope.totalRecords = data.TotalRecords;

            // store the current searchPage and the max searchPages
            $scope.searchPage = 0;
            $scope.maxPages = ($scope.totalRecords / 50);

            // add all of this info to the local scope
            $scope.$parent.treeParents = treeParents;
            $scope.$parent.debtorArray = debtorArray;
        };

        // get connections from the connection screen
        $scope.getConnections = function(debtorId, isParent, loadAncestors) {
            // determine if we're dealing with an ancestor or a child
            if(isParent && !loadAncestors) {
            } else {
                // add the current node to the ancestors array, so that it becomes a new ancestor
                $scope.$parent.treeParents.push($scope.$parent.currentConnection);
            }
            // create a params object
            var params = new apiFact.connectObj(),
                url = cxUrl + debtorId;
            // edit the params object, and decide whether or not to call the ancestors
            params.LoadAncestorData = loadAncestors;
            apiSrvc.getData(url, args).then(function(response) {
                buildTree(response.data);
                $rootScope.loading = false;
            }, function(response) {
                apiSrvc.errorCheck(response, false, "executing your search!");
            });
        };


        // determine if there has already been a connection search
        if ($scope.$parent.currentConnection) {
            // check if the stored currentConnection is the same as the ID passed into the URL
            if ($scope.$parent.currentConnection.DebtorNumber !== $routeParams.id) {
                $scope.$parent.cxHistory.unshift($scope.$parent.currentConnection.DebtorNumber);
                if ($scope.$parent.cxHistory.length > 5) {
                    $scope.$parent.cxHistory.pop();
                }
                var args = new apiFact.connectObj(),
                    getUrl = cxUrl + $scope.activeDebtor;
                args.CurrencyCode = $scope.currency;
                $rootScope.loading = true;
                apiSrvc.getData(getUrl, args).then(function(response) {
                    buildTree(response.data);
                    $rootScope.loading = false;
                }, function(response) {
                    $rootScope.loading = false;
                    apiSrvc.errorCheck(response, false, "executing your search!");
                });
            } else {
                // do nothing because the route matches the current debtor
            }
        } else {
            // getting mockdata for connections display
            var params = new apiFact.connectObj(),
                url = cxUrl + $scope.activeDebtor;
            $rootScope.loading = true;
            apiSrvc.getData(url, params).then(function(response) {
                buildTree(response.data);
                $rootScope.loading = false;
            }, function(response) {
                $rootScope.loading = false;
                apiSrvc.errorCheck(response, false, "executing your search!");
            });
        }


        // Infinite Scrolling
        $scope.getMore = function() {
            if ($scope.searchPage < $scope.maxPages) {
                $scope.searchPage++;
                $scope.busy = true;
                var args = {
                    LoadDebtorData: false,
                    LoadAncestorData: false,
                    LoadChildData: true,
                    PageIndex: $scope.searchPage,
                    PageSize: 50,
                    CurrencyCode: $scope.currency
                },
                    getUrl = cxUrl + $scope.activeDebtor;
                apiSrvc.getData(getUrl, args).then(function(data) {
                    for (var i = 0; i < data.data.Children.length; i++) {
                        data.data.Children[i].isChild = true;
                    }
                    $scope.$parent.debtorArray = $scope.$parent.debtorArray.concat(data.data.Children);
                    $scope.busy = false;
                });
            }
        };




        // *****************************
        // Add to Grouping Functionality
        // *****************************

        // selecting rows in the search results
        $scope.selectToggle = function(index, event) {
            // without this conditional, clicking the input will toggle the scope value change twice,
            // meaning nothing will happen
            if (event.target.nodeName !== 'INPUT') {
                $scope.$parent.searchResults[index].selected = $scope.$parent.searchResults[index].selected ? !$scope.$parent.searchResults[index].selected : true;
            }
        };

        // count the selected items
        $scope.selectCount = function() {
            if ($scope.$parent.debtorArray) {
                var count = 0;
                for (var i = 0; i < $scope.$parent.debtorArray.length; i++) {
                    if ($scope.$parent.debtorArray[i].selected) {
                        count++;
                    }
                }
                return count;
            }
        };

        $scope.addToGrouping = function(redirect) {
            if(!$scope.$parent.groupArray) {
                $scope.$parent.groupArray = [];
            }

            for (var i = 0; i < $scope.debtorArray.length; i++) {
                if ($scope.$parent.debtorArray[i].selected) {
                    $scope.$parent.groupArray.push($scope.debtorArray[i]);
                    $scope.$parent.debtorArray[i].selected = false;
                }
            }

            if(redirect) {
                $location.path('/group');
            }
        };


    });