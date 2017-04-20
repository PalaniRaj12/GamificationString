<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>play</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="canonical" href="http://www.bootstraptoggle.com">
<link rel="stylesheet" type="text/css" href="style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
  <script src="jquery-linedtextarea.js"></script>
  <link href="jquery-linedtextarea.css" type="text/css" rel="stylesheet" />
 
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  <link href="css/bootstrap-toggle.css" rel="stylesheet">
  <script>
$(function() {
	$(".lined").linedtextarea(
		{selectedLine: 1}
	);
});
</script>
</head>
<body onload="f()">
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
<div  class="container">
<div style="font-family: cursive;">
<form:form action="compilationform.html" commandName="adminForm">
<table>
	<tr>
		<td><h4>Problem Statement</h4></td>
		<td style="float: left; margin-left: 10px;">
			<form:input id="input" rows="1" cols="50" path="question"  readonly="true" cssStyle="border:0px; width:800px;"></form:input>
		</td>
		<td><input type="submit" name="1" class="btn btn-primary btn-block btn-large" value="1" /></td>
		<td><input type="submit" name="2" class="btn btn-primary btn-block btn-large" value="2" /></td>
		<td><input type="submit" name="3" class="btn btn-primary btn-block btn-large" value="3" /></td>
		<td><input style="color: #FFF; border: none; background-color: inherit;" type="submit" name="Go Back" value="&lt&lt Go Back" /></td>
	</tr>
</table>
<table>
	<tr>
		<td width="17%"><h4>Input String</h4></td>
		<td style="float: left; margin-left: 30px;">
		<form:input id="input" path="inputString" readonly="true" cssStyle="border:0px; width:300px;"></form:input></td>
		<td style="float: left; margin-left: 70px;">
			<h4>Condition</h4>
		</td>
		<td><form:input rows="2"  path="condition" readonly="true" id="input" cssStyle="border:0px; width:400px;"></form:input>
		</td>
	</tr>
</table>
</form:form>
</div>
<hr>
<form:form action="compilationform.html" enctype="multipart/form-data"  commandName="compilationForm">
<table style="color: #fff;">
	<tr>
	<th style="float: left;" valign="top" align="left" width="15%">
		<div style="font-family: cursive; float:left; padding-left:0px; height:100% width:35%;">
					<h4>String Transformations </h4><br>
			<form:textarea id="stdout" path="stdout" cols="40" rows="8" readonly="true" cssStyle="border:0px" />
					<h4>Console</h4>
			<form:textarea path="stderr" cols="40" rows="6" readonly="true" cssStyle="border:0px"/>
		</div>
	</th>
	<th valign="top" align="left" width="64%">
	<div style="overflow:inherit;  float:left; height:100%; width:35%; margin-left:0px; margin-top: 0px;">
		<table>
			<tr>
				<th>
					<h6>Function: Public String function(String)</h6>
				</th>
			</tr>
			<tr>
				<td>
					<form:textarea spellcheck="false" class="lined" cols="60" rows="15" path="code" cssStyle="overflow:inherit; " />
				</td>
			</tr>
			<tr>
				<td><h6><%=session.getAttribute("err")==null?"":session.getAttribute("err") %></h6></td>
			</tr>
			</table>
			<table>
				<tr style="font-family: cursive; float: left; margin-left: 0px; width: 500px;">
					<td style="float: left; margin-left: 30px;">
						<h6>File Input<form:checkbox path="checkbox" data-toggle="toggle" data-size="small" /></h6>
					</td> 
					<td style="float: left; margin-left: 300px; margin-top: 0px;">
						<input type="submit" name="Run" class="btn btn-primary btn-block btn-large" value="Run" />
						
					</td>
				</tr>
				<tr style="font-family: cursive; margin-bottom: 50px; width: 500px;">		
					<td style="float: left;">
						<form:input id="file" path="file" type="file"  />
						</td>
						<td style="float: left; margin-left: 130px; margin-top: 0px;">
						<input style="width: 100px;" type="submit" name="Submit" class="btn btn-primary btn-block btn-large" value="Submit" />
						<h6><form:errors path="file" ></form:errors></h6>
					</td>	
					
				</tr>
			</table>
	</div>
	</th>
	<th valign="top">
		<div style="float:left; margin-left: 60px; height:100% width:35%; font-family: cursive;">
			<form:form commandName="adminForm">
				<h4>Expected Result:</h4>
				<br>
				<form:textarea  id="resultantString" readonly="true" rows="8" cols="40" path="resultantString" cssStyle="border:0px"></form:textarea>
				<p>Status:<%=session.getAttribute("result"+session.getAttribute("qid"))==null?" ":" "+session.getAttribute("result"+session.getAttribute("qid")) %></p>
				
				</form:form>
		</div>
	</th>
	</tr>
	</table>
</form:form>
</div>
</body>
</html>