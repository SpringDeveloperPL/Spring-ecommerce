<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>



<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">

			<c:if test="${param.success eq true }">
				<div class="alert alert-success">
					<strong>Registration Success!</strong>
				</div>
			</c:if>

			<sf:form modelAttribute="registerCustomerForm"
				cssClass="form-horizontal registrationForm" method="POST" action="">

				<div class="form-group ">
				

						<sf:input  path="customer.userName" cssClass="form-control" type="text"
							placeholder="Username"   />
				
					<sf:errors  path="customer.userName" cssClass="bg-danger" />

				</div>


				<div class="form-group ">
				

						<sf:input name="emailAdress" path="customer.emailAdress"
							class="form-control" placeholder="Email" />
								
					<sf:errors path="customer.emailAdress"  cssClass="bg-danger" />

				</div>

				<div class="form-group ">
					
						<sf:input id="password" path="password" name="password"
							type="password" class="form-control" placeholder="Password" />
					
					<sf:errors path="customer.password"  cssClass="bg-danger" />
				</div>

				<div class="form-group ">
					
					
						<sf:input path="passwordConfirm" type="password"
							class="form-control" placeholder="Confirm Password" />
			
					
					<sf:errors path="passwordConfirm"  cssClass="bg-danger" />

				</div>

				<input type="submit" value="Register"
					class="btn btn-success btn-custom">

			</sf:form>
		</div>
	</div>
</div>


<script type="text/javascript"
	src="//ajax.aspnetcdn.com/ajax/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {

				$(".registrationForm").validate(

						{
							rules : {
							"customer.userName" : {
									required : true,
									minlength : 3
								},
								"customer.emailAdress": {
								      required: true,
								      email: true
								    },
								password : {
									required : true,
									minlength : 6
								},
								passwordConfirm : {
									required : true,
									equalTo : "#password"
								}
							},


							highlight : function(element) {
								$(element).closest('.form-group').removeClass(
										'has-success').addClass('has-error');
							},
							unhighlight : function(element) {
								$(element).closest('.form-group').removeClass(
										'has-error').addClass('has-success');
							}

						});
			});
</script>
 
