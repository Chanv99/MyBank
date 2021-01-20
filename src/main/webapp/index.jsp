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
		<table>
			<tr>
				<td>name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>contact number</td>
				<td><input type="text" name="contactNo"></td>
			</tr>
			<tr>
				<td>address</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>account balance</td>
				<td><input type="text" name="accountBalance"></td>
			</tr>
			<tr>
				<td><input type="submit" value="create account"></td>			
			</tr>
		</table>
		
		
	</form>
	<hr>
	<form action="showAllAccountHolders">
		<h3>List of Accounts in MY BANK</h3>
		<input type="submit" value="Show all account holders">
	</form>
	<hr>
	<form action="updateAccount">
		<h3>Update an Account</h3>
		<table>
			<tr>
				<td>Enter id</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>contact number</td>
				<td><input type="text" name="contactNo"></td>
			</tr>
			<tr>
				<td>address</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>account balance</td>
				<td><input type="text" name="accountBalance"></td>
			</tr>
			<tr><td><input type="submit" value="update account"></td></tr>
		</table>
	</form>
	<hr>
	<form action="deleteAccount">
		<h3>Delete an Account forever!!</h3>
		Enter Id <input type="text" name="id"> <br>
		<input type="submit" value="delete account">
	</form>
	
	<hr>
	<form action="search">
		<input type="text" name="keyword">
		<input type="submit" value="Search">
	</form>
	
</body>
</html>
