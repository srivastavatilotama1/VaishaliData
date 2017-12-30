var app = angular.module("serviceApp",[]);


app.factory("guestService",function($http,$q){
	return{
		retrieveGuests : function(){
			var deffered  = $q.defer();
			$http({
					method:'GET',
					url:'data/guests.json'
				})
				.success(function(data,status,headers,config){
					deffered.resolve(data);
				})
				.error(function(data,status,headers,config){
					deffered.reject(status);
				});
			return deffered.promise;
		} 
	}
})


