import React, { useState } from 'react';
import {useNavigate} from 'react-router-dom'
const ManageUserBar = ({ onSidebarChange }) => {

    const navigate = useNavigate();

    const handleBackToDevices = () =>{
        navigate('/home');
    }




    return (
        <div>
            <button type="button" onClick={handleBackToDevices}>Powrót do urządzeń</button>
        </div>
    );
};

export default ManageUserBar;
