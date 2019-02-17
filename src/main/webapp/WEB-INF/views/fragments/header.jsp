<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light"
	role="navigation">

	<div class="navbar-header">
		<a class="navbar-brand" href="#">Project Management</a>
	</div>

	<ul class="nav navbar-nav">

		<li><a href="<spring:url value="/home/"/>">Home</a></li>

		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Booking
				<span class="caret"></span>
			</a>

			<ul class="dropdown-menu" role="menu">
				<li><a href="<spring:url value="/book/add"/>">New Appointment</a></li>
				<li><a href="#">Check availability</a></li>
			</ul>
		</li>

		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Resources
				<span class="caret"></span>
			</a>

			<ul class="dropdown-menu" role="menu">
				<li><a href="#">Add</a></li>
				<li><a href="#">Find</a></li>
			</ul>
		</li>

	</ul>

	<ul class="nav navbar-nav navbar-right">
		<li><a href="/logout/">Logout</a></li>
	</ul>
	
	<ul class="nav navbar-nav navbar-right">
		<li><a href="javascript:;" id="userId"></a></li>
	</ul>

</nav>