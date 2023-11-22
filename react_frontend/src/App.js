import React, {useState} from "react";


import { Login } from "./Login";
import { Register } from "./Register";

function App()  {

  const [currentForm, setCurrentForm] = useState('login');

  const toogleForm = (formName) =>{
    setCurrentForm(formName);
  }

  return (
    <div className='App'>
      {
        currentForm === "login" ? <Login onFormSwitch={toogleForm}/> : <Register onFormSwitch={toogleForm}/>

      }
    </div>
  );
}

export default App;
