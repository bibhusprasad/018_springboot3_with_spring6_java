import './App.css';

/*import LearningComponent from "./components/learning-examples/LearningComponent";*/
/*import Counter from "./components/counter-app/CounterComponent";*/
import TodoApp from "./components/todo-app/TodoApp";

function App() {
    return (
        <div className="App">
            {/*<LearningComponent/>*/}
            {/*<PlayingWithProps property1 = "value1" property2 = "value2"/>*/}
            {/*<Counter/>*/}
            <TodoApp/>
        </div>
    );
}

/*
function PlayingWithProps(properties) {
    //{property1: 'value1', property2: 'value2'}
    console.log(properties)
    console.log(properties.property1)
    console.log(properties.property2)
    return(
            <div>Props</div>
    )
}
*/

/*function PlayingWithProps({property1, property2}) {
    console.log(property1)
    console.log(property2)
    return(
        <div>Props</div>
    )
}*/

export default App;
