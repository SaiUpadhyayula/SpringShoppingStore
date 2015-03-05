<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="resources/css/bootstrap.css" />
<style>
footer {
	background-color: lightgray;
	border: solid 1px black;
	font-family: 'Times New Roman', serif;
	padding: 10px;
}

footer {
	padding: 10px;
	border-radius: 3px;
}

body {
	font-family: Segoe UI;
	font-size: 14px;
	background-color: gray;
}

html,body {
	padding: 0;
	margin: 0;
}

#main {
	border: solid 1px #ccc;
	border-radius: 5px;
	color: #202020;
	margin: 20px 0;
	padding: 5px;
}

#featProds {
	padding: 2px;
	width: 300px;
}

.container {
	width: 989px;
	margin: auto;
	background-color: white;
	padding: 5px;
}

#billingFormm {
	padding: 5px;
}

#addressTitle {
	padding: 0px;
}

body {
	margin-top: 20px;
}

.panel-title {
	display: inline;
	font-weight: bold;
}

.checkbox.pull-right {
	margin: 0;
}

.pl-ziro {
	padding-left: 0px;
}
</style>
</head>
<body>
	<div class="container">
		<header>
			<%@include file="template/header.jsp"%>
		</header>
		<section id="main">
			<div class="row">
				<div class="col-md-6">
					<h4>Select a Payment Method</h4>
					<form:form name="paymentForm" action="createOrderByCC" method="POST">
						<div class="row">
							<div class="col-xs-20 col-md-8">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h3 class="panel-title">Payment Details</h3>
										<div class="checkbox pull-right">
											<label> <input type="checkbox" /> Remember
											</label>
										</div>
									</div>
									<div class="panel-body">
										<form role="form">
											<div class="form-group">
												<label for="cardNumber"> CARD NUMBER</label>
												<div class="input-group">
													<input type="text" class="form-control"
														id="creditCardNumber" name="creditCardNumber"
														placeholder="Valid Card Number" required autofocus /> <span
														class="input-group-addon"><span
														class="glyphicon glyphicon-lock"></span></span>
												</div>
											</div>
											<div class="form-group">
												<label for="cardNumber"> NAME ON CARD</label>
												<div class="input-group">
													<input type="text" class="form-control" id="name"
														name="name" placeholder="Name on Card" required autofocus />
													<span class="input-group-addon"><span
														class="glyphicon glyphicon-user"></span></span>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-7 col-md-7">
													<div class="form-group">
														<label for="expityMonth"> EXPIRY DATE</label>
														<div class="col-xs-6 col-lg-6 pl-ziro">
															<input type="text" class="form-control" id="expityMonth"
																name="month" placeholder="MM" required />
														</div>
														<div class="col-xs-6 col-lg-6 pl-ziro">
															<input type="text" class="form-control" id="expityYear"
																name="year" placeholder="YY" required />
														</div>
													</div>
												</div>
												<div class="col-xs-5 col-md-5 pull-right">
													<div class="form-group">
														<label for="cvCode"> CV CODE</label> <input
															type="password" class="form-control" id="cvCode"
															name="cvvCode" placeholder="CV" required />
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
								<ul class="nav nav-pills nav-stacked">
									<li class="active"><a href="#"><span
											class="badge pull-right"><span
												class="glyphicon glyphicon-usd"></span>4200</span> Final Payment</a></li>
								</ul>
								<br />
								<button type="submit" class="btn btn-success btn-lg btn-block">Pay</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/bootstrap-min.js"></script>
<script src="resources/js/jquery-1.8.0.js"></script>
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
			});
</script>