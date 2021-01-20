<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import = "com.chango.myBank.utility.*,java.util.*,java.math.BigDecimal,java.math.RoundingMode" %>
<%@page import="java.sql.Timestamp"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<style type="text/css">
				tr ,th, td 
				{
					padding : 5px;
					margin:5px;
				}
				table
				{
					align:center; 
					border:1px;
					border-collapse: collapse;
					margin-left : auto;
					margin-right : auto;
				}
		</style>
	</head>
	<body >
		<h1 align="center">
			<a href="/myBank">MY BANK</a>
		</h1>
		<table>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>CONTACT NO.</th>
				<th>ADDRESS</th>
				<th>ACCOUNT BALANCE</th>
				<th>CREATED DATE</th>
			</tr>
			<c:forEach items="${result}" var="accountHolder">
				<tr>
					<td>${accountHolder.id}</td>
					<td>${accountHolder.name}</td>
					<td>${accountHolder.contactNo}</td>
					<td>${accountHolder.address}</td>
					<td align="right">
						<!--<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value = "${accountHolder.accountBalance}" type = "number"/>-->
						<!--  ${accountHolder.accountBalance} -->
						<c:set var="balance" value="${accountHolder.accountBalance}"/>
						<%
						out.print(DecimalFormatter.myDecimalFormat((BigDecimal)pageContext.getAttribute("balance")));
						%>
					</td>
					<td align="right">
						<c:set var="date" value="${accountHolder.date}"></c:set>
						<%
						out.print(DateManager.myDateFormat((Timestamp)pageContext.getAttribute("date"),"dd-MMM-yyyy"));
						%>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
<!-- <fmt:formatDate value="${accountHolder.date}" pattern="dd-MM-yyyy"/>
				<fmt:formatDate value="${accountHolder.date}" type = "time" />
				<fmt:formatDate value="${accountHolder.date}" type = "date"/>
				<fmt:formatDate value="${accountHolder.date}" type = "both"/>
				<fmt:formatDate value="${accountHolder.date}" type = "both" dateStyle = "short" timeStyle = "short"/>
				<fmt:formatDate value="${accountHolder.date}" type = "both" dateStyle = "medium" timeStyle = "medium"/>
				<fmt:formatDate value="${accountHolder.date}" type = "both" dateStyle = "long" timeStyle = "long"/>
				<fmt:formatDate value="${accountHolder.date}" pattern="dd-MM-yyyy hh:mm:ss"/>
				-->
				