<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-md-6">
	<h2 id="addressTitle">Enter your shipping Address</h2>
	<form:form commandName="addressForm" id="billingFormm"
		class="form-horizontal" action="address" method="POST">
		<div class="form-group">
			<label for="fullName"> Full Name </label> <input id="fullName"
				name="fullName" type="text" class="form-control"
				placeholder="Full Name" />
		</div>
		<div class="form-group">
			<label for="address1"> Address 1 </label> <input id="address1"
				name="address1" type="text" class="form-control"
				placeholder="Address 1" />
		</div>
		<div class="form-group">
			<label for="fullname"> Address 2 </label> <input id="address2"
				name="address2" type="text" class="form-control"
				placeholder="Address 2" />
		</div>
		<div class="form-group">
			<label for="city"> City </label> <input id="city" name="city"
				type="text" class="form-control" placeholder="City" />
		</div>
		<div class="form-group">
			<label for="zipCode"> Zip Code </label> <input id="zipCode"
				name="zipCode" type="text" class="form-control"
				placeholder="Zip Code" />
		</div>
		<div class="form-group">
			<label for="state"> State </label> <input id="state" name="state"
				type="text" class="form-control" placeholder="State" />
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-large btn-primary"
				value="Save Address" />
		</div>
	</form:form>
</div>