import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

export const Login = (props) => {
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
    }

    const handleRegister = () =>{

        props.onFormSwitch('register')
        navigate('/auth/register')
    }

    return (
        
        <div className="auth-form-container">
            <h2>Zaloguj</h2>
            <form className="login-form" onSubmit={handleSubmit}>
                <label htmlFor="email">Nazwa uzytkownika lub email</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)} placeholder="twójemail@example.com" id="email" name="email" />
                <label htmlFor="password">Hasło</label>
                <input value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="************" id="password" name="password" />
                <button type="submit">Zaloguj</button>
            </form>
            <button className="link-btn" onClick={handleRegister}>Nie masz konta? Zarejestruj się</button>
        </div>
    )
}