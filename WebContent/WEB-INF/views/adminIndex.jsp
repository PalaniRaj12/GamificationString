<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" type="text/css" href="style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Index</title>
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
          <li class="active"><a href="adminloginform.html">Admin</a></li>
	  <li><a href="userloginform.html">User</a></li>
        </ul>
      </li>
      <li><a href="registration.html">Register</a></li>
      <li><a href="#">About</a></li>
    </ul>
    <ul class="nav navbar-nav"  style="float: right; margin-right: 70px;">
        <li><a href="#"><strong>Welcome Admin</strong></a></li>
    	<li><a href="adminloginform.html"><b>Log out</b></a></li>
    </ul>
  </div>
</nav>
<div class="adminPost1" align="center" style="margin-top: 10%;">
<form:form action="adminIndex.html">
<table style="font-family: cursive; font-weight:bold; border-collapse:separate; border-spacing: 10px 10px; ">
		<tr><td><input type="submit" name="Questions" class="btn btn-primary btn-block btn-large" value="Questions" /></td></tr>
		<tr><td><input type="submit" name="View User Solution" class="btn btn-primary btn-block btn-large" value="View User Solution" /></td></tr>
</table>
</form:form>
</div>
</body>
</html>