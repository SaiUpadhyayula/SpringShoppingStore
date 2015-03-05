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
	<div class="col-sm-12 col-md-12">
		<div class="row">
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<c:if test="${not empty productsInWishList}">
						<thead>
							<th class="text-center">Product</th>
							<th class="text-center">Price</th>
							<th></th>
						</thead>
					</c:if>
					<tbody>
						<c:choose>
							<c:when test="${empty productsInWishList }">
								<tr>
									<c:url var="home" value="home" />
									<div style="text-align: center">
										<h4>Your Wishlist is Empty</h4>
										<a href="${home}" class="btn btn-info">Continue Shopping</a>
									</div>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="product" items="${productsInWishList}">
									<tr>
										<td class="col-sm-8 col-md-6">
											<div class="media">
												<a class="thumbnail pull-left" href="#"> <img
													class="media-object"
													src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png"
													style="width: 72px; height: 72px;">
												</a>
												<div class="media-body">
													<c:url var="products" value="product">
														<c:param name="productId" value="${product.productId}" />
													</c:url>

													<h4 class="media-heading">
														<a href="${products}"> <c:out value="${product.name}" /></a>
													</h4>
													<h5 class="media-heading">
														by
														<c:out value="${product.manufacturer}   " />
													</h5>
												</div>
											</div>
										</td>
										<td class="col-sm-1 col-md-1 text-center"><strong>Rs.<c:out
													value="${product.price}" /></strong></td>
										<c:url var="moveToCart" value="moveToCart">
											<c:param name="productId" value="${product.productId}" />
										</c:url>
										<c:url var="removeFromWishList" value="removeFromWishList">
											<c:param name="productId" value="${product.productId}" />
										</c:url>
										<td><a href="${moveToCart}" type="button"
											class="btn btn-success">Move To Cart</a> <a
											href="${removeFromWishList}" type="button"
											class="btn btn-danger">Remove</a></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>