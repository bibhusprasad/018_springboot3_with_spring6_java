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
    const [token, setToken] = useState(null)


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

    async function login(username, password) {

        const basicAuthToken = 'Basic ' + window.btoa(username + ":" + password)
        try{
            const response = await executeBasicAuthenticationService(basicAuthToken)
            if(response.status === 200){
                setUsername(username)
                setIsAuthenticated(true)
                setToken(basicAuthToken)
                return true
            } else {
                logout()
                return false
            }
        } catch(error) {
            logout()
            return false
        }

    }

    function logout() {
        setIsAuthenticated(false)
        setUsername(null)
        setToken(null)
    }

    function getUsername() {
        return username
    }

    return(
        <AuthContext.Provider value={ {number, isAuthenticated, login, logout, username, token} }>
            {children}
        </AuthContext.Provider>
    )
}