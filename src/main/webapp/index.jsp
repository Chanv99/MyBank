<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>	
		<title>My Bank</title>
		<style type="text/css">
			a {
			text-decoration: none;
			color:red;
			}
			input{
				margin : 1px;
			}
		</style>
	</head>
<body>
	<a href="http://localhost:8080/myBank/"><h1>MY BANK</h1></a>
	<h2>${MSG}</h2>
	<form action="createAccount">
		<h3>Create a new Account</h3>
		name<input type="text" name="name"> <br> 
		contact number<input type="text" name="contactNo"> <br>
		address<input type="text" name="address"> <br>
		account balance<input type="text" name="accountBalance">
		<br> <input type="submit" value="create account">
	</form>
	<hr>
	<form action="showAllAccountHolders">
		<h3>List of Accounts in MY BANK</h3>
		<input type="submit" value="Show all account holders">
	</form>
	<hr>
	<form action="updateAccount">
		<h3>Update an Account</h3>
		Enter id<input type="text" name="id"> <br>
		Enter name<input type="text" name="name"> <br> 
		Enter contact number<input type="text" name="contactNo"> <br> 
		Enter address<input type="text" name="address"> <br> 
		Enter account balance<input	type="text" name="accountBalance"> <br>
		<input type="submit"value="update account">

	</form>
	<hr>
	<form action="deleteAccount">
		<h3>Delete an Account forever!!</h3>
		Enter Id <input type="text" name="id"> <br>
		<input type="submit" value="delete account">
	</form>

</body>
</html>
