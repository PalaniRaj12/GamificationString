<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>   REGISTER</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel="stylesheet" type="text/css" href="style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Gamification String</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="index.jsp">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Login <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="adminloginform.html">Admin</a></li>
	  <li><a href="userloginform.html">User</a></li>
        </ul>
      </li>
      <li class="active"><a href="registration.html">Register</a></li>
      <li><a href="#">About</a></li>
    </ul>
  </div>
</nav>
<div style="float: left; margin-top: 40px; margin-left: 550px;">
<h1 style="font-family: cursive;">Create an Account</h1>
<div class="login" >
<form:form method="Post" action="registration.html"	commandName="registration">
	<table>
		<tr>
			<td><h6><form:errors	path="userName" /></h6></td>
		</tr>
		<tr>
			<td><form:input placeholder="User Name" required="required" path="userName" /></td>
		</tr>
		<tr>
			<td><h6><form:errors path="email" /></h6></td>
		</tr>
		<tr>
			<td><form:input placeholder="Email" path="email" required="required"/></td>
		</tr>
		<tr>
			<td><h6><form:errors	path="password" /></h6></td>
		</tr>
		<tr>
			<td><form:password style="width: 300px;" placeholder="Password" required="required" path="password" /></td>
		</tr>
		<tr>
			<td><h6><form:errors	path="confirmPassword" /></h6></td>
		</tr>
		<tr>
			<td><form:password placeholder="Re-enter Password" required="required" path="confirmPassword" /></td>
		</tr>
	</table>
	<br>
	<table>
		<tr>
			<td><input style="width: 300px; background-color: #4a77d4;" class="btn btn-primary btn-block btn-large" type="submit" value="Register" /></td>
		</tr>
		<tr>
		<td align="center">
			<h6>Already Registered?</h6>  <a href="userloginform.html">Login</a>	
		</td>
		</tr>
	</table>
</form:form>
</div>
</div>
</body>
</html>