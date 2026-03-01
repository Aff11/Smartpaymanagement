<!DOCTYPE html>
<html>
<head>
    <title>Transaction</title>
</head>
<body>
<%@ taglib prefix="c" uri="https://jakarta.ee/jstl/core" %>
<h2>Transaction History</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Senderid</th>
    <th>Receiverid</th>
    <th>Amount</th>
    <th>Type</th>
    <th>Status</th>
    <th>Date</th>
</tr>	

<c:forEach var="t" items="${transactions}">
<tr>
    <td>${t.id}</td>
    <td>${t.sender}</td>
    <td>${t.receiver}</td>
    <td>${t.amount}</td>
    <td>${t.type}</td>
    <td>${t.status}</td>
    <td>${t.created_at}</td>
</tr>
</c:forEach>
</table>
