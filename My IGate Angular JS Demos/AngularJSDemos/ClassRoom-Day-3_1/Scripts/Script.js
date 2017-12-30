var employeeNameSpace = angular.module('employeeApp',[]);

employeeNameSpace.controller('EmployeeController',function($scope){
	$scope.employee = {
		'name':'Karthik',
		'department':'Training',
		'companyName':'IGATE'
	};
});

