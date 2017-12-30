/*-----------------Directive01-------------------------*/
var app = angular.module("directivesApp",[]);
app.directive("helloworldElement",function(){
	return {
		restrict:"E",
		template: "<h1>Hello World Element from Directive</h1>"
	}
});

app.directive("helloworldattr",function(){
	return {
		restrict:"A",/*Default*/
		template: "<h1>Hello World Attribute from Directive</h1>"
	}
});

app.directive("helloworldclass",function(){
	return {
		restrict:"C",
		template: "<h1>Hello World Class from Directive</h1>"
	}
});

app.directive("helloworldcomment",function(){
	return {
		restrict:"M",
		replace:true,
		template: "<h1>Hello World Comment from Directive</h1>"
	}
});


app.directive("helloworld",function(){
	return {
		restrict:"AC",
		template: "<h1>Hello World from Directive</h1>"
	}
});
/*-------------------Directive03---------------------------*/


app.controller("AppController",function($scope){
	      $scope.modelVariable = "Initial Value";
	
	      $scope.sayHi=function(){
	     	alert('Hi');
	}
  	
	    $scope.sayBye=function(){
		     alert('Bye');
	}
});

app.directive('showalert',function(){
	return function(scope,element,attrs){
		element.bind('click',function(){
			scope.$apply(attrs.showalert);
		})
	}
});

app.directive('changeValue',function(){
	return function(scope,element,attrs){
	/*Setting Watch Explicitly*/
		scope.$watch('modelVariable', function(newValue, oldValue) {
			console.log("Old Value : "+ oldValue+" New Value : "+newValue);
		});
		element.bind('click',function(){
			scope.modelVariable = "Value Changed";
			scope.$apply(); //Triggering Digest Cycle
		});
	}
});

/*---------------------Directive04------------------------------*/
app.directive('repodirective',function(){
	return{
		restrict:"E",
		controller : function($scope){
			$scope.styleAddCounter=0;
			$scope.style01 = "customStyle";
			
			this.styleAdded = function(){
				$scope.styleAddCounter+=1;
				console.log('Style Added');
			}
			this.styleRemoved = function(){
				console.log('Style Removed');
			}
		},
		link : function(scope,element,attrs){
			console.log("From repodirective :"+attrs.class);
		}
	}
})

app.directive('sty01',function(){
	return{
		require : '^repodirective',
		link : function(scope,element,attrs,directive){
		
			element.bind('mouseenter',function(){
				element.addClass(scope.style01);
				console.log("Style Added counter :"+scope.styleAddCounter);
				directive.styleAdded();
			})
			
			element.bind('mouseleave',function(){
				element.removeClass(scope.style01);
				directive.styleRemoved();
			})
			
			console.log("From sty01 directive :"+attrs.class);
		}
	}
})



