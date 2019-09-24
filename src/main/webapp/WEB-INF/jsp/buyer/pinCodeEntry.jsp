<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Pin code</h3>
	<form action="welcome.jsp" method="post">
		Enter pincode number: <input type="text" placeholder="pincode" name="pincode"> 
		<input type="hidden" placeholder="pincode" name="mob num" value="${mobileNumber}"> 
		<br><input type="submit" value="submitPincode">
	</form>
</body>
</html>