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
				<h1>Order Infomration</h1>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<th>Order Id</th>
						<th>Created Date</th>
						<th>Order Status</th>
						<th>Order Total</th>
					</thead>
					<tbody>
						<c:forEach var="orders" items="${orderList}">
							<tr>
								<c:url var="orderDetail" value="orderDetail">
									<c:param name="id" value="${orders.orderId}" />
								</c:url>
								<td><a href="${orderDetail}"><c:out
											value="${orders.orderId}" /></a></td>
								<td><c:out value="${orders.createdDate}" /></td>
								<td><c:out value="${orders.orderStatus}" /></td>
								<td><c:out value="Rs.${orders.orderTotal}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>