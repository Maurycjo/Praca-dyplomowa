import React, {useState} from "react";

export const Login  = (props) => {

    const[email, setEmail] = useState('');
    const [pass, setPass] = useState('');

    const handleSubmit = (e) =>{
        e.preventDefault();
        console.log(email);
    }

    return (
        <>        
            <form onSubmit={handleSubmit}>
                <label htmlfor="nazwa użytkownika lub email">Login lub Email</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)} placeholder="youremail@gmail.com" id="email" name = "email"/>
                <label htmlfor="password">Hasło</label>
                <input value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="********" id="password" name = "password"/>
                <button type="submit">Zaloguj</button>

            </form>
            <button onClick={() => props.onFormSwitch('register')}>Nie masz konta? Zarejestruj się</button>
        </>
    )
}