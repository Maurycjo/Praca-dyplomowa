import React, { useState } from 'react';
import FormPopup from "./FormPopup";

const Sidebar = ({ onSidebarChange }) => {
    const [selectedString, setSelectedString] = useState('Wszystkie urządzenia');
    const stringList = ['Wszystkie urządzenia', 'Komputery', 'Tablety', 'Inne urządzenia'];
    const [addComputerPopup, setAddComputerPopup] = useState(false);

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
            <FormPopup trigger={addComputerPopup} setTrigger={setAddComputerPopup}></FormPopup>
        </div>
    );
};

export default Sidebar;
