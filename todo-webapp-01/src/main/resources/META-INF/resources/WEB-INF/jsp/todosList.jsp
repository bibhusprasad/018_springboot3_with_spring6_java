<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

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
<%@ include file="common/footer.jspf"%>