import {useParams} from "react-router-dom";
import {useState} from "react";
import {
    retrieveHelloWorld,
    retrieveHelloWorldBean,
    retrieveHelloWorldBeanPathVariable
} from "./api/HelloWorldApiService";

export default function HelloWorldComponent() {

    const {username}= useParams()

    const [message, setMessage] = useState(null)

    function callHelloWorldRestAPI() {
        console.log('called')
        //axios to call rest API
        retrieveHelloWorld()
            .then((response) => successMessage(response))
            .catch((error) => errorMessage(error))
            .finally(() => console.log('cleanup code'))
    }

    function callHelloWorldBeanRestAPI() {
        console.log('called')
        //axios to call rest API
        retrieveHelloWorldBean()
            .then((response) => successBeanMessage(response))
            .catch((error) => errorMessage(error))
            .finally(() => console.log('cleanup code'))
    }

    function callHelloWorldBeanPathVariableRestAPI() {
        console.log('called')
        //axios to call rest API
        retrieveHelloWorldBeanPathVariable(username)
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
        <div className = "HelloWorldComponent">
            <h2>Welcome {username} to Hello World API</h2>
            <div>
                <button className="btn btn-success m-3" onClick= {callHelloWorldRestAPI}>
                    Call Hello World Rest API</button>
            </div>
            <div>
                <button className="btn btn-success m-3" onClick= {callHelloWorldBeanRestAPI}>
                    Call Hello World Bean Rest API</button>
            </div>
            <div>
                <button className="btn btn-success m-3" onClick= {callHelloWorldBeanPathVariableRestAPI}>
                    Call Hello World Bean Path Variable Rest API</button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}