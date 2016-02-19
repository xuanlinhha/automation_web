<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="interactionApp" lang="en">

<head>
	<title>${username} - Automation View</title>
	<meta name="viewport" content="width=80, initial-scale=1">

	<!-- icon -->
	<link rel="icon" type="image/x-icon" href="/automation_web/static/images/logo-green.jpg" />

	<!-- css -->
	<link rel="stylesheet" type="text/css" href="/automation_web/static/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/automation_web/static/css/spectrum.css">
	<link rel='stylesheet' type="text/css" href="/automation_web/static/css/bootstrap-slider.min.css"/>
	<link rel="stylesheet" type="text/css" href="/automation_web/static/css/automation_style.css">

	<!-- js -->
	<script type="text/javascript" src="/automation_web/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="/automation_web/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/automation_web/static/js/angular.min.js"></script>
	<script type="text/javascript" src="/automation_web/static/js/angular-route.min.js"></script>
	<script type="text/javascript" src="/automation_web/static/js/sockjs.min.js"></script>
	<script type="text/javascript" src="/automation_web/static/js/stomp.min.js"></script>
	<script type="text/javascript" src="/automation_web/static/js/spectrum.js"></script>
	<script type="text/javascript" src="/automation_web/static/js/bootstrap-slider.min.js"></script>
	<script type="text/javascript" src="/automation_web/static/js/interaction.js"></script>

</head>


<body>

	<!-- navbar -->
	<div class="navbar navbar-default">
		<div class="container">
			<a href="#/0" class="navbar-brand">
				<img src="/automation_web/static/images/automation-green.png">
			</a>

			<button class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-introduction">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbar-collapse-introduction">
				<ul class="nav navbar-nav">
					<li><a href="#/0">Root</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li ><a href="/automation_web/securedSignOut">Sign out</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div ng-view></div>

</body>
</html>