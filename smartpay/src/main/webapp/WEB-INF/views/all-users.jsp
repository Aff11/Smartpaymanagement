<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Users</title>
</head>
<body>
	
<h2>All Registered Users</h2>
<table border="1">
	<tr>
	    <th>ID</th>
	    <th>Name</th>
	    <th>Email</th>
	    <th>Wallet Balance</th>
	    <th>Role</th>
	</tr>
	
	<c:forEach var="u" items="${users}">
	    <tr>
	        <td>${u.id}</td>
	        <td>${u.name}</td>
	        <td>${u.email}</td>
	        <td>${u.wallet_balance}</td>
	        <td>${u.role}</td>
	    </tr>
	</c:forEach>	
	</table>
	
	<br><br>
	<a href="admin-dashboard">Back</a>

	</body>
	</html>