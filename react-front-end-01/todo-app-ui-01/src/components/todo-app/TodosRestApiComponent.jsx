import {useParams} from "react-router-dom";
import {useState} from "react";

export default function TodosRestApiComponent() {

    const {username}= useParams()

    const [message, setMessage] = useState(null)

    return(
        <div className="TodosRestApiComponent">
            <h2>Welcome {username} to Todos Rest API</h2>
        </div>
    )
}