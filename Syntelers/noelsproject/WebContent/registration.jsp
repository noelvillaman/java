<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome: Register Here</h1>
<form role="form" action="registration.action" method="post">
  <fieldset >
    <legend>Personal information:</legend> 
    <div class="form-group"><s:actionerror></s:actionerror></div>
  	 <div class="form-group">
  	 	<label for="firstn">First name:</label>
    	<input type="text" name="firstname" value="Noel" id="firstn" class="form-control" required>
    	<s:fielderror></s:fielderror> 
     </div>
     <div class="form-group">
    	<label for="lastna">Last name:</label>
    	<input type="text" name="lastname" value="Villaman" id="lastna" class="form-control" required>
  	 </div>
	 <div class="form-group">
	    <label for="email">Email address:</label>
	    <input name="email" type="email" value="nino@yahoo.com" class="form-control" id="email" required>
	  </div>
	  <div class="form-group">
	    <label for="pwd">Password:</label>
	    <input name="password" type="password" value="comino" class="form-control" id="pwd" required>
	  </div>
	   <div class="checkbox">
	    <label><input name="box1" type="checkbox" value="Remeber me"> Remember me</label>
	  </div>
	  <div class="checkbox">
  		<label><input name="check2" type="checkbox" value="">Option 1</label>
	  </div>
		<div class="checkbox">
		  <label><input name="check3" type="checkbox" value="">Option 2</label>
		</div>
		<div class="checkbox">
		  <label><input name="check4" type="checkbox" value="" >Option 3</label>
		</div>
		
		<div class="form-group">
		  <label for="sel1">Select list:</label>
		  <select name="opt1" class="form-control" id="sel1" required>
		    <option>1</option>
		    <option>2</option>
		    <option>3</option>
		    <option>4</option>
		  </select>
		</div>
		<div class="radio">
		  <label><input type="radio" name="rdbtn1">Option 1</label>
		</div>
		<div class="radio">
		  <label><input type="radio" name="rdbtn2">Option 2</label>
		</div>
		<div class="radio disabled">
		  <label><input type="radio" name="rdbtn3" disabled>Option 3</label>
		</div>
	  <button type="submit" class="btn btn-default">Submit</button>
	  </fieldset>
</form>

</body>
</html>