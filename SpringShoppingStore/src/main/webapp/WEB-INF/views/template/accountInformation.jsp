<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
</style>
<body>
	<div id="accountForm" class="col-md-8">
		<h1>Account Information</h1>
		<form class="form-horizontal" action="" method="post">
			<div class="form-group">
				<div class="col-sm-9">
					<label for="userName">User Name:</label> <input type="text"
						class="form-control" name="userName" placeholder="User Name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-9">
					<label for="firstName">First Name:</label> <input type="text"
						class="form-control" name="firstName" placeholder="First Name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-9">
					<label for="lastName">Last Name:</label> <input type="text"
						class="form-control" name="lastName" placeholder="Last Name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-9">
					<label for="phoneNumber">Mobile Number:</label> <input type="text"
						class="form-control" name="phoneNumber"
						placeholder="Mobile Number" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-9">
					<input type="submit" value="Save" class="btn btn-success" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>