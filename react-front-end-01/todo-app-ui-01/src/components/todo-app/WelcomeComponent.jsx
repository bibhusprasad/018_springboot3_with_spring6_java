import {Link, useParams} from "react-router-dom";

export default function WelcomeComponent() {

    const {username}= useParams()

    return(
        <div className = "WelcomeComponent">
            <h2>Welcome {username} to TODO app</h2>
            <div>
                Have a nice day!
                <div>
                    <Link to="/todos"> Todos React Hard Coded List</Link>
                </div>
                <div>
                    <Link to={`/hello-world/${username}`}> Hello World Rest API</Link>
                </div>
                <div>
                    <Link to={`/todos/${username}`}> Todos Rest API</Link>
                </div>
            </div>
        </div>
    )
}