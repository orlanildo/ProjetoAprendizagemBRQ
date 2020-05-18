
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<head>
	<base href="/">
	<title>Login</title>

	<link rel="stylesheet" href="../../css/login.css">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>

	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>

	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.9/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.9/angular-route.min.js"></script>
	<!-- <script src="../../../resources/angularJS/angular.js"></script> -->
	<!-- <script src="../../../resources/angularJS/angular-route.js" ></script> -->

	<!-- Controllers -->
	<script src="../../crontrollers/app.js"></script>
	<script src="../../crontrollers/loginController.js"></script>
	<script src="../../crontrollers/registerController.js"></script>

</head>

<body ng-app="app" ng-controller="loginController">

	<form method="post" class="form-signin">
		<h1 class="h3 mb-3 font-weight-normal">Projeto Aprendizagem BRQ</h1>

		<br />
		<label for="inputEmail" class="sr-only">Email address</label>
		<input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" 
			autofocus ng-model="client.email">

		<label for="inputPassword" class="sr-only">Password</label>
		<input type="password" name="password" id="inputPassword" class="form-control"
			placeholder="Password" ng-model="client.password">

		<div class="checkbox mb-3">
			<label>
				<input type="checkbox" value="remember-me"> Remember me
			</label>
		</div>
		
		<button class="btn btn-lg btn-primary btn-block" type="submit" 
			ng-click="logar()">Logar</button>
		<button class="btn btn-lg btn-primary btn-block" type="submit" 
			ng-click="goToRegister()">Cadastrar-se</button>

		<p class="mt-5 mb-3 text-muted">&copy; 2020</p>
		
	</form>

</body>

</html>