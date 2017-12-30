var myApp=angular.module("directiveApp",[]);

myApp.run(function($rootScope){
	$rootScope.globalVariable="IGate Global variable";
});