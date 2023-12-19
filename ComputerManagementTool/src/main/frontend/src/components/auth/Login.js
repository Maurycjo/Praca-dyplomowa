import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './Login.css'
import './../device_form/FormPopup'

import axios from 'axios';
const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();
    const [showError, setShowError] = useState(false);


    const handleSubmit = async (e) => {
        e.preventDefault();


        navigate('/home');

        // try {
        //     const response = await axios.post('http://localhost:8080/login', {
        //         name: username,
        //         password: password,
        //     });
        //
        //     if(response.data.token){
        //         sessionStorage.setItem('authToken', response.data.token);
        //         localStorage.setItem('isAdmin', response.data.is_superuser);
        //         localStorage.setItem("user_id", response.data.user_id)
        //
        //         console.log(response.data.is_superuser);
        //         navigate('/home');
        //     }
        //
        //
        // } catch (error) {
        //     setShowError(true);
        // }
    };




    return (
        <div>
        <form className="login-form">
            <h3>Zaloguj się</h3>


            <div className="mb-3">
                <label>Nazwa użytkownika</label>
                <input
                    className="form-control"
                    placeholder="username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
            </div>
            <div className="mb-3">
                <label>Hasło</label>
                <input
                    type="password"
                    className="form-control"
                    placeholder="Hasło"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
            </div>
            <div>
                <div>
                    <button className='btn-primary' onClick={handleSubmit}> Zaloguj</button>
                </div>
                <div>
                    <Link to="/auth/register">Nie masz konta? Zarejestruj się</Link>
                </div>
            </div>
            <div className="mb-3">
            </div>
        </form>
        </div>


    );
};

export default Login;
