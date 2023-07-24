<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%!  //declaration tag
int a = 10,b = 20; //variables

public int add(int x,int y) //method
{
  return x+y;
}
%>

<%  //scriptlet tag
  System.out.println(add(a,b));
  out.println(add(a,b)+"</br>");
  out.println("<b>"+add(3,4)+"</b></br>");
%>

  The value of a = <%=a%> </br>
  The value of b = <%=b%> </br>
  <h2> Output = <%=add(a,b) %></h2>