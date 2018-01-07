<%@page import="com.ecommerce.category.service.CategoryService"%>
<%@page import="com.ecommerce.category.service.CategoryServiceImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page import="com.ecommerce.*"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.web.servlet.support.RequestContextUtils"%>

<%
	ApplicationContext applicationContext = RequestContextUtils.getWebApplicationContext(request);
	CategoryService categoryService = (CategoryService) applicationContext.getBean("categoryService");
%>


<style>
<!--



.menu-large {
	position: static !important;
}

.megamenu {
	padding: 20px 0px;
	width: 100%;
}

.megamenu>li>ul {
	padding: 0;
	margin: 0;
}

.megamenu>li>ul>li {
	list-style: none;
}

.megamenu>li>ul>li>a {
	display: block;
	padding: 3px 20px;
	clear: both;
	font-weight: normal;
	line-height: 1.428571429;
	white-space: normal;
}

.megamenu>li ul>li>a:hover, .megamenu>li ul>li>a:focus {
	text-decoration: none;
	color: #262626;
	background-color: #f5f5f5;
}

.megamenu.disabled>a, .megamenu.disabled>a:hover, .megamenu.disabled>a:focus
	{
	color: #999999;
}

.megamenu.disabled>a:hover, .megamenu.disabled>a:focus {
	text-decoration: none;
	background-color: transparent;
	background-image: none;
	filter: progid:DXImageTransform.Microsoft.gradient(enabled= false);
	cursor: not-allowed;
}

.megamenu.dropdown-header {
	color: #428bca;
	font-size: 18px;
}

@media ( max-width : 768px) {
	.megamenu {
		margin-left: 0;
		margin-right: 0;
	}
	.megamenu>li {
		margin-bottom: 30px;
	}
	.megamenu>li:last-child {
		margin-bottom: 0;
	}
	.megamenu.dropdown-header {
		padding: 3px 15px !important;
	}
	.navbar-nav .open .dropdown-menu .dropdown-header {
		color: #fff;
	}
}
-->
</style>

<div class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">

				<c:forEach var="category"
					items="<%=categoryService.findAllCategory()%>">
					<c:if test="${category.parent == 1}">
						<li class="dropdown menu-large"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown">
								${category.name} <b class="caret"></b>
						</a>
							<ul class="dropdown-menu megamenu row">
								<li class="col-sm-3">
									<ul>
										<c:forEach var="childCategory"
											items="<%=categoryService.findAllCategory()%>">
											<c:if test="${category.categoryId == childCategory.parent}">

												<li class="dropdown-header"></li>
												<li><a href="/category/${childCategory.name}">${childCategory.name}</a></li>
											</c:if>
										</c:forEach>
									</ul>
							</ul></li>


						</li>
					</c:if>
				</c:forEach>
			</ul>

		</div>
	</div>
</div>