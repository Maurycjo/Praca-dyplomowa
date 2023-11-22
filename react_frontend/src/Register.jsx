import React, {useState} from "react";

export const Register  = (props) => {

    const[username, setUsername] = useState('');
    const[email, setEmail] = useState('');
    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [pass, setPass] = useState('');
    const [confirmPass, setConfirmPass] = useState('');


    const handleSubmit = (e) =>{
        e.preventDefault();
        console.log(email);
    }


    return (

        <>
        
        
        <form onSubmit={handleSubmit}>
            <label for = "Username">Nazwa użytkownika</label>
            <input value={username} onChange={(e) => setUsername(e.target.value)} placeholder="Nazwa użytkownika" id="username" name = "username"/>

            <label for = "Name">Imię</label>
            <input value={name} onChange={(e) => setName(e.target.value)} placeholder="Imię" id="name" name = "name"/>

            <label for = "Surname">Nazwisko</label>
            <input value={surname} onChange={(e) => setSurname(e.target.value)} placeholder="Nazwisko" id="surname" name = "surname"/>

            <label for = "Email">Email</label>
            <input value={email} onChange={(e) => setEmail(e.target.value)} placeholder="youremail@gmail.com" id="email" name = "email"/>

            <label for = "Password">Hasło</label>
            <input value={pass} onChange={(e) => setPass(e.target.value)} placeholder="**************" id="password" name = "password"/>

            <label for = "ConfirmPassword">Powtórz Hasło</label>
            <input value={confirmPass} onChange={(e) => setConfirmPass(e.target.value)} placeholder="**************" id="confirmPassowrd" name = "confirmPassword"/>

        </form>
        <button onClick={() => props.onFormSwitch('login')}> Masz konto? Zaloguj się</button>
        </>
    )
}