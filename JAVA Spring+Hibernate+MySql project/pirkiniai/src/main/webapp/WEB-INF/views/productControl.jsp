
<%@ include file="header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 mx-auto">
			<h1>Add a product</h1>

			<form:form method="post" action="productControl" modelAttribute="product">
				<form:errors path="name"/>
				<form:input path="name" type="text" class="form-control"
					placeholder="Product name..." required="required"/>
				<br>
				<form:input path="amount" type="number" class="form-control"
					placeholder="Amount..." required="required"/>
				<br>
				<form:select path="type" class="custom-select mySelect" required="required">
					<option value="">Select a type...</option>
					<form:option value="0" label="food"></form:option>
					<form:option value="1" label="household items"></form:option>
					<form:option value="2" label="machinery"></form:option>
				</form:select>
				<form:select path="shop.id" class="custom-select mySelect" required="required">
					<option value="">Select a shop...</option>
					<c:forEach var="shop" items="${shopListForAdd}">
						<form:option value="${shop.id}">
							<c:out value="${shop.name}, ${shop.address}" />
						</form:option>
					</c:forEach>
				</form:select>
				<button type="submit" class="btn btn-success width_100">Add</button>
			</form:form>

		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>
