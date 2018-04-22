<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
	<div class="jumbotron">
		<div class="container">
			<h1>Products</h1>
		</div>
	</div>

	<div class="row">
		<c:forEach var="product" items="${productCategoryList}">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<img src="/resources/productImages/${product.imageName}"
						alt="image" width="200" height="200" />
					<div class="caption">
						<h3>${product.name}</h3>
						<p>${product.description}</p>
					
						<strong> Time to End: </strong> <span class="label label-primary"
							style="font-size: 14px;">${product.auctionEndDate} </span>
						<p></p>
						<p>
							<strong> Bidders: </strong> ${product.price}  customer are bidding
						</p>
						<p>
							<strong>Actual Price </strong> ${product.bidAmout}&dollar;
						</p>
						<p>
							<strong>Unit in Stack </strong> ${product.quantity}
						</p>

						<p></p>
						<p>
							<a
								href=" <spring:url value="/category/product?id=${product.productId}" /> "
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> Details
							</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>