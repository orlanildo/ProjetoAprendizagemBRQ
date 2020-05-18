<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<head>
	<title>Registro</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../../css/register.css">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

	<!--Inport AngularJS-->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.9/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.9/angular-route.min.js"></script>

	<!-- Controllers -->
	<script src="../../crontrollers/app.js"></script>
	<script src="../../crontrollers/registerController.js"></script>
</head>

<body ng-app="app" ng-controller="registerController">
<div class="container-fluid">
    <div class="containerRegister">
        <form class="form-signin">
            <h1 class="h3 mb-3 font-weight-normal text-center">Registre-se</h1>
            <!-- Address Informations-->    
            <label for="inputZipCode" class="sr-only">Cep</label>
            <input type="zipCode" id="inputZipCode" class="form-control" placeholder="CEP" autofocus
            ng-model="client.zipCode">
            <div class="input-group form-group">
                <label for="inputStreet" class="sr-only">Rua</label>
                <input type="street" id="inputStreet" class="form-control" placeholder="Rua" autofocus
                ng-model="client.street">
                <label for="inputNumber" class="sr-only">Numero</label>
                <input id="inputNumber" class="form-control col-md-2" placeholder="N�" autofocus
                ng-model="client.number">
            </div>
            <label for="inputDistrict" class="sr-only">Bairro</label>
            <input type="district" id="inputDistrict" class="form-control" placeholder="Bairro" autofocus
            ng-model="client.district">
            <div class="input-group form-group">
                <label for="inputCity" class="sr-only">Cidade</label>
                <input type="city" id="inputCity" class="form-control" placeholder="Cidade" autofocus
                ng-model="client.city">
                <label for="inputState" class="sr-only">Estado</label>
                <select type="state" id="inputState" class="form-control col-md-4" placeholder="Estado" autofocus
                ng-model="client.state">
                    <option>Estado</option>
                    <option>SP</option>
                    <option>RJ</option>
                    <option>BH</option>
                    <option>MT</option>
                </select>
            </div> 
            <!-- User Informations-->   
            <label for="inputCpf" class="sr-only">CPF</label>
            <input type="cpf" id="inputCpf" class="form-control" placeholder="CPF" autofocus
            ng-model="client.cpf">
            <label for="inputName" class="sr-only">Nome Completo</label>
            <input type="name" id="inputName" class="form-control" placeholder="Nome Completo" autofocus
            ng-model="client.name">
            <label for="inputEmail" class="sr-only">Email</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email" autofocus
            ng-model="client.email">
            <label for="inputPassword" class="sr-only">Senha</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Senha"
            ng-model="client.password">
            <button class="btn btn-lg btn-primary" type="submit" ng-click="goToHome()">Salvar</button>
            <button class="btn btn-lg btn-primary" type="submit" ng-click="goToLogin()">Cancelar</button>
            <p class="mt-5 mb-3 text-muted text-center">&copy; 2020</p>
        </form>
        </div>
    </div>
</body>

</html>