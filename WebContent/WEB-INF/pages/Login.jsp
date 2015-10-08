<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet "type="text/css" href="../css/style.css">
	
</head>
<body>
	<div class="container-fluid"  >
		<div class="row" style="background-color: transparent;">
			<div class="col-md-8" style="background-color: transparent;">
				<h1 class="jumbotron" style="background-color:transparent;color:blue">Welcome To Sapient Portal</h1>
			</div>

			<div class="col-md-4" style="background-color: transparent;">
			<h1>Login</h1>
				<form name="login" action="/HardwareStore/login" method="POST">
					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
							class="form-control" id="email" name="emailid" placeholder="Email">
					</div>
					<div class="from-group">
						<label for="pass">Password</label> <input type="password"
							class="form-control" id="pass" name="pass" placeholder="Password">
					</div>
					<div class="checkbox">
						<label><input type="checkbox">Remember Me</label>
					</div>
					<button type="submit" class="btn btn-primary">Login</button>

				</form>
			
				<h1>Create an Account</h1>
				<form name="register" action="/HardwareStore/register" method="POST">
					<div class="form-group">
						<label for="name">Name:</label> <input type="text"
							class="form-control" name="name">
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
							class="form-control" name="email">
					</div>
					<div class="form-group">
						<label for="pass">Password:</label> <input type="password"
							class="form-control" name="pass">
					</div>
					<div class="form-group">
						<label for="cpass">Contact No:</label> <input type="text"
							class="form-control" name="contactNo">
					</div>
					<div class="form-group">
						<label for="cpass">Address:</label> <input type="text"
							class="form-control" name="address">
					</div>
					<button type="submit" class="btn btn-primary">Register</button>
				</form>
			</div>
		</div>
	</div>


	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>