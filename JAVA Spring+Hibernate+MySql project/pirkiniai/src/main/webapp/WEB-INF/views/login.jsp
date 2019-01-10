<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

  </head>
<body>

<div class="col-md-5 mx-auto">
	
	<form method="post" action="${pageContext.request.contextPath}/login" style="padding-top: 9rem">
			<h2 class="d-flex justify-content-center">Username</h2>
			<p>
			<label for="username" class="sr-only">Username</label> 
			<input type="text" id="username" name="username" class="form-control"
				placeholder="Type in your username..." required autofocus>
			</p>
		
			<h2 class="d-flex justify-content-center">Password </h2>
			<p>
				<label for="password" class="sr-only">Password</label> 
				<input type="password" id="password" name="password" class="form-control"
					placeholder="Type in your password..." required>
			</p>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button class="btn-primary form-control" type="submit" style="margin-top: 2rem">Login</button>
	</form>
</div>





<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>