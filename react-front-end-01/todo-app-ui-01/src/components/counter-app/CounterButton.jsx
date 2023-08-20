import {useState} from "react";
import PropTypes from "prop-types";

export default function CounterButton({by, incrementMethod, decrementMethod}) {

    //0, f
    const [count, setCount] = useState(0);

    function incrementCounterFunction() {
        setCount(count + by)
        incrementMethod(by)
    }

    function decrementCounterFunction() {
        setCount(count - by)
        decrementMethod(by)
    }

    return(
        <>
            <div className = "CounterComponent">
                {/*<span className = "counter">{count}</span><br/>*/}
                <div>
                    <button className = "counterIncrementButton"
                            onClick = {incrementCounterFunction}
                    >Increment +{by}</button>
                    <button className = "counterDecrementButton"
                            onClick = {decrementCounterFunction}
                    >Decrement -{by}</button>
                </div>
            </div>
        </>
    )
}

CounterButton.prototype = {
    by : PropTypes.number
}

CounterButton.defaultProps = {
    by :1
}