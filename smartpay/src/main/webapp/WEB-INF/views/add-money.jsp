<!DOCTYPE html>
<html>
<head>
    <title>Add money</title>
</head>
<body>
	
<h2>Add money</h2>

<form action="/addMoney" method="post">
	Amount:
	<input type="number" name="amount" step="0.01" required/><br><br>
	<input type="submit">
	
	<button type="submit">Add</button>
</form>

<a href="/user-dashboard">Back</a>
	