<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<link href="webjars/bootstrap/5.3.1/css/bootstrap.min.css" rel="stylesheet" >
		<title>List Todos Page</title>
	</head>
	<body>
		<div class="container">
      <h1>Your Todos</h1>
        <table class="table table-success table-striped">
          <thead>
            <tr>
              <th>id</th>
              <th>Description</th>
              <th>Target Date</th>
              <th>Is Completed?</th>
	            <th></th>
	            <th></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${todos}" var="todo">
              <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.completed}</td>
	              <td><a class="btn btn-warning" href="delete-todo?id=${todo.id}" role="button">DELETE</a></td>
	              <td><a class="btn btn-success" href="update-todo?id=${todo.id}" role="button">UPDATE</a></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
			  <a class="btn btn-success" href="add-todo" role="button">Add Todo</a>
		</div>
		<script src="webjars/bootstrap/5.3.1/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.7.0/jquery.min.js"></script>
	</body>
</html>