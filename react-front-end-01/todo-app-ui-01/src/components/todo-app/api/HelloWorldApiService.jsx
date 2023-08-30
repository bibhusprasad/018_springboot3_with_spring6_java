import axios from "axios";

const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
);


export const retrieveHelloWorld =
    () => apiClient.get('/hello-world')

export const retrieveHelloWorldBean =
    () => apiClient.get('/hello-world-bean')

export const retrieveHelloWorldBeanPathVariable =
    (username, token) => apiClient.get(`/hello-world/path-variable/${username}`, {
        headers: {
            Authorization: token
        }
    })

export const executeBasicAuthenticationService =
    (token) => apiClient.get(`/basicAuth`, {
        headers: {
            Authorization: token
        }
    })