<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="resources/css/bootstrap.css" />
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/jquery-1.8.0.js"></script>
<style>
.glyphicon {
	margin-right: 5px;
}
.thumbnail {
	margin-bottom: 20px;
	padding: 0px;
	-webkit-border-radius: 0px;
	-moz-border-radius: 0px;
	border-radius: 0px;
}
.item.list-group-item {
	float: none;
	width: 100%;
	background-color: #fff;
	margin-bottom: 10px;
}
.item.list-group-item:nth-of-type(odd):hover,.item.list-group-item:hover
	{
	background: #428bca;
}
.item.list-group-item .list-group-image {
	margin-right: 10px;
}
.item.list-group-item .thumbnail {
	margin-bottom: 0px;
}
.item.list-group-item .caption {
	padding: 9px 9px 0px 9px;
}
.item.list-group-item:nth-of-type(odd) {
	background: #eeeeee;
}
.item.list-group-item:before,.item.list-group-item:after {
	display: table;
	content: " ";
}
.item.list-group-item img {
	float: left;
}
.item.list-group-item:after {
	clear: both;
}
.list-group-item-text {
	margin: 0 0 11px;
}
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
	background-color: white;
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
#well {
	margin-top: 20px;
	text-align: justify;
}
</style>
</head>
<body>
	<div class="container">
		<header>
			<%@include file="template/header.jsp"%>
		</header>
		<section>
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="carousel slide" id="theCarousel" data-interval="2000">

							<ol class="carousel-indicators">
								<li data-target="#theCarousel" data-slide-to="0" class="active"></li>
								<li data-target="#theCarousel" data-slide-to="1"></li>
								<li data-target="#theCarousel" data-slide-to="2"></li>
							</ol>

							<div class="carousel-inner">
								<div class="item active">
									<img src="resources/vibe.jpg" alt="1" class="img-responsive" />
									<div class="carousel-caption"></div>
								</div>
								<div class="item">
									<img src="resources/Asus.jpg" alt="2" class="img-responsive" />
									<div class="carousel-caption"></div>
								</div>
								<div class="item">
									<img src="resources/micromax.jpg" alt="3"
										class="img-responsive" />
									<div class="carousel-caption"></div>
								</div>
							</div>

							<a href="#theCarousel" class="carousel-control left"
								data-slide="prev"><span class="icon-prev"></span></a> <a
								href="#theCarousel" class="carousel-control right"
								data-slide="next"><span class="icon-next"></span></a>
						</div>
					</div>
				</div>
				<div id="well" class="well well-sm">
					<strong>Category Title</strong>
					<div class="btn-group">
						<a href="#" id="list" class="btn btn-default btn-sm"><span
							class="glyphicon glyphicon-th-list"> </span>List</a> <a href="#"
							id="grid" class="btn btn-default btn-sm"><span
							class="glyphicon glyphicon-th"></span>Grid</a>
					</div>
				</div>
				<div id="products" class="row list-group">
					<c:forEach var="featProds" items="${featProd}">
						<c:url var="url" value="product">
							<c:param name="productId" value="${featProds.productId}" />
						</c:url>
						<div class="item  col-xs-4 col-lg-4">
							<div class="thumbnail">
								<img class="group list-group-image"
									src="resources/images/home/${featProds.productId}.jpg" alt="" />
								<div class="caption">
									<h4 class="group inner list-group-item-heading">
										<a href="${url}"><c:out value="${featProds.name}" /></a>
									</h4>
									<p class="group inner list-group-item-text">
										<c:out value="${featProds.manufacturer}" />
									</p>
									<p class="group inner list-group-item-text">Product
										description... Lorem ipsum dolor sit amet, consectetuer
										adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
										laoreet dolore magna aliquam erat volutpat.</p>
									<div class="row">
										<div class="col-xs-12 col-md-6">
											<p class="lead">
												Rs.
												<c:out value="${featProds.price}" />
											</p>
										</div>
										<c:url var="add" value="/addProduct">
											<c:param name="productId" value="${featProds.productId}" />
										</c:url>
										<div class="col-xs-12 col-md-6">
											<a class="btn btn-success" href="${add}">Add to cart</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
		<footer>
			<%@include file="template/footer.jsp"%>
		</footer>
	</div>
</body>
</html>
<script>
	$(document).ready(function() {
		$('#list').click(function(event) {
			event.preventDefault();
			$('#products .item').addClass('list-group-item');
		});
		$('#grid').click(function(event) {
			event.preventDefault();
			$('#products .item').removeClass('list-group-item');
			$('#products .item').addClass('grid-group-item');
		});
	});
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