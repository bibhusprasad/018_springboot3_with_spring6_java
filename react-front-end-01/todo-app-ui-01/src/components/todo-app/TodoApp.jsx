import './TodoApp.css'
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter, Navigate, Route, Routes} from "react-router-dom";
import LogoutComponent from "./LogoutComponent";
import FooterComponent from "./FooterComponent";
import HeaderComponent from "./HeaderComponent";
import ListTodoComponent from "./ListTodoComponent";
import ErrorComponent from "./ErrorComponent";
import WelcomeComponent from "./WelcomeComponent";
import LoginComponent from "./LoginComponent";
import AuthProvider, {useAuth} from "./security/AuthContext";
import HelloWorldRestApiComponent from "./HelloWorldRestApiComponent";
import TodosRestApiComponent from "./TodosRestApiComponent";
import TodoComponent from "./TodoComponent";

function AuthenticatedRoute({children}) {
    const authContext = useAuth()
    if(authContext.isAuthenticated)
        return children
    return <Navigate to="/" />
}
export default function TodoApp() {
    return(
        <div className="TodoApp">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent/>
                    <Routes>
                        <Route path='/' element={<LoginComponent/>} />
                        <Route path='/login' element={<LoginComponent/>} />
                        <Route path='/welcome/:username' element={
                            <AuthenticatedRoute>
                                <WelcomeComponent/>
                            </AuthenticatedRoute>
                        }/>
                        <Route path='/todos' element={
                            <AuthenticatedRoute>
                                <ListTodoComponent/>
                            </AuthenticatedRoute>
                        } />
                        <Route path='/hello-world/:username' element={
                            <AuthenticatedRoute>
                                <HelloWorldRestApiComponent/>
                            </AuthenticatedRoute>
                        } />
                        <Route path='/todos/:username' element={
                            <AuthenticatedRoute>
                                <TodosRestApiComponent/>
                            </AuthenticatedRoute>
                        } />
                        <Route path='/todo/:id' element={
                            <AuthenticatedRoute>
                                <TodoComponent/>
                            </AuthenticatedRoute>
                        } />
                        <Route path='/logout' element={
                            <AuthenticatedRoute>
                                <LogoutComponent/>
                            </AuthenticatedRoute>
                        } />
                        <Route path='*' element={<ErrorComponent/>} />
                    </Routes>
                    <FooterComponent/>
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}

