<%@page import="com.T14GString.DAO.AdminForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.hibernate.*" %>
<%@ page import="org.hibernate.cfg.AnnotationConfiguration" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.springframework.web.multipart.*" %>
<%@ page import="com.T14GString.DAO.*" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Index</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" type="text/css" href="style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  table.test table.test1 {border-collapse:separate; border-spacing: 10px 10px;}
  table.test td{border-bottom: 1px solid white; border-left: 1px solid white; border-right: 1px solid white;  }
  </style>
  <script>
  $(document).ready(function(){
	  $("#Profile").click(function(){
		  $("#Profileview").show();
		  $("#changepasswordview").hide();
		  $("#changepassworderr").hide();
		  $("#testcaseview1").hide();
		  $("#testcaseview2").hide();
		  $("#testcaseview3").hide();
		  
	  });
	  $("#ChangePassword").click(function(){
		  $("#changepasswordview").show();
		  $("#Profileview").hide();
		  $("#changepassworderr").hide();
		  $("#testcaseview1").hide();
		  $("#testcaseview2").hide();
		  $("#testcaseview3").hide();
	  });
	  $("#view1").click(function(){
		  $("#changepasswordview").hide();
		  $("#Profileview").hide();
		  $("#changepassworderr").hide();
		  $("#testcaseview1").show();
		  $("#testcaseview2").hide();
		  $("#testcaseview3").hide();
	  });
	  $("#view2").click(function(){
		  $("#changepasswordview").hide();
		  $("#Profileview").hide();
		  $("#changepassworderr").hide();
		  $("#testcaseview2").show();
		  $("#testcaseview1").hide();
		  $("#testcaseview3").hide();
	  });
	  $("#view3").click(function(){
		  $("#changepasswordview").hide();
		  $("#Profileview").hide();
		  $("#changepassworderr").hide();
		  $("#testcaseview3").show();
		  $("#testcaseview1").hide();
		  $("#testcaseview2").hide();
	  });
  });
  </script>
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
    <ul  class="nav navbar-nav" style="float: right; margin-right: 70px;">
        <li><a href="#"><strong>Welcome <%=session.getAttribute("userName")%></strong></a></li>
    	<li><a href="userloginform.html"><strong>Log out</strong></a></li>
    </ul>
  </div>
</nav>
<div  style="color: #fff; font-family: cursive; font-size: medium;">
<br>
<table align="center">
<tr>
	<td>
	<u>	<input style="border: none; background-color: inherit;" id="Profile" type="button" name="Profile" value="View Profile" /></u>
	<u>	<input style="border: none; background-color: inherit;" id="ChangePassword" type="button" name="ChangePassword" value="Change Password" /></u>
	</td>
</tr>
</table>
<table align="center" id="changepassworderr">
<tr>
	<td>
	<h6><%=session.getAttribute("changePasswordErr") %></h6>
	</td>
</tr>
</table>
<div  id="Profileview" style="display: none;">
<br><br>
<table border="0" width="20%" align="center">
<tr> 
<td>Name</td><td> <%=session.getAttribute("userName") %></td></tr>
<tr><td>Email</td><td> <%=session.getAttribute("email") %></td>
</tr></table>
</div>
<div id="changepasswordview" style="display: none;">
<br><br>
<form:form action="userIndex.html" commandName="registration">
<table class="adminpost1 test1"  border="0" width="40%" align="center" >
<tr><td width="20%"><form:password placeholder="Password" required="required" path="password" /></td>
<td width="20%"><form:password placeholder="Re-enter Password" required="required" path="confirmPassword" /></td></tr>
</table>
<table width="20%" align="center">
 <tr>
  <td>	
	<input width="10%" style="background-color: #4a77d4;" class="btn btn-primary btn-block btn-large" type="submit" name="changepassword" value="Reset Password" />
  </td>
 </tr>
</table>
</form:form>
</div>
<p></p>

	<%
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
		Session session1 = sessionFactory.openSession();
		Transaction transaction = session1.beginTransaction();
	%>
<table class="test" Style="width: 70%; margin-top: 0%;" align="center" >
	<tr Style="width: 90%;">
	<th><button class="btn btn-primary btn-block btn-large">Q.No</button></th>
	<th><button class="btn btn-primary btn-block btn-large">Problem Statement</button></th>
	<th><button class="btn btn-primary btn-block btn-large">Points</button></th>
	<th><button class="btn btn-primary btn-block btn-large">TestCase</button></th>
	<th><button class="btn btn-primary btn-block btn-large">status</button></th>
	</tr>
	<form:form action="compilationform.html" commandName="adminForm">
	<% for(int i=1;i<=3;i++){ %>
		<tr>
			<%
			CompilationForm compilationForm =  (CompilationForm) session1.get(CompilationForm.class, (String)session.getAttribute("email")+"&"+i);
			%>
			<td align="center" width="10%"><%=i %>	</td>
			<% AdminForm adminForm= new AdminPostDAO().DBretrieve(i);%>
			<td align="center" width="50%"><%=adminForm.getQuestion() %>	</td>
			<td align="center" width="10%"><%=compilationForm.getPercentage()+"%" %></td>
			<% 
			session.setAttribute(i+"tc1input", adminForm.getTc1input());session.setAttribute(i+"tc2input", adminForm.getTc2input());
			session.setAttribute(i+"tc3input", adminForm.getTc3input());session.setAttribute(i+"tc4input", adminForm.getTc4input());
			session.setAttribute(i+"tc5input", adminForm.getTc5input());session.setAttribute(i+"tc1output", adminForm.getTc1output());
			session.setAttribute(i+"tc2output", adminForm.getTc2output());session.setAttribute(i+"tc3output", adminForm.getTc3output());
			session.setAttribute(i+"tc4output", adminForm.getTc4output());session.setAttribute(i+"tc5output", adminForm.getTc5output());
			session.setAttribute(i+"tc1Routput",compilationForm.getTc1Routput());session.setAttribute(i+"tc2Routput",compilationForm.getTc2Routput());
			session.setAttribute(i+"tc3Routput",compilationForm.getTc3Routput());session.setAttribute(i+"tc4Routput",compilationForm.getTc4Routput());
			session.setAttribute(i+"tc5Routput",compilationForm.getTc5Routput());
			%>	
			<td align="center" width="10%"><input style="text-align:center; border: none; background-color: inherit; font-family: cursive;" onclick="" id="<%="view"+i %>" value="view"/></td>
			<td width="15%" align="center"><input style="border: none; background-color: inherit; font-family: cursive;" type="submit" name="<%=i %>" value="<%=compilationForm.getPercentage()==100?"Solved":compilationForm.getPercentage()==0?"Try it":"Try Again" %>" /></td>
		</tr>
		<br>
	<% } %>
	</form:form>
</table>
<div id="testcaseview1" style="display: none;">
<table  class="test" Style="width: 70%; margin-top: 0%;" align="center" >
<tr Style="width: 90%;">
	<th><button class="btn btn-primary btn-block btn-large">TestCase Input</button></th>
	<th><button class="btn btn-primary btn-block btn-large">TestCase Output</button></th>
	<th><button class="btn btn-primary btn-block btn-large">Your Output</button></th>
</tr>
<%
  for(int i=1;i<=5;i++)
  {%>
	 <tr>
	 	<td align="center" width="30%"><%=session.getAttribute("1tc"+i+"input") %></td>
	 	<td align="center" width="30%"><%=session.getAttribute("1tc"+i+"output") %></td>
	 	<td align="center" width="30%"><%=session.getAttribute("1tc"+i+"Routput") %></td>
	 </tr> 
  <% }
%>
</table>
</div>

<div id="testcaseview2" style="display: none;">
<table  class="test" Style="width: 70%; margin-top: 0%;" align="center" >
<tr Style="width: 90%;">
	<th><button class="btn btn-primary btn-block btn-large">TestCase Input</button></th>
	<th><button class="btn btn-primary btn-block btn-large">TestCase Output</button></th>
	<th><button class="btn btn-primary btn-block btn-large">Your Output</button></th>
</tr>
<%
  for(int i=1;i<=5;i++)
  {%>
	 <tr>
	 	<td align="center" width="30%"><%=session.getAttribute("2tc"+i+"input") %></td>
	 	<td align="center" width="30%"><%=session.getAttribute("2tc"+i+"output") %></td>
	 	<td align="center" width="30%"><%=session.getAttribute("2tc"+i+"Routput") %></td>
	 </tr> 
  <% }
%>
</table>
</div>

<div id="testcaseview3" style="display: none;">
<table  class="test" Style="width: 70%; margin-top: 0%;" align="center" >
<tr Style="width: 90%;">
	<th><button class="btn btn-primary btn-block btn-large">TestCase Input</button></th>
	<th><button class="btn btn-primary btn-block btn-large">TestCase Output</button></th>
	<th><button class="btn btn-primary btn-block btn-large">Your Output</button></th>
</tr>
<%
  for(int i=1;i<=5;i++)
  {%>
	 <tr>
	 	<td align="center" width="30%"><%=session.getAttribute("3tc"+i+"input") %></td>
	 	<td align="center" width="30%"><%=session.getAttribute("3tc"+i+"output") %></td>
	 	<td align="center" width="30%"><%=session.getAttribute("3tc"+i+"Routput") %></td>
	 </tr> 
  <% }
%>
</table>
</div>
<%
	transaction.commit(); 
	session1.flush(); 
	session1.close(); %>

</div>
</body>
</html>