<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
</head>
<body>

<h2>Welcome, ${user.name}</h2>

<h3>Wallet Balance: ₹ ${user.wallet_balance}</h3>

<br>

<a href="/addMoney">Add Money</a><br><br>
<a href="/transfer">Transfer Money</a><br><br>
<a href="/transactions">View Transactions</a><br><br>
<a href="/logout">Logout</a>

</body>
</html>