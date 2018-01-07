<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>




<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">

			<c:if test="${not empty error}">
				<div class="alert alert-danger">
					<spring:message
						code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
				</div>
			</c:if>
			<form class="form-signin" role="form"
				action="<spring:url value="/j_spring_security_check"/>"
				method="POST">
				<h2 class="form-signin-heading">Please sign in</h2>
				<label for="inputEmail" class="sr-only">Email address</label> <input
					type="text" id="inputEmail" name="j_username" class="form-control"
					placeholder="username" required autofocus> <label
					for="inputPassword" class="sr-only">Password</label> <input
					type="password" name="j_password" id="inputPassword"
					class="form-control" placeholder="Password" required>
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
					in</button>
			</form>


		</div>
	</div>
</div>