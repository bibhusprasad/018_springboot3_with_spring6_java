import './App.css';
import {Component} from "react";

function App() {
  return (
    <div className = "App">
        <FirstComponent/>
        <SecondComponent/>
        <ThirdComponent/>
    </div>
  );
}

function FirstComponent() {
    return (
        <div className = "FirstComponent">
            First Component
        </div>
    )
}

function SecondComponent() {
    return (
        <div className = "SecondComponent">
            Second Component
        </div>
    )
}

class ThirdComponent extends Component{
    render() {
        return (
            <div className = "ThirdComponent">
                Third Component
            </div>
        )
    }
}

export default App;
