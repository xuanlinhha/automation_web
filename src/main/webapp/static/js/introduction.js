(function() {
	var app = angular.module('introductionApp', ['ngRoute']);

	app.config(['$routeProvider',
		function($routeProvider) {
			$routeProvider.
			when('/introduction', {
				templateUrl: '/automation_web/static/partials/introduction.html',
				controller: 'IntroductionController'
			}).
			when('/introduction/projects', {
				templateUrl: '/automation_web/static/partials/projects.html',
				controller: 'ProjectsController'
			}).
			when('/introduction/contacts', {
				templateUrl: '/automation_web/static/partials/contacts.html',
				controller: 'ContactsController'
			}).
			otherwise({
				redirectTo: '/introduction'
			});
		}]);

	app.run(function($rootScope) {
		$rootScope.tab = 1;
		$rootScope.setTab = function(tabValue) {
			$rootScope.tab = tabValue;
		};
		$rootScope.isTab = function(tabValue) {
			return $rootScope.tab === tabValue;
		};
	});

	app.controller('IntroductionController', function($rootScope) {
		$rootScope.tab = 1;
	});

	app.controller('ProjectsController', function($rootScope) {
		$rootScope.tab = 2;
	});

	app.controller('ContactsController', function($rootScope) {
		$rootScope.tab = 3;
	});

}());
