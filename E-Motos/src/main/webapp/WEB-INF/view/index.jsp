
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<head>
	<base href="/">
	<title>Index</title>

	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.9/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.9/angular-route.min.js"></script>
	<!-- <script src="../../../resources/angularJS/angular.js"></script> -->
	<!-- <script src="../../../resources/angularJS/angular-route.js" ></script> -->

	<!-- Controllers -->
	<script type="text/javascript" src="../../crontrollers/app.js"></script>
	<script src="../../crontrollers/loginController.js"></script>
	<script src="../../crontrollers/registerController.js"></script>

</head>

<body ng-app="app" ng-controller="loginController">
	<h1>Spring Boot JSP Example</h1>

	<a href="/register">Register</a>
	<br /><br />
	<a href="/login">Login</a>

	<div ng-view="ng-view">

	</div>
	
</body>

</html>