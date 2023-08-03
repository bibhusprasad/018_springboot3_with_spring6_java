<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<%--<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">--%>
	<link href="webjars/bootstrap/5.3.1/css/bootstrap.min.css" rel="stylesheet" >
	<link href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
	<%--<link href="https://unpkg.com/gijgo@1.9.14/css/gijgo.min.css" rel="stylesheet" type="text/css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"  crossorigin="anonymous">
	<link href="https://unpkg.com/gijgo@1.9.14/css/gijgo.min.css" rel="stylesheet" type="text/css" />
	<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
	<script src="https://unpkg.com/gijgo@1.9.14/js/gijgo.min.js" type="text/javascript"></script>--%>

	<title>Add Todo Page</title>
</head>
<body>
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
<script src="webjars/bootstrap/5.3.1/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.7.0/jquery.min.js"></script>
<%--<script src="https://unpkg.com/gijgo@1.9.14/js/gijgo.min.js" type="text/javascript"></script>--%>
<script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
    $('#datepicker').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>
</body>
</html>