import {useParams} from "react-router-dom";
import {retrieveTodoByUserId} from "./api/TodosApiService";
import {useAuth} from "./security/AuthContext";
import {useEffect, useState} from "react";
import {Field, Form, Formik} from "formik";

export default function TodoComponent() {

    const {id}= useParams()
    const authContext = useAuth()
    const  username = authContext.username
    const [description, setDescription] = useState('')
    const [targetDate, setTargetDate] = useState('')

    useEffect(() => {
        callRetrieveTodoApiByUserId()
    }, [id]);

    function callRetrieveTodoApiByUserId() {
        retrieveTodoByUserId(username, id)
            .then((response) => {
                console.log(response)
                setDescription(response.data.description)
                setTargetDate(response.data.targetDate)
            })
            .catch((error) => console.log(error))
            .finally(() => console.log('cleanup code'))
    }

    function onSubmit(values) {
        console.log(values)
    }

    return(
        <div className="TodoComponent">
            <h1>Welcome {username} to Todo Page</h1>
            <div className="container">
                <h2>Enter Todo Details</h2>
                <Formik initialValues={{description, targetDate}}
                    enableReinitialize={true}
                        onSubmit={onSubmit}
                >
                    {
                        (props) => (
                            <Form>
                                <fieldset className="form-group">
                                    <label className="fw-bold">Description </label>
                                    <Field type="text" className="form-control m-2" name="description"></Field>
                                </fieldset>
                                <fieldset className="form-group">
                                    <label className="fw-bold">Target Date </label>
                                    <Field type="date" className="form-control m-2" name="targetDate"></Field>
                                </fieldset>
                                <div>
                                    <button type="submit" className="btn btn-success">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}