
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<script>
	
	window.contextRoot = '${contextRoot}'
	
</script>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
		src="${pageContext.servletContext.contextPath}/resources/dataTables/datatables.js"
		type="text/javascript">

</script>
<script
		src="${pageContext.servletContext.contextPath}/resources/dataTables/jquery.dataTables.js"
		type="text/javascript">

</script>

<script
		src="${pageContext.servletContext.contextPath}/resources/js/bootbox.min.js"
		type="text/javascript">

</script>

<link rel="stylesheet"
	  href="${pageContext.servletContext.contextPath}/resources/dataTables/datatables.css" />



<link type="image/x-icon" rel="shortcut icon"
	  href="<c:url value="/resources/treeCatalog/favicon.png"/>">


<link rel="stylesheet"
	  href="<c:url value="/resources/treeCatalog/style.min.css"/>" />


<link media="all" type="text/css" rel="stylesheet"
	  href="<c:url value="/resources/treeCatalog/jsfiler.css"/>">
<script
		src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"/>"></script>
<script src="<c:url value="/resources/treeCatalog/jsfiler.js"/>"
	type="text/javascript"></script>




<script type="text/javascript">
	//code for dataTables
	//dataset
	$(function() {
		
		//If checkbox is findied and cheched call function
		// list of all products for admin
		var $productListTable = $('#productListTable');

		if ($productListTable.length) {

			//var jsonUrl = window.contextRoot +'/json/products';
		//	var jsonUrl = 'http://localhost:8080/dashboard/manageproduct/json/products';

			$productListTable
					.DataTable({
						lengthMenu : [
								[ 10, 30, 50, -1 ],
								[ '10 Records', '30 Records', '50 Records',
										'ALL' ] ],
						pageLength : 30,
						ajax : {
							url : 'http://localhost:8080/dashboard/manageproduct/json/products',
							dataSrc : ''
						},
						columns : [
								{
									data : 'productId'
								},

								{
									data : 'imageName',
									bSortable : false,
									mRender : function(data, type, row) {
										return '<img src="'	+ '/resources/productImages/'+data+ '" class="dataTableImg"/>';
									}
								},
								{
									data : 'name'
								},							
								{
									data : 'quantity',
									mRender : function(data, type, row) {

										if (data < 1) {
											return '<span style="color:red">Out of Stock!</span>';
										}

										return data;

									}
								},
								{
									data : 'bidAmout',
									mRender : function(data, type, row) {
										return '&dollar; ' + data
									}
								},
								{
									data : 'active',
									bSortable : false,
									mRender : function(data, type, row) {
										var str = '';

										if (data) {
											str += '<label class="switch"> <input type="checkbox" value="'+row.productId+'" checked="checked"/>  <div class="okon round"> </div></label>';

										} else {
											str += '<label class="switch"> <input type="checkbox" value="'+row.productId+'"/>  <div class="okon round"> </div></label>';
										}

										return str;
									}
								},
								{
									data : 'productId',
									bSortable : false,
									mRender : function(data, type, row) {

										var str = '';
										str += '<a href="'
												+ '/dashboard/manageproduct'
												+ '/manage/'
												+ data
												+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';

										return str;
									}
								} ],

						initComplete : function() {
							var api = this.api();
							api
									.$('.switch input[type="checkbox"]')
									.on(
											'change',
											function() {
												var dText = (this.checked) ? 'You want to activate the Product?'
														: 'You want to de-activate the Product?';
												var checked = this.checked;
												var checkbox = $(this);
												debugger;
												bootbox
														.confirm({
															size : 'medium',
															title : 'Product Activation/Deactivation',
															message : dText,
															callback : function(
																	confirmed) {
																if (confirmed) {
																	$
																			.ajax({
																				type : 'GET',
																				url : window.contextRoot
																						+ '/dashboard/manageproduct/json/'
																						+ checkbox
																								.prop('value')
																						+ '/activation',
																				timeout : 100000,
																				success : function(
																						data) {
																					bootbox
																							.alert(data);
																				},
																				error : function(
																						e) {
																					bootbox
																							.alert('ERROR: '
																									+ e);
																					//display(e);
																				}
																			});
																} else {
																	checkbox
																			.prop(
																					'checked',
																					!checked);
																}
															}
														});
											});

						}
					});
		}

	});

	
</script>