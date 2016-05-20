'use strict';

var App = angular.module('AngularSpringApp', [ 'ngRoute', 'ngResource' ]);

App.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/createAccount', {
		templateUrl : 'views/account/createAccountLayout.html',
		controller : 'createAccountCntrl'
	});

	$routeProvider.when('/createBlog', {
		templateUrl : 'views/blog/createBlogLayout.html',
		controller : 'createBlogCntrl'
	});

	$routeProvider.when('/addNewBlogEntry', {
		templateUrl : 'views/blog/addNewBlog.html',
		controller : 'addNewBlogEntryCntrl'
	});

	$routeProvider.when('/addNewBlog', {
		templateUrl : 'views/login.html',
		controller : 'loginCntrl'
	});

	$routeProvider.when('/viewBlogEntriesFromSingleOwner/:param', {
		templateUrl : 'views/blog/viewBlogEntriesFromSingleOwner.html',
		controller : 'viewBlogEntriesFromSingleOwnerCntrl'
	});

	$routeProvider.when('/addBlogsForUser/:param', {
		templateUrl : 'views/blog/addBlogsForUser.html',
		controller : 'addBlogsForUserCntrl'
	});
	$routeProvider.otherwise({
		redirectTo : '/createAccount'
	});
} ]);

// Create Account controller
App.controller('createAccountCntrl', function($scope, $http,$location) {
	$scope.message = 'Add New Account';
	
	$scope.addNewAccount = function(account) {
		$scope.resetError();
		$http.post('rest/accounts', account).success(function() {
			$location.path("/addBlogsForUser/"+$scope.account.name);
			$scope.account.name = '';
			$scope.account.password = '';

		}).error(function() {
			$scope.setError('Could not add a new account');
		});
	};
	$scope.resetError = function() {
		$scope.error = false;
		$scope.errorMessage = '';
	};

	$scope.setError = function(message) {
		$scope.error = true;
		$scope.errorMessage = message;
	};
});

// Blog Controller
App.controller('createBlogCntrl', function($scope, $http) {
	$scope.message = 'List of available blogs';
	$scope.data = {};
	$http.get('rest/blogs').success(function(blogList) {
		$scope.data.listOfBogs = blogList;
		$scope.listOfBlogs = [ {
			title : 'Computer Architecture',
			id : 65,
			owner : 'Sam'
		}, {
			title : 'Advanced Composite Materials',
			id : 45,
			owner : 'David'
		}, {
			title : 'Stategies Unplugged',
			id : 43,
			owner : 'Joe'
		}, {
			title : 'Teaching Science',
			id : 50,
			owner : 'Bibhuti'
		}, {
			title : 'Challenging Times',
			id : 22,
			owner : 'Cathy'
		} ];

	});

});
// login before you add a blog
App.controller('loginCntrl', function($scope, $http, $location) {
	$scope.message = 'Please login';

	$scope.login = function(account) {
		$scope.setSuccessMessage('You are in' + '' + account.name);
		$location.path("/addNewBlogEntry");
	};
	$scope.setSuccessMessage = function(message) {
		$scope.error = false;
		$scope.successMessage = message;

	};

});

// Add blog catagory
App.controller('addNewBlogCatagoryCntrl', function($scope, $http) {
	$scope.message = 'This is Add new Blog catagory screen';

});
// Add blog entry
App.controller('addNewBlogEntryCntrl', function($scope, $http,$location) {
	$scope.message = 'This is Add new blog entry screen';
	$http.get('rest/blogs/blog-categories').success(function(blogCategory) {
		// $scope.data.listOfBogsCategories = blogCategory;

		$scope.listOfBogsCategories = [ {
			name : 'Computer Architecture',
			id : 6
		}, {
			name : 'Advanced Composite Materials',
			id : 4
		}, {
			name : 'Stategies Unplugged',
			id : 3
		}, {
			name : 'Teaching Science',
			id : 5
		}, {
			name : 'Challenging Times',
			id : 2
		} ];
	});
	$scope.createBlogEntry = function(blogEntry) {
		$http.post('rest/blogs/1/blog-entries', blogEntry).success(function() {
			$scope.blogEntry.name = '';
			$scope.blogEntry.password = '';
			$scope.setSuccessMessage('successfully created blog Entry');
			$location.path("/createBlog");

		}).error(function() {
			$scope.setError('Could not add a Blog Entry');
		});
		$scope.setError = function(message) {
			$scope.error = true;
			$scope.errorMessage = message;
		};

		$scope.setSuccessMessage = function(message) {
			$scope.error = false;
			$scope.successMessage = message;
		};

	};

});

// View blog entries
App.controller('viewBlogEntriesFromSingleOwnerCntrl', function($scope, $http,
		$routeParams) {

	$scope.param = $routeParams.param;
	$scope.message = 'Blogs created by' + ' ' + $scope.param;
	$http.get('rest/blogs/{blogId}/blog-entries').success(
			function(blogEntryList) {
				$scope.data.listOfBlogEntries = blogEntryList;
			});

});

//Add blog catagories for the user
App.controller('addBlogsForUserCntrl', function($scope, $http,
		$location,$routeParams) {
	$scope.name = $routeParams.param;
	$scope.message='Add Blog Categories';
	//Display a list of blog categories
	$http.get('rest/blogs/blog-categories').success(function(blogCategory) {
		// $scope.data.listOfBogsCategories = blogCategory;
		$scope.listOfBogsCategories = [ {
			category : 'Computer Architecture',
			id : 6
		}, {
			category : 'Advanced Composite Materials',
			id : 4
		}, {
			category : 'Stategies Unplugged',
			id : 3
		}, {
			category : 'Teaching Science',
			id : 5
		}, {
			category : 'Challenging Times',
			id : 2
		} ];
	});
	$scope.addBlogCateogoryForUser =function(blog){
		$http.post('rest/blogs', blog).success(function() {
		$location.path("/addNewBlogEntry");

		}).error(function() {
			$scope.setError('Could not add blog catagories for  '+ $scope.name);
		});
		$scope.setError = function(message) {
			$scope.error = true;
			$scope.errorMessage = message;
		};
	}
});
