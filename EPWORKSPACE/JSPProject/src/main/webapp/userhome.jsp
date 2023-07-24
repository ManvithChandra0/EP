<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String email=(String)session.getAttribute("email");
String name=(String)session.getAttribute("name");
if(email==null || name==null) response.sendRedirect("sessionexpiry.html");
%>
<!DOCTYPE html>
<html>
<head>
<title>EP</title>
</head>
<body bgcolor="lightgrey">
<h1 align="center">JSP Web Application</h1>
<hr color="black"><hr color="black"><br>
<a href="userhome.jsp">Home</a>&nbsp;&nbsp;&nbsp;
<a href="userlogout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;
<br><br>
<h2>I am in User Home</h2><br>
My name is <%=name%> <br>
My Email ID is <%=email%>