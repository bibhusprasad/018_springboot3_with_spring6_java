import {Link, useParams} from "react-router-dom";
import axios from "axios";
import {useState} from "react";

export default function WelcomeComponent() {

    const {username}= useParams()

    const [message, setMessage] = useState(null)

    function callHelloWorldRestAPI() {
        console.log('called')
        //axios to call rest API
        axios.get('http://localhost:8080/hello-world')
            .then((response) => successMessage(response))
            .catch((error) => errorMessage(error))
            .finally(() => console.log('cleanup code'))
    }

    function callHelloWorldBeanRestAPI() {
        console.log('called')
        //axios to call rest API
        axios.get('http://localhost:8080/hello-world-bean')
            .then((response) => successBeanMessage(response))
            .catch((error) => errorMessage(error))
            .finally(() => console.log('cleanup code'))
    }

    function successMessage(response) {
        setMessage(response.data)
        console.log(response)
    }

    function errorMessage(error) {
        setMessage(error.toString())
        console.log(error)
    }

    function successBeanMessage(response) {
        setMessage(response.data.message)
        console.log(response)
    }

    return(
        <div className = "WelcomeComponent">
            <h2>Welcome {username} to TODO app</h2>
            <div>
                Have a nice day!
                <Link to="/todos"> Todos List</Link>
            </div>
            <div>
                <button className="btn btn-success m-3" onClick= {callHelloWorldRestAPI}>
                    Call Hello World Rest API</button>
            </div>
            <div>
                <button className="btn btn-success m-3" onClick= {callHelloWorldBeanRestAPI}>
                    Call Hello World Bean Rest API</button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}