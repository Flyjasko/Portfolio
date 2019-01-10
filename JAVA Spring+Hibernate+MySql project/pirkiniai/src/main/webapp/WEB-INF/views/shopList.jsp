
<%@ include file="header.jsp"%>

<h1>Shop control system</h1>
<br>
<div class="container-fluid">
	<div class="row">
		<div class="table-responsive col-md-6 mx-auto">
			<table class="table table-striped table-sm">
				<thead>
					<tr>
						<th>Shop logo</th>
						<th>Shop name</th>
						<th>Shop address</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="shop" items="${shopList}">
						<tr>
							<td class="align-middle">
							<c:if test="${shop.image != null }">
								<img src="img/${shop.image}" width="100">
							</c:if> 
							<c:if test="${shop.image == null }">
                  				No logo
                  			</c:if></td>
							<td class="align-middle">${shop.name}</td>
							<td class="align-middle">${shop.address}</td>
							<td class="align-middle"><a href="#myModal_${shop.id}"
								role="button" class="btn btn-danger" data-toggle="modal">Delete</a></td>
							<td class="align-middle"><a href="editShop?id=${shop.id}"
								class="btn btn-primary">Edit</a></td>
						</tr>

						<div id="myModal_${shop.id}" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>						
									</div>

									<div class="modal-body">
										<h1>WARNING</h1>
										<p>Deleting this shop will delete all associated products and their history with it.</p>
									</div>
									<div class="modal-footer">
										<a href="${pageContext.request.contextPath}/deleteShop?id=${shop.id}"
											title="Delete" class="btn btn-danger">Delete</a>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Cancel</button>	
									</div>
								</div>
							</div>
						</div>

					</c:forEach>
				</tbody>
			</table>
			<a href="addShop" class="btn btn-success width_100">Add a new
				shop</a>
		</div>
	</div>
</div>


<%@ include file="footer.jsp"%>