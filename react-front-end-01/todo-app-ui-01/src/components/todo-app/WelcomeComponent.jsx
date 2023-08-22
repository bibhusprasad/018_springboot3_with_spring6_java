import {Link, useParams} from "react-router-dom";

export default function WelcomeComponent() {

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