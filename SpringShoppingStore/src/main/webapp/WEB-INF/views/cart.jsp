<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/prettyPhoto.css" rel="stylesheet">
<link href="resources/css/price-range.css" rel="stylesheet">
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="resources/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="resources/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="resources/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="resources/images/ico/apple-touch-icon-57-precomposed.png">
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
</style>
</head>
<body>
	<div class="container">
		<header>
			<%@include file="template/header.jsp"%>
		</header>
		<section id="main">
			<div class="row">
				<div class="col-sm-12 col-md-12">

					<table class="table table-hover">
						<thead>
							<tr>
								<th>Product</th>
								<th>Quantity</th>
								<th class="text-center">Price</th>
								<th class="text-center">Total</th>
								<th> </th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${cart.numberOfItems== 0}">
									<tr>
										<c:url var="home" value="home" />
										<div style="text-align: center">
											<h4>Your Shopping Cart is Empty</h4>
											<a href="${home}" class="btn btn-info">Continue Shopping</a>
										</div>
									</tr>
								</c:when>
								<c:otherwise>
									<c:set var="productsList" value="${cart.orderItemsList}" />
									<c:forEach var="list" items="${productsList}">
										<tr>
											<td class="col-sm-8 col-md-6">
												<div class="media">
													<a class="thumbnail pull-left" href="#"> <img
														class="media-object"
														src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png"
														style="width: 72px; height: 72px;">
													</a>
													<div class="media-body">
														<c:url var="product" value="product">
															<c:param name="productId"
																value="${list.product.productId}" />
														</c:url>
														<h4 class="media-heading">
															<a href="${product}"> <c:out
																	value="${list.product.name}" /></a>
														</h4>
														<h5 class="media-heading">
															by
															<c:out value="${list.product.manufacturer}   " />
														</h5>
														<span>Status: </span><span class="text-success"><strong>In
																Stock</strong></span>
													</div>
												</div>
											</td>
											<form action="update" method="POST">
												<td class="col-sm-1 col-md-1" style="text-align: center">
													<input type="number" name="quantity"
													value="<c:out value="${list.quantity}"/>" size="2"
													maxlength="2" max="10" min="1" /> <input type="hidden"
													name="productid" value="${list.product.productId}" />
													<button type="submit"
														class="updateQuantity btn btn-default">Update</button>
												</td>
											</form>
											<td class="col-sm-1 col-md-1 text-center"><strong>Rs.<c:out
														value="${list.product.price}" /></strong></td>
											<td class="col-sm-1 col-md-1 text-center"><strong>Rs.<c:out
														value="${list.total}" /></strong></td>
											<td class="col-sm-1 col-md-1"><c:url var="remove"
													value="remove">
													<c:param name="productId" value="${list.product.productId}" />
												</c:url> <a href="${remove}" type="button" class="btn btn-danger">
													<span class="glyphicon glyphicon-remove"></span> Remove
											</a> <c:if test="${not empty customer}">
													<c:url var="moveToWishList" value="/moveToWishList">
														<c:param name="productId"
															value="${list.product.productId}" />
													</c:url>
													<a href="${moveToWishList}" type="button"
														class="btn btn-success"> Move to Wishlist </a>
												</c:if></td>
										</tr>
									</c:forEach>
									<tr>
										<td> </td>
										<td> </td>
										<td> </td>
										<td><h5>Subtotal</h5></td>
										<td class="text-right"><h5>
												<strong>Rs.<c:out value="${cart.total}" /></strong>
											</h5></td>
									</tr>
									<tr>
										<td> </td>
										<td> </td>
										<td> </td>
										<td><h3>Total</h3></td>
										<td class="text-right"><h3>
												<strong>Rs.<c:out value="${cart.total}" /></strong>
											</h3></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td><c:url var="emptycart" value="clear" /> <a
											href="${emptycart}" type="button" class="btn btn-default">
												Clear Cart <span class="glyphicon glyphicon-shopping-cart"></span>
										</a></td>
										<td><c:url var="home" value="home" /> <a href="${home}"
											type="button" class="btn btn-default"> <span
												class="glyphicon glyphicon-shopping-cart"></span> Continue
												Shopping
										</a></td>
										<td><c:url var="checkout" value="checkout" /> <a
											href="${checkout}" type="button" class="btn btn-success">
												Checkout <span class="glyphicon glyphicon-play"></span>
										</a></td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
					<div>
						<c:if test="${not empty param.addWishList}">
							<p class="text-info">Cannot Move Product to Wishlist</p>
						</c:if>
					</div>
				</div>
			</div>
		</section>
		<footer>
			<%@include file="template/footer.jsp"%>
		</footer>
	</div>
</body>
</html>
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/bootstrap-min.js"></script>
<script src="resources/js/jquery-1.8.0.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
\
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
