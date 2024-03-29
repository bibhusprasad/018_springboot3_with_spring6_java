import {apiClient} from "./ApiClient";

export const retrieveAllTodosByUsername =
    (username) => apiClient.get(`/users/${username}/todos`)

export const deleteTodoByUserId =
    (username, id) => apiClient.delete(`/users/${username}/todos/${id}`)

export const retrieveTodoByUserId =
    (username, id) => apiClient.get(`/users/${username}/todos/${id}`)

export const updateTodoByUserId =
    (username, id, todo) => apiClient.put(`/users/${username}/todos/${id}`, todo)

export const createNewTodo =
    (username, todo) => apiClient.post(`/users/${username}/todos`, todo)