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
	<form action="/gallery/postPinCode" method="post">
		Enter pincode number: <input type="text" placeholder="Pin Code" name="pinCode"> 
		<input type="hidden" name="mobileNumber" value="${mobileNumber}"> 
		<br><input type="submit" value="Submit">
	</form>
</body>
</html>