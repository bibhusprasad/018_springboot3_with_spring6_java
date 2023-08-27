import {useParams} from "react-router-dom";
import {retrieveTodoByUserId} from "./api/TodosApiService";
import {useAuth} from "./security/AuthContext";
import {useEffect} from "react";

export default function TodoComponent() {

    const {id}= useParams()
    const authContext = useAuth()
    const  username = authContext.username

    useEffect(() => {
        callRetrieveTodoApiByUserId()
    }, [id]);

    function callRetrieveTodoApiByUserId() {
        retrieveTodoByUserId(username, id)
            .then((response) => {
                console.log(response)
            })
            .catch((error) => console.log(error))
            .finally(() => console.log('cleanup code'))
    }

    return(
        <div className="TodoComponent">
            <h1>Welcome {username} to Todo Page</h1>
            <div className="container">
                <h2>Enter Todo Details</h2>
            </div>
        </div>
    )
}