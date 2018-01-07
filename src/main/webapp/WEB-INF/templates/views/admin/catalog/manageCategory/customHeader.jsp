
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>




<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<!--

//-->

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
              <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
              <![endif]-->
<!-- Custom styles for this template -->


<link type="image/x-icon" rel="shortcut icon"
	href="<c:url value="/resources/treeCatalog/favicon.png"/>">


<link rel="stylesheet"
	href="<c:url value="/resources/treeCatalog/style.min.css"/>" />

<link media="all" type="text/css" rel="stylesheet"
	href="<c:url value="/resources/treeCatalog/jsfiler.css"/> ">
<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"/>"></script>
<script src="<c:url value="/resources/treeCatalog/jsfiler.js"/>"


	type="text/javascript"></script>
<style type="text/css">
body {
	
	
}

.shell {
	width: 100%;
	border: 0px solid #000000;
}

.shell a, shell a:link, shell a:visited, shell td a, shell td a:link,
	shell td a:visited {
	text-decoration: none;
	color: #666666;
}

.shell a:hover {
	text-decoration: none;
	color: #000000;
}

.head {
	border-bottom: 1px solid #A0A0A0;
	font-size: 14px;
	height: 27px;
}

.menu {
	margin-left: 10px;
	padding-top: 5px;
	float: left;
}

.menu a {
	margin-left: 5px;
}

.sign {
	float: right;
	margin-right: 20px;
}

.content {
	clear: both;
	margin-right: 50px;
	padding: 20px 20px 20px 20px;
	font-size: 12px;
}
</style>
<script type="text/javascript">
	$(document).ready(
			function() {
				/**
				 * set menu type
				 * @param {string} key name
				 * @return {object} 
				 */
				var Menu = function(key) {
					var p = new RegExp(key + "=([^&]*)", "i")
							.exec(window.location.search); //get URL parameter
					p = p && p[1] ? p[1] : 'rm';
					var m = 0;
					if (p.indexOf('r') + 1) {
						m += 1;
					}
					if (p.indexOf('m') + 1 || p.indexOf('n') + 1) {
						m += 2;
					}
					var r = {
						mode : m
					};
					r.main = (p.indexOf('m') === -1) ? '' : '.menu';//displaying no/classname
					return r;
				};

				var menu = Menu('mode'); //get menu type

				/* create the tree */
				$('#filer_0').jsfiler({
					menuMode : menu.mode,
					mainMenu : menu.main
				}); //activate
				$('#filer_0').jsfiler({
					knotRemove : 2
				});//adjust deletion mode
			});

	
</script>