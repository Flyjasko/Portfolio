 <%@ include file = "header.jsp" %>
 
 	<div class="table_1 col-md-10 mx-auto">

					<table class="table table-striped table-sm">
				      <thead>
				        <tr>
				          <th>Product name</th>
				          <th>Product amount</th>
				          <th>Product type</th>
				          <th></th>
				          <th></th>
				        </tr>
				      </thead>
				      <tbody>
				      	<c:forEach var="product" items="${productList}">
					        <tr>
					          <td>${product.name}</td>
					          <td>${product.amount}</td>
					          <td>
							    <c:choose>
						  			<c:when test="${product.type == 0}">
						  				<c:out value="food"/>
						  			</c:when>
						  			<c:when test="${product.type == 1}">
						  				<c:out value="household items"/>
						  			</c:when>
						  			<c:when test="${product.type == 2}">
						 				<c:out value="machinery"/>
						  			</c:when>
				  				</c:choose>
					          </td>
					          <td><a href="purchaseProduct?id=${product.id}" class="btn btn-success">Buy</a></td>
					          <td><a href="deleteProduct?id=${product.id}" class="btn btn-danger">Delete</a></td>
					        </tr>
				        </c:forEach>
				      </tbody>
				    </table>
				</div>
 
 <%@ include file = "footer.jsp" %>