<!DOCTYPE html>
<html>
<head>
    <title>Transfer money</title>
</head>
<body>
	
<h2>Transfer money</h2>

<form action="/transfer" method="post">
	Receiver email:<input type="email" name="receiveremail"/><br><br>
	Amount:	<input type="number" name="amount" step="0.01" required />
	    <br><br>
		</form>
		
   <button type="submit">Transfer</button>
   </form>
   
 <a href="/user-dashboard">Back</a>