<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Sign In - Sign Up Dual Modal - Bootsnipp.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.prettyline {
	height: 5px;
	border-top: 0;
	background: #c4e17f;
	border-radius: 5px;
	background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%,
		#f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%,
		#db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%,
		#669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%,
		#f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%,
		#db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%,
		#669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca
		25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe
		50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1
		87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca
		25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe
		50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1
		87.5%, #62c2e4 87.5%, #62c2e4);
}

#rememberme-0 {
	padding: 5px;
}
</style>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<body>
	<!-- Button trigger modal -->

	<div class="row">
		<hr class="prettyline">
		<br>
		<div style="text-align: center">
			<h3>Hey!! How are you doing? Have an account ?</h3>
			<div class="container">
				<div id="loginbox" style="margin-top: 50px;"
					class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="panel-title">Sign In</div>
							<div
								style="float: right; font-size: 80%; position: relative; top: -10px">
								<a href="#">Forgot password?</a>
							</div>
						</div>

						<div style="padding-top: 30px" class="panel-body">

							<div style="display: none" id="login-alert"
								class="alert alert-danger col-sm-12"></div>

							<form id="loginform" class="form-horizontal" action="login"
								method="post">

								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input id="userName"
										type="text" class="form-control" name="userName" value=""
										placeholder="userName">
								</div>

								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input id="password"
										type="password" class="form-control" name="password"
										placeholder="password">
								</div>



								<div class="input-group">
									<div class="checkbox">
										<label> <input id="login-remember" type="checkbox"
											name="remember" value="1"> Remember me
										</label>
									</div>
								</div>

								<div class="statusMessage">
									<c:if test="${result gt 0}">
										<span><strong>Successfully registered!! Please
												Login</strong> </span>
									</c:if>
									<c:if test="${result == 0}">
										<span><strong>Customer Already Registered!!</strong> </span>
									</c:if>
								</div>
								<div style="margin-top: 10px" class="form-group">
									<div class="loginStatus"></div>
									<div class="col-sm-12 controls">
										<button id="btn-login" type="submit" class="btn btn-success">Login
										</button>
									</div>
								</div>


								<div class="form-group">
									<div class="col-md-12 control">
										<div
											style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
											Don't have an account! <a href="#"
												onClick="$('#loginbox').hide(); $('#signupbox').show()">
												Sign Up Here </a>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div id="signupbox" style="display: none; margin-top: 50px"
					class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="panel-title">Sign Up</div>
							<div
								style="float: right; font-size: 85%; position: relative; top: -10px">
								<a id="signinlink" href="#"
									onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign
									In</a>
							</div>
						</div>
						<div class="panel-body">
							<form id="signupform" action="register" class="form-horizontal"
								role="form" method="post">
								<div id="signupalert" style="display: none"
									class="alert alert-danger">
									<p>Error:</p>
									<span></span>
								</div>
								<div class="form-group">
									<label for="email" class="col-md-3 control-label">Email</label>
									<div class="col-md-9">
										<input type="text" class="form-control" name="emailAddress"
											placeholder="Email Address">
									</div>
								</div>

								<div class="form-group">
									<label for="email" class="col-md-3 control-label">User
										Name</label>
									<div class="col-md-9">
										<input type="text" class="form-control" name="userName"
											placeholder="User Name">
									</div>
								</div>

								<div class="form-group">
									<label for="password" class="col-md-3 control-label">Password</label>
									<div class="col-md-9">
										<input type="password" class="form-control" name="password"
											placeholder="Password">
									</div>
								</div>

								<div class="form-group">
									<!-- Button -->
									<div class="col-md-offset-3 col-md-9">
										<button id="btn-signup" type="submit" class="btn btn-info">
											<i class="icon-hand-right"></i> Sign Up
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
		<br>
		<hr class="prettyline">
	</div>
</body>
</html>
<script>
	$(document).ready(			
			function() {
				$(".dropdown").hover(
						function() {
							$('.dropdown-menu', this).not('.in .dropdown-menu')
									.stop(true, true).slideDown("fast");
							$(this).toggleClass('open');
						},
						function() {
							$('.dropdown-menu', this).not('.in .dropdown-menu')
									.stop(true, true).slideUp("fast");
							$(this).toggleClass('open');
						});
				var loginStatus = "${loginStatus}";
				if(loginStatus == 'fail'){
					$(".loginStatus").text('Login Unsuccessfull.Please Retry');
				}
			}
			
	);
</script>