var app = angular.module("serviceApp",[]);
/*
  The most common method for registering a service with our Angular app is 
  through the factory() method. This method is a quick way to create and configure a service.
  The factory() function takes two arguments. 
   Name of the service  which we want to register
  Function which runs when Angular creates the service. 
  It will be invoked once for the duration of the app lifecycle, 
  as the service is a singleton object. It can return anything from a 
  primitive value to a function to an object. 
 */
app.factory("getAllGuests",function(){
	return{
		guests : 
		[
			{
				"guestId":101,
				"guestName":"Vaishali S",
				"contactNumber":"+91-8888108810",
				"location":"Pune"
			},
			{
				"guestId":102,
				"guestName":"Pramod Jadha",
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
})

