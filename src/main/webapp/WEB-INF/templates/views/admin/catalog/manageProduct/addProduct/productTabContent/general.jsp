

<div class="form-group">
	<label for="inputName" class="col-sm-2 control-label">Name</label>

	<div class="col-sm-10">
		<form:input type="text" class="form-control" id="inputName"
			path="product.name" placeholder="Enter Name" />
	</div>
</div>
<div class="form-group">
	<label for="description" class="col-sm-2 control-label">Description</label>

	<div class="col-sm-10">
		<form:textarea class="form-control" id="description"
			path="product.longDescription" placeholder="Enter Description" />
	</div>
</div>
<div class="form-group">
	<label for="product.shortDescription" class="col-sm-2 control-label">Short
		description</label>

	<div class="col-sm-10">
		<form:textarea class="form-control" id="shortDescription"
			path="product.description" placeholder="Enter Short description" />
	</div>
</div>
<div class="form-group">
	<label for="product.sku" class="col-sm-2 control-label">SKU</label>

	<div class="col-sm-10">
		<form:input type="text" class="form-control" id="sku" path="product.sku"
			placeholder="Enter SKU" />
	</div>
</div>



<div class="form-group">
	<label for="weight" class="col-sm-2 control-label">Weight</label>

	<div class="col-sm-10">
		<form:input type="number" class="form-control" id="weight" path="product.weight"
			placeholder="Enter Weight" />
	</div>
</div>

<div class="form-group">
	<label for="urlKey" class="col-sm-2 control-label">URL Key</label>

	<div class="col-sm-10">
		<form:input type="text" class="form-control" id="urlKey" path="product.url"
			placeholder="Enter URL Key" />
	</div>
</div>



	<div class="form-group">
		<label for="urlKey" class="col-sm-2 control-label">Tax</label>

		<div class="col-sm-10">
			<form:select path="taxID">
				<form:options type="number" items="${taxList}" itemValue="taxId" itemLabel="name" ></form:options>
			</form:select>

		</div>
	</div>
	
		<div class="form-group">
		<label for="urlKey" class="col-sm-2 control-label">Manufacturer</label>

		<div class="col-sm-10">
			<form:select path="manufacturerID">
				<form:options type="number" items="${manufacturerList}" itemValue="manufacturerId" itemLabel="name" ></form:options>
			</form:select>

		</div>
	</div>
	<div class="form-group">
	<div class="col-sm-offset-2 col-sm-10">
		<div class="checkbox" >
			<label> <form:checkbox path="product.active"  /> Is Active </label>
		</div>
	</div>
</div>
	 <%-- 
<div class="form-group">
	<label for="urlKey" class="col-sm-2 control-label">Manufacturer</label>

	<div class="col-sm-10">

		<c:if test="${not empty manufacturerList}">
			<select class="form-control">

				<c:forEach var="manufacturer" items="${manufacturerList}">
					<option>${manufacturer}</option>
				</c:forEach>
			</select>
		</c:if>
	</div>
</div>
 --%> <!-- 
<div class="form-group">
	<label for="urlKey" class="col-sm-2 control-label">Active</label>
	<div class="col-sm-10">

		<select class="form-control">
			<option>----Chose Option----</option>
			<option>Enabled</option>
			<option>Disabled</option>

		</select>
	</div>
</div>
 -->
	