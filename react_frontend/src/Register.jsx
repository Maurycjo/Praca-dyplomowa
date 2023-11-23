import React, { useState } from "react";

export const Register = (props) => {
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');
    const [confirmPass, setConfirmPass] = useState('');
    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [username, setUsername] = useState('');
    

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
    }

    return (
        <div className="auth-form-container">
            <h2>Zarejesturuj</h2>
        <form className="register-form" onSubmit={handleSubmit}>

            <div class ="row">
                <label htmlFor="name" >Imię</label>
                <input value={name} name="name" onChange={(e) => setName(e.target.value)} id="name" placeholder="Imię" />
            </div>

            <div class ="row">
                <label htmlFor="surname">Nazwisko</label>
                <input value={surname} name="sursurname" onChange={(e) => setSurname(e.target.value)} id="surname" placeholder="Nazwisko" />
            </div>

            <div class ="row">
                <label htmlFor="username">Nazwa użytkownika</label>
                <input value={username} username="username" onChange={(e) => setUsername(e.target.value)} id="username" placeholder="Nazwa użytkownika" />
            </div>

            <div class ="row">
                <label htmlFor="email" >Email</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)}type="email" placeholder="twójemail@example.com" id="email" name="email" />
            </div>

            <div class ="row">
                <label htmlFor="password">Hasło</label>
                <input value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="********" id="password" name="password" />
            </div>

            <div class ="row">
                <label htmlFor="confirmPassword">Powtórz hasło</label>
                <input value={confirmPass} onChange={(e) => setConfirmPass(e.target.value)} type="password" placeholder="********" id="confirmPassword" name="confirmPassword" />
            </div>

            <button type="submit">Zarejestruj</button>

            
        </form>
        <button className="link-btn" onClick={() => props.onFormSwitch('login')}>Masz już konto? Zaloguj się tutaj.</button>
    </div>
    )
}