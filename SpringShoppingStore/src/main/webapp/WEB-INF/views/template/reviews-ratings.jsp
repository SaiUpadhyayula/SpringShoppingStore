<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://onlinekart.com/commonFunctions" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Reviews & Ratings</h1>

	<c:forEach var="review" items="${customerReviews}">
		<c:url var="url" value="product">
			<c:param name="productId" value="${review.productId}" />
		</c:url>
		<div class="well">
			<a href="${url}">
				<h3>
					${f:getProductById(${review.productId})}
				</h3>
			</a>
			<h4>
				
			</h4>
			<p>
				<c:out value="${review.reviewText}" />
			</p>

		</div>
		<hr>
	</c:forEach>
</body>
</html>