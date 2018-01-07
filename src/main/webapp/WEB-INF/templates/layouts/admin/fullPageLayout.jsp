<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


<html>

<head>
<title><t:insertAttribute name="title" /></title>
<t:insertAttribute name="header" />
<t:insertAttribute name="customHeader" />


</head>

<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">

		<t:insertAttribute name="topmenu" />
		<t:insertAttribute name="sidebar" />
		<div class="content-wrapper">
			<t:insertAttribute name="content" />
		</div>
	</div>
	<t:insertAttribute name="footer" />
	<t:insertAttribute name="footerScripts" />


</body>
</html>