<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.T14GString.DAO.AdminForm"%>
<%@ page import="org.hibernate.*" %>
<%@ page import="org.hibernate.cfg.AnnotationConfiguration" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.springframework.web.multipart.*" %>
<%@ page import="com.T14GString.DAO.*" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
  table.test {border-collapse:separate; border-spacing: 10px 10px;}
  table.test td{border-bottom: 1px solid white; border-left: 1px solid white; border-right: 1px solid white;  }
  </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question View</title>
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
      <li><a href="registration.html">Register</a></li>
      <li><a href="#">About</a></li>
      
    </ul>
    <ul class="nav navbar-nav" style="float: right; margin-right: 70px;">
        <li><a href="#"><strong>Welcome Admin</strong></a></li>
    	<li><a href="userloginform.html"><strong>Log out</strong></a></li>
    </ul>
  </div>
</nav>
<div  style="color: #fff;  font-size: medium; font-family: cursive;">
<br>
<table border="0" style="float: right; margin-right: 100px; "><tr><td width="100%" align="right"><a style="color: #FFF;" href="adminIndex.html"> &lt&ltGo Back</a></td></tr></table>
	<%
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
		Session session1 = sessionFactory.openSession();
		Transaction transaction = session1.beginTransaction();
	%>
<table class="test" Style="border-collapse:separate; border-spacing: 10px 10px; border-bottom-color:#FFF; ;width: 80%; margin-top: 7%; " align="center" border="0">
	<tr align="center">
	<th width="5%" align="center"><button class="btn btn-primary btn-block btn-large">Q.No</button></th>
	<th width="35%" align="center"><button class="btn btn-primary btn-block btn-large">Problem Statement</button></th>
	<th style="width: auto;" align="center"><button class="btn btn-primary btn-block btn-large">Input String</button></th>
	<th style="width: auto;" align="center"><button class="btn btn-primary btn-block btn-large">Resultant String</button></th>
	<th style="width: auto;" align="center"><button class="btn btn-primary btn-block btn-large">Condition</button></th>
	<th><button class="btn btn-primary btn-block btn-large">TestCases></button></th>
	</tr>
	<form:form action="questionview.html">
	<% for(int i=1;i<=3;i++){ %>
		<tr align="left">
			<%
			AdminForm adminForm =  (AdminForm) session1.get(AdminForm.class, i);
			%>
			<td align="center" ><%=i %>	</td>
			<td align="center"><%=adminForm.getQuestion()%>	</td>
			<td align="center" ><%=adminForm.getInputString()%></td>
			<td align="center" ><%=adminForm.getResultantString()%></td>
			<td align="center"><%=adminForm.getCondition()%></td>
			<td align="center"><input style="border: none; background-color: inherit;" type="submit" name="<%="Edit"+i %>" value="Edit" /></td>	
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