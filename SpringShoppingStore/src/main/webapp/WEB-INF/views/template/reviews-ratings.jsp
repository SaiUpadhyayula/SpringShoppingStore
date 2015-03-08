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

	<c:forEach var="entry" items="${customerReviews}">
		<c:set var="product" value="${entry.key}" />
		<c:set var="review" value="${entry.value}" />
		<c:url var="url" value="product">
			<c:param name="productId" value="${product.productId}" />
		</c:url>
		<c:set var="productId" value="${product.productId}" />
		<div class="well">
			<a href="${url}">
				<h3>
					<c:out value="${product.name}" />
				</h3>
			</a>
			<h4>
				Title:
				<c:out value="${review.reviewTitle}" />
			</h4>
			<p>
				Review:
				<c:out value="${review.reviewText}" />
			</p>
			<p>
				Rating:
				<c:out value="${review.rating}" />
			</p>

		</div>
		<hr>
	</c:forEach>
</body>
</html>