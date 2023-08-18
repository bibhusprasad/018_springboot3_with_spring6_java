import FirstComponent, {FifthComponent} from "./FirstComponent";
import ThirdComponent from "./ThirdComponent";
import LearningJavaScript from "./LearningJavaScript";
/*
    import without {} will show the result from default export component values
    In First component default export is FirstComponent. so the value will be FirstComponent
    So to get Fifth Component value we need to add {FifthComponent}
 */
//import FifthComponent from './components/learning-examples/FirstComponent';

export default function LearningComponent() {
    return (
        <div className = "LearningComponent">
            <FirstComponent/>
            <FifthComponent/>
            <ThirdComponent/>
            <LearningJavaScript/>
        </div>
    )
}


