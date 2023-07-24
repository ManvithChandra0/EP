<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<h2 align="center">I am in Demo 2 Page</h2>

<%-- <jsp:include page="demo.jsp"></jsp:include> --%>

 <jsp:include page="displayvalues.jsp">
<jsp:param name="id" value="1000"/>
<jsp:param name="name" value="klu"></jsp:param>
</jsp:include>