/**
 * Created by colinlacy on 1/28/15.
 */
angular.module('factorLink')
.controller('searchCtrl', function($scope, $rootScope, $location, $modal, apiSrvc, searchUrl, cxUrl, apiFact, sortFields) {

        // ******************
        // Core Functionality
        // ******************

        // set initial scope values to have search results displayed on load
        $scope.debtorSearchType = 'heller';
        $scope.$parent.searchType = $scope.debtorSearchType;

        // operate the search box toggle return
        $scope.getStatus = function(string) {
            return $scope.status[string].isopen;
        };

        // search box toggle function
        $scope.toggleDropdown = function(string) {
            $scope.status[string].isopen = !$scope.status[string].isopen;
            var keys = Object.keys($scope.status);
            for (var i = 0; i < keys.length; i++) {
                if (keys[i] !== string) {
                    $scope.status[keys[i]].isopen = false;
                }
            }
            $rootScope.firstLoad = false;
        };

        // ************************
        // The Advanced Search Form
        // ************************

        // instantiate the search object so that no errors are thrown on startup
        $scope.search = {};

        // set the default search type
        $scope.debtorSearchType = 'heller';

        // make sure the search box opens on the first load
        $scope.status = {
            advanced: {
                isopen: $rootScope.firstLoad
            },
            basic: {
                isopen: false
            }
        };

        // format the country code
        $scope.$watch('search.DebtorCountry', function() {
            if($scope.search.DebtorCountry) {
                $scope.search.DebtorCountry = $scope.search.DebtorCountry.toUpperCase();
            }
        });

        // determines whether or not form requirements have been met
        $scope.requirements = function() {
            var retVal = false;
            var keys = Object.keys($scope.search);
            for(var i = 0; i < keys.length; i++) {
                if (keys[i] !== 'AdministrationNumber' && keys[i] !== 'TypeOfIdNumber' && $scope.search[keys[i]] !== null && $scope.search[keys[i]] !== '') {
                    retVal = true;
                    break;
                }
            }
            return retVal;
        };

        // runs the search
        $scope.searchDebtors = function() {
            $scope.$parent.searchResults = null;
            $scope.searchPage = 1;
            $scope.toggleDropdown('advanced');
            $scope.$parent.searchType = $scope.debtorSearchType;
            // set initial sort array
            //$scope.sortArray = $scope.$parent.searchType ? sortFields[$scope.$parent.searchType + 'Sort'] : [];

            var args = new apiFact.searchObj(),
                keys = Object.keys($scope.search);
            for (var i = 0; i < keys.length; i++) {
                args[keys[i]] = $scope.search[keys[i]];
            }

            $rootScope.loading = true;
            apiSrvc.getData(searchUrl, args).then(function(response) { // dev API
                console.log(response.data);
                $scope.$parent.searchResults = response.data;
                $scope.sortInit($scope.$parent.searchType);
                $rootScope.loading = false;
            }, function(response) {
                apiSrvc.errorCheck(response, false, "executing your search!");
                $rootScope.loading = false;
            });
        };

        //

        //set the typeahead values for countries
        apiSrvc.getData('../api/systemsettings/availablecountries').then(function (response) {
            $scope.DebtorCountryData = response.data;
        });
        apiSrvc.getData('../api/systemsettings/availableidtypes').then(function(response) {
            $scope.TypeOfIdNumberData = response.data;
        });
        apiSrvc.getData('../api/systemsettings/availableDebtorOwnerTypes').then(function (response) {
            $scope.ownerTypes = response.data;
        });

        // opening the helper modal based on a model name
        $scope.openHelper = function(helperString) {
            var modalInstance = $modal.open({
                templateUrl: 'views/helperModal.html',
                controller: 'modalHelperCtrl',
                backdrop: 'static',
                size: 'md',
                resolve: {
                    dataArray: function() {
                        console.log((helperString + 'Data'));
                        return $scope[helperString + 'Data'];
                    },
                    message: function() {
                        if (helperString === "TypeOfIdNumber") {
                            return "Select a Credit Agency";
                        } else {
                            return "Select a Country";
                        }
                    }
                }
            });
            modalInstance.result.then(function(modalData) {
                console.log(modalData);
                $scope.search[helperString] = modalData.code;
            });
        };

        // Getting the long values for code-based inputs
        $scope.getLongValue = function(scopeVal) {
            var match;
            if($scope.search[scopeVal] && $scope.search[scopeVal].length > 1) {
                for (var i = 0; i < $scope[scopeVal + 'Data'].length; i++) {
                    if ($scope[scopeVal + 'Data'][i].code === $scope.search[scopeVal]) {
                        match = $scope[scopeVal + 'Data'][i].name;
                        break;
                    }
                }
                return match || "No matches found";
            } else {
                return null;
            }
        };

        // clear all fields
        $scope.clearFields = function() {
            var keys = Object.keys($scope.search);
            console.log(keys);
            for(var i = 0; i < keys.length; i++) {
                $scope.search[keys[i]] = null;
            }
        };

        // the Tooltip functionality
        $scope.clientTooltip = "You need to enter an Administration Number first.";
        $scope.debtorTooltip = "You need to enter an Debtor ID Type first.";
        $scope.alertTooltip = function(chgModel, targetModel, msg) {
            $scope[targetModel + 'Tooltip'] = $scope.search[chgModel].length > 0 ? '' : msg;
        };

        // analyze the search type - runs the ng-if's on the search results table columns
        $scope.analyzeSearchType = function(string) {
            return $scope.$parent.searchType === string;
        };

        // *********************
        // The Basic Search Form
        // *********************

        $scope.clearArray = function() {
            $scope.searchArray = null;
        };

        //$scope.searchById = function() {
        //    var searchArray = $scope.searchArray.split('\n');
        //    console.log(searchArray);
        //    $scope.toggleDropdown('basic');
        //    // *****************************************
        //    // mock data API call - needs to be replaced
        //    // *****************************************
        //    apiSrvc.getData('Mockdata/' + $scope.debtorSearchType + '1.json').then(function(response) {
        //        $scope.$parent.searchResults = response.data;
        //    }, function(response) {
        //        apiSrvc.errorCheck(response, false, "executing your search!");
        //    });
        //};

        // ***********************
        // The Search Results View
        // ***********************

        // a function that returns the search results to the view - set as a function in order to ensure it updates constantly
        $scope.getSearchResults = function() {
            return $scope.$parent.searchResults;
        };

        $scope.getMore = function() {
            var maxResults = 3;
            if ($scope.searchPage < maxResults) {
                $scope.searchPage++;
                $scope.busy = true;
                apiSrvc.getData('Mockdata/' + $scope.$parent.searchType + $scope.searchPage + '.json').then(function(data) {
                    for (var i = 0; i < data.length; i++) {
                        $scope.$parent.searchResults.push(data[i]);
                    }
                    $scope.busy = false;
                });
            }
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

        // selecting all rows in the search results
        $scope.selectAll = function() {
            $scope.allSelected = $scope.allSelected ? !$scope.allSelected : true;
            var bool = $scope.allSelected;
            for (var i = 0; i < $scope.$parent.searchResults.length; i++) {
                $scope.$parent.searchResults[i].selected = bool;
            }
        };

        // count the selected items
        $scope.selectCount = function() {
            var count = 0;
            for (var i = 0; i < $scope.$parent.searchResults.length; i++) {
                if ($scope.$parent.searchResults[i].selected) {
                    count++;
                }
            }
            return count;
        };

        $scope.addToGrouping = function(redirect) {
            if(!$scope.$parent.groupArray) {
                $scope.$parent.groupArray = [];
            }

            for (var i = 0; i < $scope.$parent.searchResults.length; i++) {
                if ($scope.$parent.searchResults[i].selected) {
                    $scope.$parent.groupArray.push($scope.$parent.searchResults[i]);
                    $scope.$parent.searchResults[i].selected = false;
                }
            }

            if(redirect) {
                $location.path('/group');
            }
        };


        // *********************
        // Search Result Sorting
        // *********************

        // set ordinal values that will be displayed below sort indicators
        $scope.ordinals = angular.copy(sortFields.ordinals);

        // set the sort fields available to the sort dropdowns
        $scope.sortOptions = angular.copy(sortFields[$scope.$parent.searchType + "Options"]);

        // set default options for sorting once a search is executed
        $scope.sortInit = function(searchType) {
            if(searchType) {
                $scope.sortArray = angular.copy(searchType ? sortFields[searchType + 'Sort'] : []);
                // loop through each sort applied
                for (var i = 0; i < $scope.sortArray.length; i++) {
                    // then loop through the sort options to see if it matches any of them.
                    // if it does (and it should) then we'll set that option as the initial selected value in the sort form dropdown.
                    // for the record, I'm generally not a fan of nested loops, so i'm open to refactor suggestions.
                    for(var j = 0; j < $scope.sortOptions.length; j++) {
                        if($scope.sortArray[i].sortField === $scope.sortOptions[j].sortField) {
                            $scope.sortArray[i].selected = $scope.sortOptions[j];
                            break;
                        }
                    }
                }
            }
        };

        // set the order display array
        $scope.sortOrderDisplay = ['Primary', 'Secondary', 'Tertiary'];

        // add a sorting filter to the UI (not applied until the user has confirmed a sort category)
        $scope.addSort = function() {
            var sortList = $('#sort-list');
            sortList.animate({width: "+=150"}, 300, function() {
                $scope.sortArray.push({
                    sortField: null,
                    sortDescription: null,
                    sortAscend: true,
                    changed: false
                });
                $scope.$apply();
            });
        };

        // determines which of the sort forms should be open
        $scope.getOpenSort = function() {
            return $scope.openSort || null;
        };

        // a function to open the sort form specified, based on $index
        $scope.openSortForm = function(index) {
            $scope.openSort = $scope.openSort === index + 1 ? null : index + 1;
        };

        // closes all sort forms, although can only be triggered on an individual sort form
        $scope.closeSortForm = function() {
            $scope.openSort = null;
        };

        // applies the sort field selected to the sort array
        $scope.applySort = function(index) {
            // grab the sort direction
            //var asc = $scope.sortArray[index].sortAscend;
            $scope.sortArray[index] = $scope.sortArray[index].selected;
            //$scope.sortArray[index].sortAscend = asc;
            $scope.closeSortForm();
            $scope.sortArray[index].changed = false;
            for (var i = 0; i < $scope.sortArray.length; i++) {
                // then loop through the sort options to see if it matches any of them.
                // if it does (and it should) then we'll set that option as the initial selected value in the sort form dropdown.
                // for the record, I'm generally not a fan of nested loops, so i'm open to refactor suggestions.
                for(var j = 0; j < $scope.sortOptions.length; j++) {
                    if($scope.sortArray[i].sortField === $scope.sortOptions[j].sortField) {
                        $scope.sortArray[i].selected = $scope.sortOptions[j];
                        break;
                    }
                }
            }
            // *****************
            // REQUIRES API CALL
            // *****************
        };

        // remove sort form by removing the selected index from the sort array
        $scope.removeSort = function(index) {
            var sortList = $('#sort-list');
            $scope.sortArray.splice(index, 1);
            sortList.animate({width: "-=150"}, 300);
            $scope.openSort = null;     // prevents the next sort form from opening automatically
            // *****************
            // REQUIRES API CALL
            // *****************
        };

        // reset default sort order
        $scope.resetDefaultSorts = function() {
            $scope.sortInit($scope.$parent.searchType);
            $('#sort-list').width(150 * $scope.sortArray.length);
            // *****************
            // REQUIRES API CALL
            // *****************
        };

        // get connections from the search screen
        $scope.getConnections = function(debtorId) {
            $location.path('#/connections/' + debtorId);
        };



    });