import React, { useState } from "react";
import { ReactDOM } from "react-dom/client";
import { BrowserRouter as Router, Route, Routes, BrowserRouter } from "react-router-dom";
import './App.css';
import { Login } from "./Login";
import { Register } from "./Register";
import { useNavigate } from "react-router-dom/dist/umd/react-router-dom.development";

function Home() {
  return <div>Tu nie ma nic ciekawego!!</div>;
}

function App() {
  const [currentForm, setCurrentForm] = useState('login');
  const navigate = useNavigate();

  const toggleForm = (formName) => {
    setCurrentForm(formName);
  }

  // return (
  //   <div className="App">
  //     {
  //       currentForm === "login" ? <Login onFormSwitch={toggleForm} /> : <Register onFormSwitch={toggleForm} />
          
  //     }
  //   </div>
  // );

  return (
      <div className="App">
        <Routes>
          <Route path="/auth/login" element={<Login onFormSwitch={toggleForm} navigate = {navigate} />} />
          <Route path="/auth/register" element={<Register onFormSwitch={toggleForm} navigate = {navigate}/>} />
          <Route path="/" element={<Home />} />
        </Routes>
      </div>
    
  );

}

export default App;