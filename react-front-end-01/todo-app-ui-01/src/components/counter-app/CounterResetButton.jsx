
export default function CounterResetButton({resetMethod}) {

    return (
        <>
            <div className = "CounterResetButton">
                <button className = "counterResetButton"
                        onClick = {resetMethod}
                >Reset</button>
            </div>
        </>
    )
}