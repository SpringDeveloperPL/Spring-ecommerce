
<div class="form-group">
	<label for="price" class="col-sm-2 control-label">Price</label>

	<div class="col-sm-10">
		<form:input type="number" class="form-control" id="price" path="product.price"
			placeholder="Enter Price" />
	</div>
</div>

<div class="form-group">
	<label for="price" class="col-sm-2 control-label">Quentity</label>

	<div class="col-sm-10">
		<form:input type="number" class="form-control" id="price"
			path="product.quantity" placeholder="Enter Quantity" />
	</div>
</div>

<div class="form-group">
	<div class="col-sm-offset-2 col-sm-10">
		<div class="checkbox" >
			<label> <form:checkbox path="product.on_sale"  /> On Sale </label>
		</div>
	</div>
</div>

