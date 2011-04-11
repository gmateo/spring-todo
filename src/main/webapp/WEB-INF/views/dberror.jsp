<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
<link href="/todo/default.css" rel="stylesheet" type="text/css" />
<link type="text/css"
	href="/todo/css/ui-lightness/jquery-ui-1.8.10.custom.css"
	rel="Stylesheet" />
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
				<ul>
					<li class="current_page_item"><a href="items.htm">Homepage</a>
					</li>
					<li class="last"><a href="addItem.htm">Add Item</a></li>
				</ul>
			</div>
		</div>
		<!-- end header -->
		<div id="page">
			<!-- start content -->
			<div id="content">
				<div class="post">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
							<p>
								<span class="ui-icon ui-icon-alert"
									style="float: left; margin-right: .3em;"></span> <strong>Error:</strong>
								Cannot connect to the database.
							</p>
						</div>
					</div>
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
		<!-- end footer -->
</body>
</html>
