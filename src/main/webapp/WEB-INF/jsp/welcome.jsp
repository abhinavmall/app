<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
	
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Cab Booking</h1>
		</div>
		<div id="driverTable">
			<table style="width:100%">
			  <tr>
			    <th>Driver</th>
			    <th>Customer</th> 
			    <th>Status</th>
			  </tr>	
			<c:if test="${not empty driverList}">
				<c:forEach var="driver" items="${driverList}">
					<tr>
					    <td>${driver.name }</td>
					    <td>${driver.passenger }</td> 
					    <td>${driver.status }</td>
			  		</tr>
				</c:forEach>	
			</c:if>
			</table>
		</div>
		<div id="booking_form">
			<form:form method="POST" action="/book" commandName="customer">
				<form:label path="name">Name </form:label><form:input path="name" required="required"/> <br/>
				<form:label path="latitude">Latitude </form:label><form:input path="latitude" required="required"/> <br />
				<form:label path="longitude">Longitude </form:label><form:input path="longitude" required="required"/>
				<input type="submit" value="Submit" />
			</form:form>
			<button onclick="getLocation()">Get Location</button>
		</div>
	</div>

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		var x=document.getElementById("latitude");
		var y=document.getElementById("longitude");
		function getLocation()
		  {
		  if (navigator.geolocation)
		    {
		    navigator.geolocation.getCurrentPosition(showPosition);
		    }
		  else{x.innerHTML="Geolocation is not supported by this browser.";}
		  }
		function showPosition(position)
		  {
		  x.value=position.coords.latitude;  
		  y.value=position.coords.longitude;    
		  }
	</script>
</body>

</html>