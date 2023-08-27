import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {retrieveAllTodosByUsername} from "./api/TodosApiService";

export default function TodosRestApiComponent() {

    const {username}= useParams()
    const [message, setMessage] = useState(null)
    const [todos, setTodos] = useState([])

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

    return(
        <div className="TodosRestApiComponent">
            <h2>Welcome {username} to Todos Rest API</h2>
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
                                    <td>{todo.targetDate.toString()}</td>
                                    <td>{todo.completed.toString()}</td>
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