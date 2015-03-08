<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Change Password</h1>
		<c:if test="${flag}">
			<p class="bg-success">Password changed successfully!!.</p>
		</c:if>
		<form class="form-horizontal" action="changepassword" method="POST">
			<div class="form-group">
				<div class="col-sm-6">
					<label for="password1" class="control-label">Type your
						Password</label> <input type="password" class="form-control"
						id="password1" name="password1" placeholder="Type Password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<label for="password2" class="control-label">Re-Type your
						Password</label> <input type="password" class="form-control"
						id="password2" name="password2" placeholder="Retype Password">
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
<script>
	$("input[type=password]").keyup(function() {
		if ($("#password1").val() == $("#password2").val()) {
			$("#pwmatch").removeClass("glyphicon-remove");
			$("#pwmatch").addClass("glyphicon-ok");
			$("#pwmatch").css("color", "#00A41E");
		} else {
			$("#pwmatch").removeClass("glyphicon-ok");
			$("#pwmatch").addClass("glyphicon-remove");
			$("#pwmatch").css("color", "#FF0004");
		}
	});
</script>
</html>
