var app = angular.module("serviceApp",['ngResource']);

app.factory("EmployeeService", function ($resource) {
    //return $resource('data/employees/:Id.json', { Id: '@Id' }, { "update": { method: "PUT" }});
	return $resource('https://api.mongolab.com/api/1/databases/igateangulardb/collections/employees?apiKey=Y6KaLZK8I2pEA-zgfk8oGNP6v8IVOLFm', { _id: '@_id' }, { "update": { method: "POST" }}, { "delete": { method: "POST" }});
})



