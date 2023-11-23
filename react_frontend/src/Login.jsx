import React, { useState } from "react";

export const Login = (props) => {
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
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
            <button className="link-btn" onClick={() => props.onFormSwitch('register')}>Nie masz konta? Zarejestruj się</button>
        </div>
    )
}