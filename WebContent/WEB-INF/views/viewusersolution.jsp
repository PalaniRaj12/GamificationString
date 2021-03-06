<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="org.hibernate.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.hibernate.cfg.AnnotationConfiguration" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.springframework.web.multipart.*" %>
<%@ page import="com.T14GString.DAO.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
  table.test {border-collapse:separate; border-spacing: 10px 10px;}
  table.test td{border-bottom: 1px solid white; border-left: 1px solid white; border-right: 1px solid white;  }
  </style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" type="text/css" href="style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View User Solution</title>
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
<div  style="color: #fff; font-size: medium; font-family: cursive;">
<br>
<table border="0" style="float: right; margin-right: 100px; "><tr><td width="100%" align="right"><a style="color: #FFF;" href="adminIndex.html"> &lt&ltGo Back</a></td></tr></table>

	<%
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
		Session session1 = sessionFactory.openSession();
		Transaction transaction = session1.beginTransaction();
	%>
<table class="test" Style="text-align: center; width: 70%; margin-top: 7%; border-collapse:separate; border-spacing: 10px 10px; " align="center" border="0">
	<tr Style="text-align: center; width: 80%; font-weight: bold;">
	<th><button class="btn btn-primary btn-block btn-large">User Name</button></th>
	<th><button class="btn btn-primary btn-block btn-large">Email</button></th>
	<th><button class="btn btn-primary btn-block btn-large">Q1</button></th>
	<th><button class="btn btn-primary btn-block btn-large">Q2</button></th>
	<th><button class="btn btn-primary btn-block btn-large">Q3</button></th>
	</tr>
	<form:form action="#.html">
	<%  List userName= session1.createQuery("SELECT registration.userName FROM Registration registration").list();
		List results= session1.createQuery("SELECT registration.email FROM Registration registration").list();
		for(int i=0;i<results.size();i++){ %>
		<tr>
			<td width="20%"><%=userName.get(i) %>	</td>
			<td width="30%"><%=results.get(i) %>	</td>
			<%
			for(int j=1;j<=3;j++)
			{
			CompilationForm compilationForm =  (CompilationForm) session1.get(CompilationForm.class, results.get(i)+"&"+j);
			%>
			<td width="20%"><%=compilationForm.getPercentage()+"%" %></td>	
			<% } %>
		</tr>
		<br>
	<% } %>
	</form:form>
</table>
<%
	transaction.commit(); 
	session1.flush(); 
	session1.close(); %>
</div>
</body>
</html>