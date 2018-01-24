<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style>
span .glyphicon {
	color: black;
}

.glyphicon {
	margin-right: 15px;
}

.block-title {
	margin: 10px;
}

.customStyleRow {
	background-color: #f0ad4e;
}

.list-group-item.active, .list-group-item.active:focus, .list-group-item.active:hover
	{
	background-color: #f0ad4e;
	border-color: #eea236;
	color: black;
}

}
</style>




<div class="container">

	<div class="container">
		<div class="row customStyleRow"
			 style="background-color: #f0ad4e; color: #ffff;">
			<div class="block-title">
				<strong><span style="font-size: 20px;">Customer
						Panel</span></strong>
			</div>

		</div>
	</div>

	<div class="row">
		<div class="col-md-3" style="margin-top: 2%; padding: 0px;">
			<div class="block-title">
				<strong><span>My Account</span></strong>
			</div>

			<div class="list-group">
				<div class="tabs">
					<a href="#accountDashboard" class="list-group-item active"> <span
							class="glyphicon glyphicon-user" aria-hidden="true"></span>
						Account Dashboard
					</a> <a href="#accountInformation" class="list-group-item"> <span
						class="glyphicon glyphicon-info-sign
					" aria-hidden="true"></span>Account
					Information
				</a> <a href="#adressBook" class="list-group-item"> <span
						class="glyphicon glyphicon-book

					" aria-hidden="true"></span>
					Adress Book
				</a> <a href="#myBidding" class="list-group-item"> <span
						class="glyphicon glyphicon-shopping-cart

					"
						aria-hidden="true"></span> My Bidding
				</a> <a href="#transactions" class="list-group-item"> <span
						class="glyphicon glyphicon-eur

					" aria-hidden="true"></span>

					Transactions
				</a> <a href="#transactions" class="list-group-item"> <span
						class="glyphicon glyphicon-envelope


					"
						aria-hidden="true"></span> Message Center <span class="badge">3</span>
				</a>
				</div>
			</div>
		</div>



		<script type="text/javascript">
			$(function() {

				jQuery.noConflict();
				$(".tab").hide();

				$(".tabs").find("a").on('click', function(e) {
					$(".tabs").find(".active").removeClass("active");
					$(this).addClass("active");
					e.preventDefault();
					$(this.hash).show().siblings().hide();
				}).first().click();

			});

			function setPasswordForm(checked) {
				if (checked) {
					$(".change_password").fadeIn();
				} else
					$(".change_password").fadeOut();
			}
		</script>




		<div class="tab-content">


			<div class="tab" id="accountDashboard">

				<div class="col-md-9 col-md">

					<%@ include
					file="/WEB-INF/templates/views/customerAccount/panelTabs/accountDashboard.jsp"%>

				</div>
			</div>


			<div class="tab" id="accountInformation">

				<div class="col-md-9 col-md">

					<%@ include
					file="/WEB-INF/templates/views/customerAccount/panelTabs/accountInformation.jsp"%>


				</div>
			</div>
			<div class="tab" id="adressBook">

				<div class="col-md-8 col-md">


					<%@ include
					file="/WEB-INF/templates/views/customerAccount/panelTabs/adressBook.jsp"%>
				</div>
			</div>
			<div class="tab" id="myBidding">
				<diWv class="col-md-9 col-md">
					<div class="block-title">
						<h1>My Bidding</h1>

						<table class="table table-hover">
							<thead>
							<tr>
								<th>Image</th>
								<th>Product Name</th>
								<th>Bidders</th>
								<th>Date</th>
								<th>Actual Price</th>
								<th>Message</th>
								<th>Link</th>
							</tr>
							</thead>
								<tbody>
									<style>
									#hoverAuction  a:hover{
									color:#f0ad4e;
									font-weight:normal;
									}</style>
							<c:forEach var="entry" items="${auctionMessageMap}" varStatus="status">

								<tr>
									 Go to Auction </a>

									<td><img src="/resources/productImages/${entry.key.imageName}" alt="image" width="100" height="100"> </td>
									<td>${entry.key.name}</td>
									<td>${entry.key.price} people</td>
									<td>${entry.value.date}</td>
									<td>${entry.key.bidAmout}</td>
									<th>${entry.value.systemMessage}</th>
									<th id="hoverAuction"><a href="<spring:url value="/category/product?id=${entry.key.productId}"/>">Auction Link</a></th>

								</tr>

							</c:forEach>

							</tbody>

						</table>


					</div>
				</diWv>

			</div>
			<div class="tab" id="transactions">
				<div class="col-md-9 col-md">
					<div class="block-title">
						<h1>Message Center</h1>
						<p>

					</div>



					</p>
				</div>
			</div>
		</div>

	</div>

</div>
</div>


