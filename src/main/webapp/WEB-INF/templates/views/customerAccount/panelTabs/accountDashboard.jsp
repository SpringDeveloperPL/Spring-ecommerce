<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>




<style type="text/css">
.contentBox a:hover {
	color: #f0ad4e;
}

.box-tittle {
	background: #f1f1f1;
	padding: 2px 10px;
	margin: 0 0 12px;
}

.box-tittle a {
	float: right;
	color: #828282;
	font-size: 10px;
	text-transform: uppercase;
	outline: none;
	padding: 0px;
}

.table {
	font-size: 12px;
}
</style>

<span> <strong>Welcome, <sec:authentication
			property="name" />
</strong>
	<p>From your My Account Dashboard you have the ability to view a
		snapshot of your recent account activity and update your account
		information. Select a link below to view or edit information</p>


</span>

<div class="contentBox">

	<div class="row" style="padding-top:">

		<div class="col-md-4">
			<div class="box-tittle">
				Account Information <a
					href="http://wedson.pl/customer/account/edit/">Edit</a>
			</div>

			<p>
				${customer.userName}<br>${customer.emailAdress} <br> <a
					href="http://wedson.pl/customer/account/edit/changepass/1/">Change
					Password</a>
			</p>
		</div>

		<div class="col-md-8">
			<div class="box-tittle">
				Messages <a href="http://wedson.pl/customer/account/edit/">Message
					Center</a>
			</div>

				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				 You have <strong>3 new message</strong>

		</div>
	</div>

	<div class="row" style="padding-top: 4.5%;">

		<div class="col-md-4">
			<div class="box-tittle">
				Billing Adress <a href="http://wedson.pl/customer/account/edit/">Edit</a>
			</div>

			<div class="col-1">
				<address>
					You have not set a default billing address.<br> <a
						href="http://wedson.pl/customer/address/edit/">Edit Address</a>
				</address>
			</div>
		</div>


		<div class="col-md-8">
			<div class="box-tittle">
				Your won auctions
				<a href="http://wedson.pl/customer/account/edit/">View
					More</a>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Your Bidd</th>
						<th>Actual Price</th>
						<th>Time to End</th>
						<th>Bidders</th>
						<th>Move</th>


					</tr>
				</thead>
				<tbody>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td>John</td>
						<td>Doe</td>
						<td><a href="#">Go to Auction</a></td>
					</tr>
					<tr>
						<td>Mary</td>
						<td>Moe</td>
						<td>mary@example.com</td>
						<td>John</td>
						<td>Doe</td>
						<td><a href="#">Go to Auction</a></td>
					</tr>
					<tr>
						<td>July</td>
						<td>Dooley</td>
						<td>july@example.com</td>
						<td>John</td>
						<td>Doe</td>
						<td><a href="#">Go to Auction</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</div>