
export default function ListTodoComponent() {
    const today = new Date();
    const targetDate = new Date(today.getFullYear()+12, today.getMonth(), today.getDay())

    const todos =
        [
            {id: 1, description: 'Learn AWS', targetDate: targetDate, done: false},
            {id: 2, description: 'Learn GCP Cloud', targetDate: targetDate, done: false},
            {id: 3, description: 'Learn Azure', targetDate: targetDate, done: false}
        ]

    return(
        <div className = "ListTodoComponent">
            <h2>Things you want to do</h2>
            <div className="container">
                <table className="table table-success table-striped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Done</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        todos.map(
                            todo => (
                                <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.description}</td>
                                    <td>{todo.targetDate.toDateString()}</td>
                                    <td>{todo.done.toString()}</td>
                                </tr>
                            )
                        )
                    }
                    </tbody>
                </table>
            </div>
        </div>
    )
}