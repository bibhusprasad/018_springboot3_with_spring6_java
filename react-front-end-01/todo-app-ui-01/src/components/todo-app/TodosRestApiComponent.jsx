import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {deleteTodoByUserId, retrieveAllTodosByUsername} from "./api/TodosApiService";

export default function TodosRestApiComponent() {

    const {username}= useParams()
    const [message, setMessage] = useState(null)
    const [todos, setTodos] = useState([])
    const navigate = useNavigate()

    useEffect(
        () => {
            callAllTodosByUsername()
        }, []
    );

    function callAllTodosByUsername() {
        retrieveAllTodosByUsername(username)
            .then((response) => {
                console.log(response)
                setTodos(response.data)
            })
            .catch((error) => console.log(error))
            .finally(() => console.log('cleanup code'))
    }

    function callDeleteTodoApiByUserId(id) {
        deleteTodoByUserId(username, id)
            .then((response) => {
                console.log(response)
                setMessage(`Delete of Todo with id = ${id} successful.`)
                callAllTodosByUsername()
            })
            .catch((error) => console.log(error))
            .finally(() => console.log('cleanup code'))
    }

    function callUpdateTodoApiByUserId(id) {
        navigate(`/todo/${id}`)
    }

    function callAddNewTodo() {
        navigate(`/todo/-1`)
    }

    return(
        <div className="TodosRestApiComponent">
            <h2>Welcome {username} to Todos Rest API</h2>
            <div className="container">
                <table className="table table-success table-striped">
                    <thead>
                    <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Done</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        todos.map(
                            todo => (
                                <tr key={todo.id}>
                                    <td>{todo.description}</td>
                                    <td>{todo.targetDate.toString()}</td>
                                    <td>{todo.completed.toString()}</td>
                                    <td><button className="btn btn-warning"
                                                onClick={() =>callDeleteTodoApiByUserId(todo.id)}
                                    >Delete</button></td>
                                    <td><button className="btn btn-success"
                                                onClick={() =>callUpdateTodoApiByUserId(todo.id)}
                                    >Update</button></td>
                                </tr>
                            )
                        )
                    }
                    </tbody>
                </table>
                {message && <div className="alert alert-warning">{message}</div>}
            </div>
            <button className="btn btn-dark m-5" onClick={callAddNewTodo}>Add New Todo</button>

        </div>
    )
}