<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="loginAction1.action">
	<table>
		<tr>
			<td><s:actionerror></s:actionerror></td>
		</tr>
		<tr>
			
			<td><label for="userName">User Name</label>
			    <input type="text" name="userName"/>
			   <s:fielderror></s:fielderror> 
			</td>			
		</tr>
		<tr>
			<td><label for="password">Password</label>
			    <input type="password" name="password"/>
			   
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"/>
				<input type="reset" value="Clear"/>
			</td>
		</tr>				
	</table>
	</form>
	</center>
	
</body>
</html>