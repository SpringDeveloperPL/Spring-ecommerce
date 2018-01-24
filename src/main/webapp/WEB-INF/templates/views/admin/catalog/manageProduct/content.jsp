
<style>


.switch {
	position: relative !important;
	display: inline-block !important;
	width: 60px !important;
	height: 34px !important;
}

.switch input {
	display: none !important;
}

.okon {
	position: absolute !important;
	cursor: pointer !important;
	top: 0 !important;
	left: 0 !important;
	right: 0 !important;
	bottom: 0 !important;
	background-color: #ccc !important;
	-webkit-transition: .4s !important;
	transition: .4s !important;
}

.okon:before {
	position: absolute !important;
	content: "" !important;
	height: 26px !important;
	width: 26px !important;
	left: 4px !important;
	bottom: 4px !important;
	background-color: white !important;
	-webkit-transition: .4s !important;
	transition: .4s !important;
}

input:checked+.okon {
	background-color: #2196F3 !important;
}

input:focus+.okon {
	box-shadow: 0 0 1px #2196F3 !important;
}

input:checked+.okon:before {
	-webkit-transform: translateX(26px) !important;
	-ms-transform: translateX(26px) !important;
	transform: translateX(26px) !important;
}

.okon.round {
	border-radius: 34px !important;
}

.okon.round:before {
	border-radius: 50% !important;
}

.dataTableImg {
	width: 100px;
}
</style>
<section class="content-header">
	<h1>
		Manage Product <small>Product list</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
		<li class="active">Product</li>
	</ol>

</section>



<div class="containe-fluid">
		<div class="col-md-12 ">

			<a href="/dashboard/manageproduct/addProduct">
				<button class=" btn btn-md center-block btn pull-right"
					style="margin-top: 32px; color: white; border-radius: 0; background-color: #1d82f8;"
					type="submit">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					Add Product
				</button>
			</a>

		</div>
	<div class="row">

		<section class="content-header">

			<div class="col-xs-12">
				<table id="productListTable"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Image</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Actual Price</th>
							<th>Active</th>
							<th>Edit</th>


						</tr>
					</thead>

				</table>
			</div>

		</section>
		</div>
	</div>

</div>
