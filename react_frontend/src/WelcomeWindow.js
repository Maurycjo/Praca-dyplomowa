import React from 'react';
import { Link } from 'react-router-dom';

const WelcomeWindow = () => {
  return (
    <div className="welcome-window">
      <h1>Witaj w systemie loterii sprzętu komputerowego!</h1>
      <Link to="/login">
        <button>Zaloguj</button>
      </Link>
      <Link to="/register">
        <button>Zarejestruj</button>
      </Link>
    </div>
  );
};

export default WelcomeWindow;
