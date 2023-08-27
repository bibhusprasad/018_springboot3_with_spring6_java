import {useNavigate, useParams} from "react-router-dom";
import {retrieveTodoByUserId, updateTodoByUserId} from "./api/TodosApiService";
import {useAuth} from "./security/AuthContext";
import {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";

export default function TodoComponent() {

    const {id}= useParams()
    const authContext = useAuth()
    const  username = authContext.username
    const [description, setDescription] = useState('')
    const [targetDate, setTargetDate] = useState('')
    const navigate = useNavigate()

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
        const todo = {
            id: id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            completed: false
        }
        console.log(todo)
        updateTodoByUserId(username, id, todo)
            .then((response) => {
                console.log(response)
                navigate(`/todos/${username}`)
            })
            .catch((error) => console.log(error))
            .finally(() => console.log('cleanup code'))
    }

    function validate(values) {
        let errors = {

        }
        console.log(values)
        if(values.description.length < 3){
            errors.description = 'Enter atleast 3 characters. '
        }
        if(values.targetDate == null){
            errors.targetDate = 'Enter a valid Date. '
        }
        return errors
    }

    return(
        <div className="TodoComponent">
            <h1>Welcome {username} to Todo Page</h1>
            <div className="container">
                <h2>Enter Todo Details</h2>
                <Formik initialValues={{description, targetDate}}
                    enableReinitialize={true}
                        onSubmit={onSubmit}
                        validate={validate}
                        validateOnChange={false}
                        validateOnBlur={false}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage name="description" component="div" className="alert alert-warning"/>
                                <ErrorMessage name="targetDate" component="div" className="alert alert-warning"/>
                                <fieldset className="form-group">
                                    <label className="fw-bold">Description </label>
                                    <Field type="text" className="form-control m-2" name="description"></Field>
                                </fieldset>
                                <fieldset className="form-group">
                                    <label className="fw-bold">Target Date </label>
                                    <Field type="date" className="form-control m-2" name="targetDate"></Field>
                                </fieldset>
                                <div>
                                    <button type="submit" className="btn btn-success bottom-2">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}