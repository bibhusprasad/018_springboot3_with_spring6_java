<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="webjars/bootstrap/5.3.1/css/bootstrap.min.css" rel="stylesheet" >
	<link href="https://unpkg.com/gijgo@1.9.14/css/gijgo.min.css" rel="stylesheet" type="text/css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"  crossorigin="anonymous">
	<link href="https://unpkg.com/gijgo@1.9.14/css/gijgo.min.css" rel="stylesheet" type="text/css" />

	<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
	<script src="https://unpkg.com/gijgo@1.9.14/js/gijgo.min.js" type="text/javascript"></script>

	<title>Add Todo Page</title>
</head>
<body>
<div class="container">
	<h1>Enter Todo Details</h1>
	<form method="post">

		<div class="row mb-3">
			<label for="description" class="col-sm-2 col-form-label">Description</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="description" name="description">
			</div>
		</div>

		<div class="row mb-3">
			<label for="datepicker" class="col-sm-2 col-form-label">Target Date</label>
			<div class="col-sm-10">
				<input id="datepicker" width="276" name="targetDate"/>
				<script>
            $('#datepicker').datepicker({
                uiLibrary: 'bootstrap5'
            });
				</script>
			</div>
		</div>

		<fieldset class="row mb-3">
			<legend class="col-form-label col-sm-2 pt-0">Completed</legend>
			<div class="col-sm-10">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="done" id="gridRadios1" value="no" checked>
					<label class="form-check-label" for="gridRadios1">
						No
					</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="done" id="gridRadios2" value="yes">
					<label class="form-check-label" for="gridRadios2">
						Yes
					</label>
				</div>
			</div>
		</fieldset>
		<button type="submit" class="btn btn-success">Add Todo</button>
	</form>
	<p><a class="btn btn-primary" href="todos-list" role="button">Click</a> to view your todos</p>
</div>
<script src="webjars/bootstrap/5.3.1/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.7.0/jquery.min.js"></script>
<script src="https://unpkg.com/gijgo@1.9.14/js/gijgo.min.js" type="text/javascript"></script>
</body>
</html>