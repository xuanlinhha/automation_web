(function() {
	var app = angular.module('interactionApp', ['ngRoute']);

	app.config(['$routeProvider',
		function($routeProvider) {
			$routeProvider.
			when('/:nodeId', {
				templateUrl: '/automation_web/static/partials/display.html',
				controller: 'InteractionController'
			}).
			otherwise({
				redirectTo: '/0'
			});
		}]);

	app.controller('InteractionController', ['$scope', '$routeParams', '$http',
		function($scope, $routeParams, $http){
			$scope.model = {
				breadcrums: [],
				nodes: [],
				test_value: 0
			};
			$scope.socket = {
				client: null,
				stomp: null
			};

			$scope.changeStatus = function(node, newStatus) {
				$http.post('/automation_web/interaction/set/' + node.id, newStatus)
				.success(function(data, status) {
					node.status = newStatus;
				})
				.error(function() {
					alert('Your service is not available!');
				});
			};

			$scope.loadData = function() {
				$http.get('/automation_web/interaction/get/' + $routeParams.nodeId).success(function(data) {
					var isBreadcrumb = true;
					for(var i=0; i<data.length; i++) {
						if (isBreadcrumb) {
							$scope.model.breadcrums.push(data[i]);
							if (data[i].id === $routeParams.nodeId) {
								isBreadcrumb = false;
							}
						}
						else {
							$scope.model.nodes.push(data[i]);
						}
					}
				});
			};
			$scope.updateStatus = function(notification) {
				var node = JSON.parse(notification.body);
				for(var i=0; i<$scope.model.nodes.length; i++) {
					if ($scope.model.nodes[i].id === node.id) {
						$scope.model.nodes[i].status = node.status;
						break;
					}
				}
			};
			$scope.reconnect = function() {
				setTimeout($scope.initSockets, 10000);
			};
			$scope.initWebSocket = function() {
				$scope.socket.client = new SockJS('/automation_web/automation_stomp_endpoint');
				$scope.socket.stomp = Stomp.over($scope.socket.client);
				$scope.socket.stomp.connect({}, function() {
					$scope.socket.stomp.subscribe("/user/queue/update_status", function(notification) {
						$scope.updateStatus(notification);
						$scope.$digest();
					});
				});
				$scope.socket.client.onclose = $scope.reconnect;
			};

			$scope.loadData();
			$scope.initWebSocket();
			
		}
		]);

	app.directive('switch', function() {
		function link($scope, element, attrs){
			function render(initStatus) {
				if (initStatus[0] === 0) {
					element.children().eq(0).removeClass("btn-success"); // mark OFF
					element.children().eq(1).addClass("btn-success");
				} else {
					element.children().eq(0).addClass("btn-success"); // mark ON
					element.children().eq(1).removeClass("btn-success");
				}
			}
			element.children().eq(0).bind('click', function(){
				if ($scope.node.status[0] === 0) { // process ON button only if status is OFF
					$scope.changeStatus($scope.node, [1]);
				};
			})
			element.children().eq(1).bind('click', function(){
				if ($scope.node.status[0] === 1) { // process ON button only if status is ON
					$scope.changeStatus($scope.node, [0]);
				};
			})
			$scope.$watchCollection('node.status', function(newStatus, oldStatus) {
				render($scope.node.status);
			});
			render($scope.node.status);
		}
		return {
			restrict: 'E',
			replace: true,
			templateUrl: '/automation_web/static/partials/switch-template.html',
			link: link
		}
	});

	app.directive('moodLight', function() {
		function link($scope, element, attrs) {
			function render(initStatus) {
				element.slider({value: initStatus[0]})	
				.on('slideStop', function(ev) {
					$scope.changeStatus($scope.node, [ev.value]);
				});
			}
			function update(newStatus) {
				element.slider('setValue', newStatus[0]);
			}
			$scope.$watchCollection('node.status', function(newStatus, oldStatus) {
				update($scope.node.status);
			});
			render($scope.node.status);
		}
		return {
			restrict: 'E',
			templateUrl: '/automation_web/static/partials/mood-light-template.html',
			replace: true,
			link: link
		};
	});
	
	app.directive('colorLight', function() {
		function link($scope, element, attrs) {
			function render(initStatus) {
				element.spectrum({
					color: '"rgb(' + initStatus[0] + ', ' + initStatus[1] + ', ' + initStatus[2] + ')"',
					showPaletteOnly: true,
					showPalette:true,
					palette: [
							['rgb(0,0,0)','rgb(255, 255, 255)'],
							['red', 'yellow', 'green', 'blue', 'violet']
						],
					change: function(color) {
							var newStatus=[];
							newStatus.push(color.toRgb().r);
							newStatus.push(color.toRgb().g);
							newStatus.push(color.toRgb().b);
							$scope.changeStatus($scope.node, newStatus);
						}
				});
			}
			function update(newStatus) {
				var newColor = '"rgb(' + newStatus[0] + ', ' + newStatus[1] + ', ' + newStatus[2] + ')"';
				element.spectrum('set', newColor);
			}
			$scope.$watchCollection('node.status', function(newVal, oldVal) {
				update($scope.node.status);
			});
			render($scope.node.status);
		}
		return {
			restrict: 'E',
			templateUrl: '/automation_web/static/partials/color-light-template.html',
			replace: true,
			link: link
		};
	});

}());
