<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd"> 

<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="title" /></title>
<link href="/todo/default.css" rel="stylesheet" type="text/css" >
<style type="text/css">
.error {
	color: red;
}
</style>

<link type="text/css"
	href="/todo/css/ui-lightness/jquery-ui-1.8.10.custom.css"
	rel="Stylesheet" >
<script type="text/javascript" src="/todo/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="/todo/js/jquery-ui-1.8.10.custom.min.js"></script>

</head>
<body>
	<div id="wrapper">
		<!-- start header -->
		<div id="logo">
			<h1>
				<a href="#"><fmt:message key="heading" /> </a>
			</h1>
		</div>
		<div id="header">
			<div id="menu">
			</div>
		</div>
		<!-- end header -->
		<div id="page">
			<!-- start content -->
			<div id="content">
				<div class="post">
				<p>You have been logged out.</p>
				</div>
			</div>
			<!-- end content -->
			<!-- start sidebar -->
			<div id="sidebar"></div>
			<!-- end sidebar -->
			<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end page -->
		<!-- start footer -->
		<div id="footer">
			<p id="legal">
				Emporium Template from <a href="http://www.freecsstemplates.org/preview/emporium/">freecsstemplates.org</a>.
			</p>
		</div>
	</div>
	<!-- end footer -->
</body>
</html>
