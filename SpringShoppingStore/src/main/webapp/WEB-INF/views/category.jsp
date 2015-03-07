<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Home | E-Shopper</title>
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
</head>
<!--/head-->

<body>
	<header id="header">
		<%@include file="template/header.jsp"%>
	</header>
	<!--/header-->
	<section>
		<div class="container">
			<div class="row">
				<div class="padding-right">
					<div class="features_items">
						<c:choose>
							<c:when test="${empty subCatProds}">
								<c:forEach var="catProds" items="${catProds}">
									<c:url var="url" value="product">
										<c:param name="productId" value="${catProds.productId}" />
									</c:url>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="resources/images/home/${catProds.productId}.jpg"
														alt="" /> <a href="${url}">
														<h2>
															<c:out value="${catProds.name}" />
														</h2>
													</a>
													<p>
														Rs.
														<c:out value="${catProds.price}" />
													</p>
													<c:url var="add" value="/addProduct">
														<c:param name="productId" value="${catProds.productId}" />
													</c:url>
													<a href="${url}" class="btn btn-default add-to-cart"><i
														class="fa fa-shopping-cart"></i>Add to cart</a>
												</div>
												<div class="product-overlay">
													<div class="overlay-content">
														<a href="${url}">
															<h2>
																<c:out value="${catProds.name}" />
															</h2>
														</a>
														<p>
															Rs.
															<c:out value="${catProds.price}" />
														</p>
														<c:url var="add" value="/addProduct">
															<c:param name="productId" value="${catProds.productId}" />
														</c:url>
														<a href="${url}" class="btn btn-default add-to-cart"><i
															class="fa fa-shopping-cart"></i>Add to cart</a>
													</div>
												</div>
											</div>
											<div class="choose">
												<ul class="nav nav-pills nav-justified">
													<li><a href="#"><i class="fa fa-plus-square"></i>Add
															to wishlist</a></li>
													<li><a href="#"><i class="fa fa-plus-square"></i>Add
															to compare</a></li>
												</ul>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:if test="${not empty subCatProds}"></c:if>
								<c:forEach var="subCatProds" items="${subCatProds}">
									<c:url var="url" value="product">
										<c:param name="productId" value="${subCatProds.productId}" />
									</c:url>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img
														src="resources/images/home/${subCatProds.productId}.jpg"
														alt="" /> <a href="${url}">
														<h2>
															<c:out value="${subCatProds.name}" />
														</h2>
													</a>
													<p>
														Rs.
														<c:out value="${subCatProds.price}" />
													</p>
													<c:url var="add" value="/addProduct">
														<c:param name="productId" value="${subCatProds.productId}" />
													</c:url>
													<a href="${url}" class="btn btn-default add-to-cart"><i
														class="fa fa-shopping-cart"></i>Add to cart</a>
												</div>
												<div class="product-overlay">
													<div class="overlay-content">
														<a href="${url}">
															<h2>
																<c:out value="${subCatProds.name}" />
															</h2>
														</a>
														<p>
															Rs.
															<c:out value="${subCatProds.price}" />
														</p>
														<c:url var="add" value="/addProduct">
															<c:param name="productId"
																value="${subCatProds.productId}" />
														</c:url>
														<a href="${url}" class="btn btn-default add-to-cart"><i
															class="fa fa-shopping-cart"></i>Add to cart</a>
													</div>
												</div>
											</div>
											<div class="choose">
												<ul class="nav nav-pills nav-justified">
													<li><a href="#"><i class="fa fa-plus-square"></i>Add
															to wishlist</a></li>
													<li><a href="#"><i class="fa fa-plus-square"></i>Add
															to compare</a></li>
												</ul>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</section>

	<footer id="footer">
		<!--Footer-->

		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights
						reserved.</p>
					<p class="pull-right">
						Designed by <span><a target="_blank"
							href="http://www.themeum.com">Themeum</a></span>
					</p>
				</div>
			</div>
		</div>

	</footer>
	<!--/Footer-->



	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.scrollUp.min.js"></script>
	<script src="resources/js/price-range.js"></script>
	<script src="resources/js/jquery.prettyPhoto.js"></script>
	<script src="resources/js/main.js"></script>
</body>
</html>