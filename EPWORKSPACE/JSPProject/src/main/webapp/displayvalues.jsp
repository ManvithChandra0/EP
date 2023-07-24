<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <h2 align="center">I am in Display Values Page</h2>
 <% 
 String id = request.getParameter("id");
 String name = request.getParameter("name");
 %>
 
 ID = <%= id %> </br>
 NAME = <%= name %>