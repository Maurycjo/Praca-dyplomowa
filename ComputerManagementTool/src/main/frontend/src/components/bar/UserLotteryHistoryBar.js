import React, {useEffect, useState} from 'react';
import AddNewFormPopup from "../device_form/AddNewFormPopup";
import {useNavigate} from 'react-router-dom'
const UserLotteryHistoryBar = ({ onOptionChange}) => {
    const [selectedString, setSelectedString] = useState('Wszystkie Loterie użytkownika');
    const deviceStringList = ['Wszystkie Loterie użytkownika', 'Wygrane', 'Trwające'];


    const navigate = useNavigate();



    const optionToStateMap = {
        'Wszystkie Loterie użytkownika': 'all',
        'Wygrane': 'wins',
        'Trwające': 'pending',
    };



    const handleSelectChange = (event) => {
        const selectedString = event.target.value;
        const selectedState = optionToStateMap[selectedString];
        setSelectedString(selectedString);
        onOptionChange(selectedState);
    };


    const handleBackToHome = () =>{
        navigate("/home");
    }


    return (
        <div>
            <select value={selectedString} onChange={handleSelectChange}>
                {deviceStringList.map((option) => (
                    <option key={option} value={option}>
                        {option}
                    </option>
                ))}
            </select>


            <button type="button" onClick={handleBackToHome}>Powrót</button>
        </div>
    );
};

export default UserLotteryHistoryBar;
