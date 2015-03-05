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
	<div class="col-md-12">
		<div class="row">
			<div class="table-responsive">
				<h1>Order Information</h1>
				<legend>
					<c:out value="Order Number: ${order.orderId}" />
				</legend>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Product</th>
							<th>Price</th>
							<th>Order Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${orderItemsList}">
							<tr>
								<td class="col-sm-8 col-md-6">
									<div class="media">
										<a class="thumbnail pull-left" href="#"> <img
											class="media-object"
											src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png"
											style="width: 72px; height: 72px;">
										</a>
										<div class="media-body">
											<h4 class="media-heading">
												<c:out value="${product.name}" />
											</h4>
											<h5 class="media-heading">
												by
												<c:out value="${product.manufacturer}   " />
											</h5>
											<span>Status: </span><span class="text-success"><strong>In
													Stock</strong></span>
										</div>
									</div>
								</td>
								<td><strong><c:out value="Rs.${product.price}" /></strong></td>
								<td><strong><c:out value="${order.orderStatus}" /></strong></td>

							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td><strong><c:out
										value="Total:${order.orderTotal}" /></strong></td>
						</tr>
					</tbody>
				</table>
				<h1>Address Details</h1>
				<hr>
				<div>
					<strong>Name:</strong>
					<c:out value="${addressDetails.fullName}" />
					</br> <strong>Address1:</strong>
					<c:out value="${addressDetails.address1}" />
					</br> <strong>Address2:</strong>
					<c:out value="${addressDetails.address2}" />
					</br> <strong>City:</strong>
					<c:out value="${addressDetails.city}" />
					</br> <strong>Zip:</strong>
					<c:out value="${addressDetails.zipCode}" />
					</br> <strong>State:</strong>
					<c:out value="${addressDetails.state}" />
					</br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>