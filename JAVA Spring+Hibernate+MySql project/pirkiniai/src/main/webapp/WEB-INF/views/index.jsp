
<%@ include file="header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 mx-auto">
			<h1>Filter products by shop</h1>

			<form action="productListByShop">
				<div class="input-group">
					<select name="shop_id" class="custom-select" required>
						<option label="Select a shop to filter by..." />
						<c:forEach var="shop" items="${shopList}">
							<option value="${shop.id}" label="${shop.name}, ${shop.address}" />
						</c:forEach>
					</select>
					<button type="submit" class="btn btn-primary">Filter</button>
				</div>
			</form>
			<br>
			<h1>Filter all products</h1>

			<form action="allProductList">
				<button type="submit" class="btn btn-primary width_100">Filter
					All</button>
			</form>
		</div>
	</div>
</div>



<%@ include file="footer.jsp"%>
