<%@ include file="header.jsp"%>

<input id="idEtape" value="${searchProductList}" type="hidden"/>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 mx-auto">
			<h1>Filter products history by shop</h1>
			<form action="historyListByShop">
				<div class="input-group">
					<select name="shopHistory_id" class="custom-select" required>
						<option label="Select a shop to filter by..." />
						<c:forEach var="shop" items="${shopList}">
							<option value="${shop.id}" label="${shop.name}, ${shop.address}" />
						</c:forEach>
					</select>
					<button type="submit" class="btn btn-success">Filter</button>
				</div>
			</form>
			<br>
			<h1>Filter all products history</h1>
			<form action="allProductHistoryList">
				<button type="submit" class="btn btn-success width_100">FilterAll</button>
			</form>
			<br>
			<h1>Search for a product in history</h1>
			<form action="searchForProduct">
				<div class="input-group">
					<input id="searchBox" name="searchName" type="text" class="form-control" required />
					<button type="submit" class="btn btn-success">Search</button>
				</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>