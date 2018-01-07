


<div class="form-group">
	<label for="price" class="col-sm-2 control-label">Chose Category</label>

	<div class="col-sm-10">

		<form:select multiple="true" path="chosedProductCategory">
			<form:options items="${categoryList}" itemValue="categoryId" itemLabel="name" />
		</form:select>

	</div>
</div>