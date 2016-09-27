<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sales Taxes - Welcome</title>
</head>
<body>
	<form method="Post" action="ShowBasket">
		<table>
			<tr height="20px" >
				<th colspan="3">Sales Taxes - Baskets</th>
			</tr>
			<tr>
			<td>Basket:</td>
				<td><select name="basketId">
						<c:forEach var="ascSortedBasket"
							items="${requestScope.ascSortedBasket}">
							<option value="${ascSortedBasket.key}">${ascSortedBasket.value}</option>
						</c:forEach>
				</select></td>
				<td><input type="submit" value="Show Basket"></td>
			</tr>
		</table>
	</form>
</body>
</html>
