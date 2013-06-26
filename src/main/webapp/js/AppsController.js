 	function ProductListCtrl($scope, $http) {
 		$scope.listProducts = function() {
 			$http({method: 'GET', url: 'products'}).
  				success(function(data, status, headers, config) {
    		    	$scope.products = data;                  //set view model
    		    	$scope.view = 'partials/list.html'; //set to list view
  				}).
  				error(function(data, status, headers, config) {
  					$scope.products = data || "Request failed";
  					$scope.status = status;
  					$scope.view = 'partials/list.html';
  				});
  		};
  			
  		$scope.showProduct = function(id) {
  			$http({method: 'GET', url: 'products/' + id}).
  				success(function(data, status, headers, config) {
  					$scope.product = data;               //set view model
  					$scope.view = 'partials/detail.html'; //set to detail view
  				}).
  				error(function(data, status, headers, config) {
  					$scope.product = data || "Request failed";
  					$scope.status = status;
  					$scope.view = 'partials/detail.html';
  				});
  		};
  		
  		$scope.view = 'partials/list.html'; //set default view
  		$scope.listProducts();
 	}
 	ProductListCtrl.$inject = ['$scope', '$http'];