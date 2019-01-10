 <%@ include file = "header.jsp" %>
 
 <div class="container-fluid">
 	<div class="row">
 		<div class="col-md-8 mx-auto">
		 	<form:form method="post" action="editShop?${_csrf.parameterName}=${_csrf.token}" 
		 		modelAttribute="shop" enctype="multipart/form-data">
		 		<form:hidden path="id" />
		 		<div class="form-group">
					<label for="name">Shop name</label> 		
					<form:input path="name" class="form-control"  placeholder="Shop name" />
				</div>
				<div class="form-group">
					<label for="address">Shop address</label> 		
					<form:input path="address" class="form-control"  placeholder="Shop address" />
				</div>
				<div class="form-group">
					<label for="file">Add shop image</label>
					<br>
					<input name="file" type="file"><br>
    			</div>
				<button type="submit" class="btn btn-success">Save</button>
		 	</form:form>
		 </div>
	</div>
 </div>
 
 <%@ include file = "footer.jsp" %>