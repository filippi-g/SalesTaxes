<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sales Taxes - Receipt</title>
</head>
<body>
	<form method="Post" action="EntryPoint">
	<table>
		<tr height="20px">
			<th colspan="3">Sales Taxes - Receipt Number: <c:out value="${requestScope.receipt.id}" /></th>
		</tr>
		<tr height="10px"></tr>
		<tr>
			<th>Cod.</th>
			<th>Quantity</th>
			<th>Product</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${requestScope.receipt.itemsList}" var="item">
			<tr>
				<td><c:out value="${item.productDetail.productNumber}" /></td>
				<td>1</td>
				<td><c:out value="${item.productDetail.productName}" /></td>
				<td><c:out value="${item.finalCost}" /></td>
			</tr>
		</c:forEach>
		<tr height="10px">
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<td>Sales Taxes</td>
			<td><c:out value="${requestScope.receipt.salesTaxes}" /></td>
		</tr>
		<tr>
			<td>Total</td>
			<td><c:out value="${requestScope.receipt.total}" /></td>
		</tr>
		<tr><td><input type="submit" value="Home"></td></tr>
	</table>
	</form>
</body>
</html>
