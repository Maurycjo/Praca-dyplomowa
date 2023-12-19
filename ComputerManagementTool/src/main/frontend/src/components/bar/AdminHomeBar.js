import React, { useState } from 'react';
import FormPopup from "../device_form/FormPopup";
import {useNavigate} from 'react-router-dom'
const AdminHomeBar = ({ onSidebarChange }) => {
    const [selectedString, setSelectedString] = useState('Wszystkie urządzenia');
    const stringList = ['Wszystkie urządzenia', 'Komputery', 'Tablety', 'Inne urządzenia'];
    const [addComputerPopup, setAddComputerPopup] = useState(false);
    const navigate = useNavigate();

    const optionToStateMap = {
        'Wszystkie urządzenia': 'all',
        'Komputery': 'computer',
        'Tablety': 'tablet',
        'Inne urządzenia': 'other',
    };

    const handleSelectChange = (event) => {
        const selectedString = event.target.value;
        const selectedState = optionToStateMap[selectedString];
        setSelectedString(selectedString);
        onSidebarChange(selectedState);
    };

    const handleAddComputer = () =>{
        setAddComputerPopup(true)
    };

    const handleDisplayUsers = () =>{
      navigate("/users");
    };


    return (
        <div>
            <select value={selectedString} onChange={handleSelectChange}>
                {stringList.map((option) => (
                    <option key={option} value={option}>
                        {option}
                    </option>
                ))}
            </select>
            <button type="button" onClick={handleAddComputer}>Dodaj urządzenie</button>
            <button type="button" onClick={handleDisplayUsers}>Zarządzaj użytkownikami</button>
            <FormPopup trigger={addComputerPopup} setTrigger={setAddComputerPopup}></FormPopup>
        </div>
    );
};

export default AdminHomeBar;