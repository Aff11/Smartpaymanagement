<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Transactions</title>
</head>
<body>
	
	<table border="1">
	    <tr>
	        <th>ID</th>
	        <th>Sender</th>
	        <th>Receiver</th>
	        <th>Amount</th>
	        <th>Status</th>
	        <th>Type</th>
	        <th>Created At</th>
	    </tr>

	    <c:forEach var="txn" items="${transactions}">
	        <tr>
	            <td>${txn.id}</td>
	            <td>${txn.sender_id}</td>
	            <td>${txn.receiver_id}</td>
	            <td>${txn.amount}</td>
	            <td>${txn.status}</td>
	            <td>${txn.type}</td>
	            <td>${txn.created_at}</td>
	        </tr>
	    </c:forEach>

	</table>
	<br><br>
		<a href="/admin/dashboard">Back</a>

		</body>
		</html>