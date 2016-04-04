<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
    background-color: #d0e4fe;
}

h1, h2, h3, h4, h5, h6 {
    color: orange;
    text-align: center;
}

p {
    font-family: "Times New Roman";
    font-size: 20px;
}
</style>
</head>
<body>
	<h1><s:property value="firstname"/> Here is the information your entered</h1>
	<h3><s:property value="lastname"/></h3>
	<h3><s:property value="email"/></h3>
	<h3><s:property value=""/></h3>
	<h3><s:property value="box1"/></h3>
	<h3><s:property value="rdbnt"/></h3>
</body>
</html>