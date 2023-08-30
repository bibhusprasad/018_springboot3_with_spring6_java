import {createContext, useContext, useState} from "react";
import {executeBasicAuthenticationService} from "../api/HelloWorldApiService";

//1. Create a context
export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

//2. Share the created context with other components
export default function AuthProvider({ children }) {

    //3. Put some state in context
    const [number, setNumber] = useState(0)
    //setInterval(() => setNumber(number + 1) , 10000)
    const [isAuthenticated, setIsAuthenticated] = useState(false)
    const [username, setUsername] = useState(null)


    /*function login(username, password) {
        if(username === password){
            setUsername(username)
            setIsAuthenticated(true)
            return true
        } else {
            setUsername(null)
            setIsAuthenticated(false)
            return false
        }
    }*/

    function login(username, password) {

        const basicAuthToken = 'Basic ' + window.btoa(username + ":" + password)

        executeBasicAuthenticationService(basicAuthToken)
            .then(response => console.log(response))
            .catch(error => console.log(error))
        setIsAuthenticated(false)
    }

    function logout() {
        setIsAuthenticated(false)
    }

    function getUsername() {
        return username
    }

    return(
        <AuthContext.Provider value={ {number, isAuthenticated, login, logout, username} }>
            {children}
        </AuthContext.Provider>
    )
}