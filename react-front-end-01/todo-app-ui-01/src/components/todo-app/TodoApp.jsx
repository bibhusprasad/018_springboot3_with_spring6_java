import './TodoApp.css'
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter, Link, Route, Routes, useNavigate, useParams} from "react-router-dom";
import {useState} from "react";

export default function TodoApp() {
    return(
        <div className="TodoApp">
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<LoginComponent/>} />
                    <Route path='/login' element={<LoginComponent/>} />
                    <Route path='/welcome/:username' element={<WelcomeComponent/>} />
                    <Route path='/todos' element={<ListTodoComponent/>} />
                    <Route path='*' element={<ErrorComponent/>} />
                </Routes>
            </BrowserRouter>
        </div>
    )
}

function LoginComponent() {
    const[username, setUsername] = useState('')
    const[password, setPassword] = useState('')
    const[showSuccessMessage, setShowSuccessMessage] = useState(false)
    const[showErrorMessage, setShowErrorMessage] = useState(false)
    const navigate = useNavigate()

    function handleUsernameChange(event) {
        setUsername(event.target.value)
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value)
    }

    function handleSubmit(event) {
        if(username === password){
            setShowSuccessMessage(true)
            setShowErrorMessage(false)
            navigate(`/welcome/${username}`)
        } else {
            setShowSuccessMessage(false)
            setShowErrorMessage(true)
        }
    }

    function ShowSuccessMessageComponent() {
        if(showSuccessMessage){
            return <div className="SuccessMessage" >Authenticated Successful</div>
        }
        return null
    }

    function ShowErrorMessageComponent() {
        if(showErrorMessage){
            return <div className="ErrorMessage">Authentication Fail!! Please check</div>
        }
        return null
    }

    return(
        <div className="LoginComponent">
            <div className="Login-form-container">
                <div className="Login-form">
                    <div className="Login-form-content">
                        <h3 className="Login-form-title">Sign In</h3>
                        <div className="form-group mt-3">
                            <label>Username</label>
                            <input
                                type="text"
                                className="form-control mt-1"
                                placeholder="Enter username"
                                name="username"
                                onChange={handleUsernameChange}
                            />
                        </div>
                        <div className="form-group mt-3">
                            <label>Password</label>
                            <input
                                type="password"
                                className="form-control mt-1"
                                placeholder="Enter password"
                                name="password"
                                onChange={handlePasswordChange}
                            />
                        </div>
                        <div className="d-grid gap-2 mt-3">
                            <button
                                type="submit"
                                className="btn btn-primary"
                                onClick={handleSubmit}
                            >
                                Login
                            </button>
                        </div>
                        <p className="forgot-password text-right mt-2">
                            Forgot <a href="#">password?</a>
                        </p>
                    </div>
                    <ShowSuccessMessageComponent/>
                    <ShowErrorMessageComponent/>
                </div>
            </div>
        </div>
    )
}

function WelcomeComponent() {

    const {username}= useParams()

    return(
        <div className = "WelcomeComponent">
            <h2>Welcome {username} to TODO app</h2>
            <div>
                Have a nice day!
                <Link to="/todos"> Todos List</Link>
            </div>
        </div>
    )
}

function ErrorComponent() {
    return(
        <div className = "ErrorComponent">
            <h2>We are working really hard!</h2>
            <div>
                Please contact at 123-456-7890
            </div>
        </div>
    )
}

function ListTodoComponent() {
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