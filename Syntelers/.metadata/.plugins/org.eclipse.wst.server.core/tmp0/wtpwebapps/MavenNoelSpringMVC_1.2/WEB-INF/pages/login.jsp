<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page errorPage="/pages/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:set var="number1" scope="request" value="${pageContext.request.requestURI}"></c:set>
	<h4>This is the context root: ${number1}</h4>
	<h2>we are at login.jps.</h2>
	<h2>${message}</h2>
	<table style="width:100%">
		<c:forEach items="${table}" begin="1" var="row">
		    <tr>
		        <c:forEach items="${row}" begin="1" var="cell">
		        	<c:if test="${cell != 0}">
		        		
		        		<td>${cell}</td>
		        	</c:if>
		        </c:forEach>
		    </tr>
		</c:forEach>
	</table>

</body>
<script>
function shome(val)
{
	setTimeout(function(){var innerVal = $("<td></td>").text(val);}, 3000);
}
  
</script>
</html>