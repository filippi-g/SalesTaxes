<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sales Taxes - Basket</title>
</head>
<body>

	<table>
		<tr height="20px">
			<th colspan="4">Sales Taxes - Basket Number: <c:out
					value="${requestScope.basketId}" /></th>
		</tr>
		<tr height="10px"></tr>
		<tr>
			<th>Cod.</th>
			<th>Quantity</th>
			<th>Product</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${requestScope.list}" var="lists">
			<tr>
				<td><c:out value="${lists.productNumber}" /></td>
				<td>1</td>
				<td><c:out value="${lists.productName}" /></td>
				<td><c:out value="${lists.price}" /></td>
			</tr>
		</c:forEach>
		<tr height="30px"></tr>
		<tr>
			<td>
				<form method="Post" action="ShowReceipt">
					<input type="hidden" name="basketId"
						value="${requestScope.basketId}" /> <input type="submit"
						value="Receipt">
				</form>
			</td>

			<td>
				<form action="EntryPoint">
					<input type="submit" value="Home">
				</form>
			</td>
		</tr>
	</table>





</body>
</html>
