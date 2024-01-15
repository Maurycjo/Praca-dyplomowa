import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from "axios";

const Register = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [username, setUsername] = useState('');
    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [confirmPass, setConfirmPass] = useState('');

    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();


        try {
            const response = await axios.post('http://localhost:8080/auth/register', {
                username: username,
                password: password,
                name: name,
                surname: surname,
                email: email
            });
        } catch (error) {

        }
    }

    return (
        <div>
            <form className="login-form">
                <h3>Zarejestruj się</h3>

                <div className="mb-4">
                    <label>Nazwa użytkownika</label>
                    <input
                        className="form-control"
                        placeholder="nazwa użytkownika"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </div>
                <div className="mb-4">
                    <label>Email address</label>
                    <input
                        className="form-control"
                        placeholder="twójemail@example.com"
                        value={email}
                        onChange={(e)=>setEmail(e.target.value)}
                    />
                </div>
                <div className="mb-4">
                    <label>Imię</label>
                    <input
                        className="form-control"
                        placeholder="imię"
                        value={name}
                        onChange={(e)=>setName(e.target.value)}
                    />
                </div>
                <div className="mb-4">
                    <label>Nazwisko</label>
                    <input
                        className="form-control"
                        placeholder="nazwisko"
                        value={surname}
                        onChange={(e)=>setSurname(e.target.value)}
                    />
                </div>

                <div className="mb-4">
                    <label>Hasło</label>
                    <input
                        type="password"
                        className="form-control"
                        placeholder="hasło"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>
                <div className="mb-4">
                    <label>Powtórz Hasło</label>
                    <input
                        type="password"
                        className="form-control"
                        placeholder="powtórz hasło"
                        value={confirmPass}
                        onChange={(e)=> setConfirmPass(e.target.value)}
                    />
                </div>
                <div>
                    <div>
                        <button className='btn-primary' onClick={handleSubmit}> Zarejestruj</button>
                    </div>
                    <div>
                        <Link to="/auth/login">Masz konto? Zaloguj się</Link>
                    </div>
                </div>
                <div className="mb-3">
                </div>
            </form>
        </div>



    );
}

export default Register;
