<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="introductionApp" lang="en">

<head>
	<title>SignIn - Automation</title>
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
					<li><a href="/automation">Home</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="/automation_web/signIn">Sign in</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-md-offset-4">

				<form method="POST" action="<c:url value="/securedSignIn"/>"
				class="form-horizontal" role="form">
				<h3 class="form-signin-heading">Welcome back</h3>
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" name="username" class="form-control"
						placeholder="User name">
					</div>
					<div class="col-sm-12">
						<input type="password" name="password" class="form-control"
						placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<div class="checkbox">
							<label> <input type="checkbox"
								name="_spring_security_remember_me" value="true">
								Remember me
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<button class="btn btn-lg btn-primary btn-block" type="submit">
							Sign in</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>