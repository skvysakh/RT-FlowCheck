<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<!-- development version, includes helpful console warnings -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>


<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">RT-FlowCheck</a>
			</div>
			<!-- <div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">RT-FlowCheck</a></li>
				</ul>
			</div> -->
		</div>
	</nav>

	<div class="container-fluid">
		<div class="starter-template">
			<h2>${message}</h2>
		</div>

		<!-- Tablulation of Data -->
		<table border="1" id="data-table">
			<thead align="center" id="thead-data">
			</thead>
			<tbody>
				<tr>
					<td>Name of Dam</td>
					<td>Water Mass</td>
					<td>Max Water Capacity</td>
					<td>Alert Status</td>
				</tr>
			</tbody>
		</table>

	</div>
	<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<c:url value="/js/rtflowcheck.js" var="mainjs" />
	<script src="${mainjs}" type="text/javascript"></script>

</body>



</html>
