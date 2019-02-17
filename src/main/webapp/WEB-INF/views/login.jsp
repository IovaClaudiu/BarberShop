<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<jsp:include page="./fragments/includes.jsp"></jsp:include>
</head>

<body style='margin: 50px;'>
	<div class="myDiv">
		<h2>Login Page</h2>
		<form:form action="/login" method="POST" modelAttribute="user">
		<c:if test="${param.error != null}">
            <div class="alert alert-danger alert-dismissible">
   				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    			<strong>Login Failed</strong>  Please try again!
 			 </div>
        </c:if>
		
			<p>
				<label class="label label-primary" for="username">Username</label>
				<form:input path="username" class="form-control" type="text" id="username" name="username"
					placeholder="Please enter the username" />
			</p>
			<p>
				<label class="label label-primary" for="password">Password</label>
				<form:input path="password" class="form-control" type="password" id="password" name="password" 
					placeholder="Please enter the password" />
			</p>

			<button type="submit" class="btn btn-info" title="Log in">Log in</button>
			<input type="button" onclick="javascript:registerUser();" class="btn btn-info" title="Register" value="Register"/>
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
	</div>
</body>
</html>