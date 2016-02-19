<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="introductionApp" lang="en">

<head>
	<title>SingOut - Automation</title>
	<meta name="viewport" content="width=80, initial-scale=1">

	<!-- icon -->
	<link rel="icon" type="image/x-icon" href="/automation_web/static/images/logo-green.jpg" />

	<!-- css -->
	<link rel="stylesheet" type="text/css" href="/automation_web/static/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/automation_web/static/css/automation_style.css">

	<!-- js -->
	<script type="text/javascript" src="/automation_web/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="/automation_web/static/js/bootstrap.min.js"></script>
	
</head>


<body>

	<div class="navbar navbar-default">
		<div class="container">
			<a href="#" class="navbar-brand">
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
					<li><a href="/automation_web">Home</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li ><a href="/automation_web/signIn">Sign in</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container">
		<p>You have signed out of automation!</p>
	</div>
</body>
</html>