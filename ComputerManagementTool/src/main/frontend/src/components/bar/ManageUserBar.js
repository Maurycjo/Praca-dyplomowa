import React, { useState } from 'react';
import {useNavigate} from 'react-router-dom'
const ManageUserBar = ({ onSidebarChange }) => {

    const navigate = useNavigate();

    const handleBackToDevices = () =>{
        navigate('/home');
    }

    const handleLogout = () =>{

        navigate("/auth/login");
    }



    return (
        <div>
            <button type="button" onClick={handleBackToDevices}>Powrót do urządzeń</button>
            <button type="logout" onClick={handleLogout}>Wyloguj</button>
        </div>
    );
};

export default ManageUserBar;
