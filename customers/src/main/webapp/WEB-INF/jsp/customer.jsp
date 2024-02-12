<%@ include file="common/header.jspf"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Customer</div>
				<div class="panel-body">
					<form:form action="/save-customer" method="post" modelAttribute="customer">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="name">Name</form:label>
							<form:input path="name" type="text" class="form-control"
								required="required" maxlength="50" pattern="^[A-Z][a-z]*\\s"/>
							<form:errors path="name" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="age">Age</form:label>
							<form:input path="age" type="text" class="form-control"
								required="required" pattern="^\d{2}$"/>
							<form:errors path="age" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="phoneNumber">Phone Number</form:label>
							<form:input path="phoneNumber" type="number" class="form-control"
								required="required" />
							<form:errors path="phoneNumber" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="address">Address</form:label>
							<form:input path="address" type="text" class="form-control"
								required="required" />
							<form:errors path="address" cssClass="text-warning" />
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>