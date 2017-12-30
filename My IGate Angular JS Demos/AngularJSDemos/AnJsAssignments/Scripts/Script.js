var employeeNameSpace = angular.module('employeeApp',[]);

employeeNameSpace.controller('EmployeeController',function($scope){
	$scope.employee = {
		'name':'Karthik',
		'department':'Training',
		'companyName':'IGATE'
	};
});

var guestNameSpace = angular.module('guestPhoneBookApp',[]);

guestNameSpace.controller('GuestController',function($scope){
	$scope.guests = [
		{
			"guestId":101,
			"guestName":"Anil",
			"contactNumber":"+91-8645635092"
		},
		{
			"guestId":102,
			"guestName":"Ganesh",
			"contactNumber":"+91-9946945634"
		},
		{
			"guestId":103,
			"guestName":"Karthik",
			"contactNumber":"+91-9986173092"
		},
		{
			"guestId":104,
			"guestName":"Shashank",
			"contactNumber":"+91-9986464892"
		},
		{
			"guestId":105,
			"guestName":"Abishek",
			"contactNumber":"+91-9958659892"
		},
		{
			"guestId":106,
			"guestName":"Nachiket",
			"contactNumber":"+91-8997358092"
		},
		{
			"guestId":107,
			"guestName":"Vaishali",
			"contactNumber":"+91-9739179037"
		}
	];
	$scope.sortColumn = "+guestId"; // - for descending Order
 

});
/* ****************************************************************************************** */
guestNameSpace.controller('GuestAjaxCntrl',function($scope,$http){
	var promise = $http.get("data/guests.json");
	
	var onSuccess = function(response){
		$scope.guests = response.data;
	};
	
	var onError = function(statusText){
		$scope.error = "Program Works well with Mozilla firefox & Safari. To make it work with chrome browser, run chrome.exe with following command from run window(Win+R key). chrome.exe -allow-file-access-from-files -disable-web-security";
	};
	
	promise.then(onSuccess,onError);
});


var myApp=angular.module("directiveApp",[]);

myApp.run(function($rootScope){
	$rootScope.globalVariable="IGate Global variable";
});

/* **************************017_AngularJSParentChileScopeDemo.html************************* */

angular.module('myScopeApp', [])
   .controller('SomeController', function($scope) {
    // anti-pattern, bare value
    $scope.someBareValue = 'hello computer';
    // set actions on $scope itself, this is okay
    $scope.someAction = function() {
  // sets {{ someBareValue }} inside SomeController and ChildController
   $scope.someBareValue = 'hello human, from parent';
 };
})
.controller('ChildController', function($scope) {
$scope.childAction = function() {
// sets {{ someBareValue }} inside ChildController
$scope.someBareValue = 'hello human, from child';
};
});
.controller('SecondController', function($scope) {
// also can be empty
})


