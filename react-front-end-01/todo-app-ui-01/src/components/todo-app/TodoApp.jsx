import './TodoApp.css'
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter, Route, Routes, useNavigate} from "react-router-dom";
import {useState} from "react";

export default function TodoApp() {
    return(
        <div className="TodoApp">
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<LoginComponent/>} />
                    <Route path='/login' element={<LoginComponent/>} />
                    <Route path='/welcome' element={<WelcomeComponent/>} />
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
            navigate('/welcome')
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
    return(
        <div className = "LoginComponent">
            Welcome Component
        </div>
    )
}