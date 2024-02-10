<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Customer</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="customer">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="name">Name</form:label>
							<form:input path="name" type="text" class="form-control"
								required="required" maxlength="50" pattern="^[A-Z]\\s[A-Z]" />
							<form:errors path="name" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="age">Age</form:label>
							<form:input path="age" type="number" class="form-control"
								required="required" pattern="[0-9]{2}/>
							<form:errors path="age" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="phoneNumber">Phone Number</form:label>
							<form:input path="phoneNumber" type="number" class="form-control"
								required="required" pattern="[0-9]{10}/>
							<form:errors path="phoneNumber" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="address">Address</form:label>
							<form:input path="address" type="text" class="form-control"
								required="required" pattern="^[a-zA-Z\\s]\\s\\d{2}\\s#\\s\\d{2}[a-zA-Z\\s]\\s-\\s\\d{2}[a-zA-Z\\s]+$" />
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