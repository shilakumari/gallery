<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List,com.gallery.buyer.model.Shop"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${mobileNumber }
${pinCode}
	<h1>Shop List</h1><br>
	
	<% 
	List<Shop> shopList=(List<Shop>)request.getAttribute("shopList");
	for(int i=0;i<shopList.size();i++){ %>
	<a href="Shop1Items"><%=shopList.get(i).getName()%></a><br>
	<% }%>
	

</body>
</html>