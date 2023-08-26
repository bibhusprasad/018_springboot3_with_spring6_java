import {Link, useParams} from "react-router-dom";
import axios from "axios";

export default function WelcomeComponent() {

    const {username}= useParams()

    function callHelloWorldRestAPI() {
        console.log('called')
        //axios to call rest API
        axios.get('http://localhost:8080/hello-world')
            .then((response) => successMessage(response))
            .catch((error) => errorMessage(error))
            .finally(() => console.log('cleanup code'))
    }

    function successMessage(response) {
        console.log(response)
    }

    function errorMessage(error) {
        console.log(error)
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
        </div>
    )
}