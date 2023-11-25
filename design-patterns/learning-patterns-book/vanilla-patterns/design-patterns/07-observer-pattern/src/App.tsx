import { ToastContainer, toast } from "react-toastify";
import observable, { CallbackFunction } from "./utils/Observable";
import Button from "@mui/material/Button";
import FormControlLabel from "@mui/material/FormControlLabel";
import Switch from "@mui/material/Switch";

/* 
  > Utils
*/
const logger: CallbackFunction = (data) => {
  console.log(`${Date.now()} ${data}`);
};
const toastify: CallbackFunction = (data) => {
  toast(data, {
    position: toast.POSITION.BOTTOM_RIGHT,
    closeButton: false,
    autoClose: 2000,
  });
};

/* 
 > subscribe the toastify & logger observers to our observable
*/
observable.subscribe(toastify);
observable.subscribe(logger);

/* 
  > Consume the observable by notifying all previously registered observers
*/
function handleClick() {
  observable.notify("User clicked button");
}
function handleToggle() {
  observable.notify("User toggled switch");
}

export default function App() {
  return (
    <div className="App">
      <Button variant="contained" onClick={handleClick}>
        Click me!
      </Button>
      <FormControlLabel
        control={<Switch name="" onChange={handleToggle} />}
        label="Toggle me!"
      />
      <ToastContainer />
    </div>
  );
}
