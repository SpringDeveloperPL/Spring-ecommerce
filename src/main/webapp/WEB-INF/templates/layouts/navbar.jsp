<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<header id="fh5co-header" role="banner">

</div>
Language:

	<a href="?language=pl" >polski</a> |
 	<a href="?language=pl" >anglieski</a>


	<nav class="navbar navbar-default navbar-custom" role="navigation">

		<div class="container-fluid">

			<div class="navbar-header">


				<!-- Mobile Toggle Menu Button -->
				<a href="#"
					class="js-fh5co-nav-toggle fh5co-nav-toggle visible-xs-block"
					data-toggle="collapse" data-target="#fh5co-navbar"
					aria-expanded="false" aria-controls="navbar"><i></i></a> <a
					class="navbar-brand" href="/">Booster</a>
			</div>
			<div id="fh5co-navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="index.html"><span>Home
								<span class="border"></span>
						</span></a></li>
					<li><a href="right-sidebar.html"><span>Right
								Sidebar <span class="border"></span>
						</span></a></li>
					<li><a href="left-sidebar.html"><span>Left Sidebar
								<span class="border"></span>
						</span></a></li>

						<sec:authorize access="hasRole('ROLE_CUSTOMER')">
							<li><a href="/customer-account"><span> <span
								class="glyphicon glyphicon-user"></span><sec:authentication property="name"/> <span
								class="border"></span></span></a></li>
					<li><a href="logout"><span> <span
								class="glyphicon glyphicon-align-left"></span>
								</button> Sign out <span class="border"></span></span></a></li>

						</sec:authorize>
<sec:authorize access="isAnonymous() or hasRole('ROLE_ADMIN')">

					<li><a href="/customer-account"><span> <span
								class="glyphicon glyphicon-user"></span> Sign In <span
								class="border"></span></span></a></li>
					<li><a href="registration"><span> <span
								class="glyphicon glyphicon-align-left"></span>
								</button> Registarion <span class="border"></span></span></a></li>

</sec:authorize>


				</ul>
			</div>
		</div>
	</nav>
</header>