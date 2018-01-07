<div class="block-title">
	<h1>Account Information</h1>
	<div class="form-group row">
		<div class="col-xs-3">
			<label for="ex1">Name</label> <input class="form-control" type="text"
				placeholder="Name" value="Jan">
		</div>
		<div class="col-xs-3">
			<label for="ex2">Surname</label> <input class="form-control"
				type="text" placeholder="Surname" value="Kowalski">
		</div>

	</div>

	<div class="form-group row">
		<div class="col-xs-6">
			<label for="ex1">Adres e-mail</label> <input class="form-control"
				placeholder="e-mail" value="mateusz123@gmail.com" type="text">
		</div>
	</div>


	<input type="checkbox" value="1" onclick="setPasswordForm(this.checked)" title="Change Password" />
		<label>Change password</label>

	<div class="change_password" style="display: none;">

		<div class="form-group row col-xs-7">
			<label class="sr-only">Current Password </label> <input
				type="password" class="form-control" placeholder="Current Password">
		</div>

		<div class="form-group row col-xs-7">
			<label class="sr-only">New Password </label> <input type="password"
				class="form-control" placeholder="New Password">
		</div>
		<div class="form-group row col-xs-7">
			<label class="sr-only">Confirm New Password </label> <input
				type="password" class="form-control"
				placeholder="Confirm New Password

">
			<button style="margin-top: 5px;" type="submit"
				class="btn btn-default">Save</button>

		</div>


	</div>

</div>