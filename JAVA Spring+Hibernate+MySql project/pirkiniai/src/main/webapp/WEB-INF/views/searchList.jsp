<%@ include file="header.jsp"%>

<c:choose>
	<c:when test="${fn:length(searchProductList) > 0}">
		<div class="table_1 col-md-10 mx-auto">
			<table class="table table-striped table-sm myTable">
				<thead>
					<tr>
						<th>Product name</th>
						<th>Product amount</th>
						<th>Bought where</th>
						<th>Bought when</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${searchProductList}">
						<tr>
							<td>${product.name}</td>
							<td>${product.amount}</td>
							<td>${product.shop.name}</td>
							<td>${product.onPurchase}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:when>

	<c:when test="${fn:length(searchProductList) == 0}">
		<h1>There is no such product in history</h1>
	</c:when>
</c:choose>

<%@ include file="footer.jsp"%>