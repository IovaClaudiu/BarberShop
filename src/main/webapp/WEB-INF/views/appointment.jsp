<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="<spring:url value="/css/personal.css"/>" type="text/css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script src="<spring:url value="/js/personal.js"/>" type="text/javascript" ></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Appointment</title>
<jsp:include page="../views/fragments/header.jsp"></jsp:include>
</head>
<body>
	<div class="myDiv">
		<form:form action="/book/add" method="POST" modelAttribute="appointment">
			<p>
				<label class="label label-primary" for="client_name">Name:</label>
				<form:input path="client_name" class="form-control text-center" type="text" id="client_name"/>
			</p>
			
			<p style="display:grid">
				<label class="label label-primary" for="action_type">Action type:</label>
				<form:select path="action_type" items="${actions}" id="action_type" class="btn btn-primary dropdown-toggle"></form:select>
			</p>
			
			<p>
				<label class="label label-primary" for="">Date:</label>
				<form:input path="" type="text" id="datepicker" class="form-control text-center"/>
			</p>
			<p>
				<label class="label label-primary" for="">Hour:</label>
				<input class="timepicker timepicker-with-dropdown text-center form-control">
			</p>
			
			<button type="submit" class="btn btn-info" title="Done">Done</button>
		</form:form>
	</div>
	
<script>
$(function() {
   $("#datepicker").datepicker({
   		dateFormat:"dd/mm/yy",
   		autoSize: true
   });
});
  
$(document).ready(function(){
    $('input.timepicker').timepicker({
    	timeFormat: 'HH:mm',
    	startTime: '08:00',
    	minTime: '08:00',
    	maxTime: '18:00',
    	interval: '30',
    	dynamic: 'false',
    	dropdown: 'true',
    	scrollbar: 'true'
    });
});
</script>
	
</body>
</html>