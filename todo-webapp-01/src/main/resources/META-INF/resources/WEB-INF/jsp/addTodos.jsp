
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Enter Todo Details</h1>
	<form:form method="post" modelAttribute="todo">

		<%--<div class="row mb-3">
			<label for="description" class="col-sm-2 col-form-label">Description</label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="description" path="description" required="required"/>
				<form:errors path="description" cssClass="text-warning"/>
			</div>
		</div>--%>

		<fieldset class="row mb-3">
			<form:label class="col-sm-2 col-form-label" for="description" path="description" >Description</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" type="text" path="description" required="required"/>
				<form:errors path="description" cssClass="text-warning"/>
			</div>
		</fieldset>


		<fieldset class="row mb-3">
			<form:label class="col-sm-2 col-form-label" for="datepicker" path="targetDate">Target Date</form:label>
			<div class="col-sm-10">
				<form:input id="datepicker" width="276" type="text" path="targetDate" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"/>
			</div>
		</fieldset>

		<%--<div class="row mb-3">
			<label for="datepicker" class="col-sm-2 col-form-label">Target Date</label>
			<div class="col-sm-10">
				<input id="datepicker" width="276" name="targetDate" required="required"/>
				<script>
            $('#datepicker').datepicker({
                uiLibrary: 'bootstrap5'
            });
				</script>
			</div>
		</div>--%>

		<fieldset class="row mb-3">
			<legend class="col-form-label col-sm-2 pt-0">Completed</legend>
			<div class="col-sm-10">
				<div class="form-check">
					<form:radiobutton  class="form-check-input" path="completed" id="gridRadios1" value="No" checked="true"/>
					<label class="form-check-label" for="gridRadios1">
						No
					</label>
				</div>
				<div class="form-check">
					<form:radiobutton  class="form-check-input" path="completed" id="gridRadios2" value="Yes"/>
					<label class="form-check-label" for="gridRadios2">
						Yes
					</label>
				</div>
			</div>
		</fieldset>
		<button type="submit" class="btn btn-success">Add Todo</button>
	</form:form>
	<p><a class="btn btn-primary" href="todos-list" role="button">Click</a> to view your todos</p>
</div>
<%@ include file="common/footer.jspf"%>