import './CounterComponent.css'
import {useState} from "react";
import CounterButton from "./CounterButton";
import CounterResetButton from "./CounterResetButton";

export default function Counter(){

    const [count, setCount] = useState(0);

    function incrementCounterParentFunction(by) {
        setCount(count + by)
    }

    function decrementCounterParentFunction(by) {
        setCount(count - by)
    }

    function resetCounterParentFunction() {
        setCount(0)
    }

    return (
        <>
            <span className = "totalCounter">{count}</span><br/>
            <CounterButton incrementMethod = {incrementCounterParentFunction} decrementMethod = {decrementCounterParentFunction} />
            <CounterButton by = {2} incrementMethod = {incrementCounterParentFunction} decrementMethod = {decrementCounterParentFunction} />
            <CounterButton by = {5} incrementMethod = {incrementCounterParentFunction} decrementMethod = {decrementCounterParentFunction} />
            <CounterResetButton resetMethod = {resetCounterParentFunction} />
        </>
    )
}

