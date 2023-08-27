import axios from "axios";

const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
);


export const retrieveAllTodosByUsername =
    (username) => apiClient.get(`/users/${username}/todos`)

export const deleteTodoByUserId =
    (username, id) => apiClient.delete(`/users/${username}/todos/${id}`)

/*
export const retrieveHelloWorldBean =
    () => apiClient.get('/hello-world-bean')

export const retrieveHelloWorldBeanPathVariable =
    (username) => apiClient.get(`/hello-world/path-variable/${username}`)*/
