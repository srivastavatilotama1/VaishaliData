var app = angular.module("serviceApp",[]);


/*	Angular modules, themselves, have the opportunity to configure themselves before the module
	actually bootstraps and starts to run. 
	We can apply different sets of logic during the bootstrap phase of the app
 	A provider is an object with a $get() method. 
  	The $injector calls the $get method to create a new instance of the service. 
	The provider() method is responsible for registering services in the $providerCache

*/


app.config(function($provide){
	$provide.provider("retrieveGuests",function(){
		return{
			$get : function(){
				return{
					guests : 
					[
						{
							"guestId":101,
							"guestName":"Anil",
							"contactNumber":"+91-8645635092",
							"location":"Mumbai"
						},
						{
							"guestId":102,
							"guestName":"Ganesh",
							"contactNumber":"+91-9946945634",
							"location":"Mumbai"
						},
						{
							"guestId":103,
							"guestName":"Karthik",
							"contactNumber":"+91-9986173092",
							"location":"Bangalore"
						},
						{
							"guestId":104,
							"guestName":"Shashank",
							"contactNumber":"+91-9986464892",
							"location":"Pune"
						},
						{
							"guestId":105,
							"guestName":"Abishek",
							"contactNumber":"+91-9958659892",
							"location":"Chennai"
						},
						{
							"guestId":106,
							"guestName":"Nachiket",
							"contactNumber":"+91-8997358092",
							"location":"Pune"
						},
						{
							"guestId":107,
							"guestName":"Vaishali",
							"contactNumber":"+91-9739179037",
							"location":"Mumbai"
						}
					]
				}
			}
		}
	})
})