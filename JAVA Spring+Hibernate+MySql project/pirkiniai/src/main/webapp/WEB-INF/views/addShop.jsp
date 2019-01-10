  <%@ include file = "header.jsp" %>
   
   <div class="container-fluid">
 	 <div class="row">
 		<div class="col-md-8 mx-auto">
			<form:form method="post" action="addShop" modelAttribute="shop">     
				<div class="form-group">
					<label for="name">Shop name</label> 
					<form:input path="name" class="form-control"  placeholder="name" required="required"/>
				</div>			
				<div class="form-group">
					<label for="address">Shop address</label> 
					<form:input path="address" class="form-control"  placeholder="address" required="required"/>
				</div>
					<button type="submit" class="btn btn-primary">Add</button>
			</form:form>
		</div>
	  </div>
	</div>
	
  <%@ include file = "footer.jsp" %>  