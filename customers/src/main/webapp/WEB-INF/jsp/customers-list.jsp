<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-customer">Add Customer</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of Customers's</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="15%">Id</th>
						<th width="25%">Name</th>
						<th width="15%">Age</th>
						<th width="25%">Phone Number</th>
						<th width="20%">Address</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Customers}" var="customer">
						<tr>
							<td>${customer.id}</td>
							<td>${customer.name}</td>
							<td>${customer.age}</td>
							<td>${customer.phoneNumber}</td>
							<td>${customer.address}</td>
							<td><a type="button" class="btn btn-success"
								href="/update-customer?id=${customer.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete-customer?id=${customer.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>