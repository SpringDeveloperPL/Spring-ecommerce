<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.ecommerce.*"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@page import="com.ecommerce.category.service.CategoryService"%>
<%@page import="com.ecommerce.category.service.CategoryServiceImpl"%>
<%
	ApplicationContext applicationContext = RequestContextUtils.getWebApplicationContext(request);
	CategoryService categoryService = (CategoryService) applicationContext.getBean("categoryService");
%>



<section class="content-header">

	<h1>
		Add Product <small>Add New Product</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
		<li class="active">Add Product</li>
	</ol>
	<form:form modelAttribute="productForm" class="form-horizontal"
		method="POST" action="/dashboard/manageproduct/addProduct">

		<div class="form-group">
			<div class="col-sm-offset-10">
				<input type="submit" class="btn btn-default" value="Save" />
			</div>

		</div>
		<div class="row">
			<div class="col-md-12" style="margin-top: 30px;">
				<div class="nav-tabs-custom">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#activity" data-toggle="tab"
							aria-expanded="true">General</a></li>
						<li class=""><a href="#auction" data-toggle="tab"
										aria-expanded="false">Auctions</a></li>
						<li class=""><a href="#timeline" data-toggle="tab"
							aria-expanded="false">Prices</a></li>
						<li class=""><a href="#settings" data-toggle="tab"
							aria-expanded="false">Images</a></li>

						<li class=""><a href="#categories" data-toggle="tab"
							aria-expanded="false">Categories</a></li>
						</li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="activity">
							<%@ include	file="/WEB-INF/templates/views/admin/catalog/manageProduct/addProduct/productTabContent/general.jsp"%>

						</div>
						<div class="tab-pane" id="auction">
							<%@ include file="/WEB-INF/templates/views/admin/catalog/manageProduct/addProduct/productTabContent/auction.jsp"%>

						</div>
						<!-- /.tab-pane -->
						<div class="tab-pane" id="timeline">
							<%@ include file="/WEB-INF/templates/views/admin/catalog/manageProduct/addProduct/productTabContent/prices.jsp"%>

						</div>
						<!-- /.tab-pane -->

						<div class="tab-pane" id="settings">
							<%@ include file="/WEB-INF/templates/views/admin/catalog/manageProduct/addProduct/productTabContent/images.jsp"%>

						</div>



						<div class="tab-pane" id="categories">
							<%@ include file="/WEB-INF/templates/views/admin/catalog/manageProduct/addProduct/productTabContent/categories.jsp"%>

						</div>
						<!-- /.tab-pane -->
					</div>
					<!-- /.tab-content -->
				</div>
				<!-- /.nav-tabs-custom -->
			</div>
		</div>
	</form:form>
</section>
