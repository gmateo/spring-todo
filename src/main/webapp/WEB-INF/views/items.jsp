<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd"> 
 <%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="title"/>
</title>
<link href="/todo/default.css" rel="stylesheet" type="text/css" >
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
					<li><a href="addItem.htm">Add Item</a>
					</li>
					<li class="last"><a href="j_spring_security_logout">Logout</a></li>
				</ul>                         
			</div>
		</div>
		<!-- end header -->
		<div id="page">
			<!-- start content -->
			<div id="content">
				<div class="post">
					<h1>
						<fmt:message key="items.heading" />
					</h1>
					<br />
					<table>
						<thead>
							<tr>
								<td><strong>description</strong></td>
								<td><strong>due date</strong></td>
								<td><strong>priority</strong></td>
							</tr>
						</thead>
						<c:forEach items="${model.items}" var="item">
							<tr>
								<td><c:out value="${item.description}" /></td>
								<td><fmt:formatDate value="${item.dueDate}" type="date"
										dateStyle="full" timeStyle="short" /></td>
								<td><c:out value="${item.priorityString}" /></td>
								<td><a
									href="updateItem.htm?itemId=<c:out value="${item.id}"/>"><fmt:message
											key="update" /> </a></td>
								<td><a
									href="deleteItem.htm?itemId=<c:out value="${item.id}"/>"><fmt:message
											key="delete" /> </a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<!-- end content -->
			<!-- start sidebar -->
			<div id="sidebar">

				<ul>
					<li>
						<ul>
							<li><fmt:message key="username" /> <c:out
									value="${model.username}" /></li>
						</ul>
					</li>
					<li>
						<ul>
							<li><fmt:message key="overdueItemCount" /> <c:out
									value="${model.overdueCount}" /></li>
							<li><fmt:message key="itemCount" /> <c:out
									value="${model.itemCount}" /></li>
						</ul>
					</li>
					<li>
						<ul>
							<li><fmt:message key="lastUpdate" /></li>
							<li><c:out value="${model.now}" /></li>
						</ul>
					</li>
				</ul>
			</div>
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
	</div>
</body>
</html>
