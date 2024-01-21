import React, {useEffect, useState} from 'react';
import AddNewFormPopup from "../device_form/AddNewFormPopup";
import {useNavigate} from 'react-router-dom'
const UserHomeBar = ({ onDeviceChange, onOfficeChange }) => {
    const [selectedString, setSelectedString] = useState('Wszystkie urządzenia');
    const deviceStringList = ['Wszystkie urządzenia', 'Komputery', 'Tablety', 'Inne urządzenia'];


    const [selectedOffice, setSelectedOffice] = useState({ id: -1, address: 'Wszystkie biura' });
    const [offices, setOffices] = useState([]);



    const [addComputerPopup, setAddComputerPopup] = useState(false);
    const navigate = useNavigate();

    const optionToStateMap = {
        'Wszystkie urządzenia': 'all',
        'Komputery': 'computer',
        'Tablety': 'tablet',
        'Inne urządzenia': 'other',
    };




    useEffect(()=>{

        fetch('http://localhost:8080/offices/all')
            .then(response => response.json())
            .then(data => setOffices(data))
            .catch(error => console.error("error fetching offices"));
    }, []);


    const handleSelectChange = (event) => {
        const selectedString = event.target.value;
        const selectedState = optionToStateMap[selectedString];
        setSelectedString(selectedString);
        onDeviceChange(selectedState);
    };

    const handleOfficeChange = (e) => {
        const { value } = e.target;
        const selectedOfficeObject = offices.find(office => office.id.toString() === value.toString());

        setSelectedOffice(selectedOfficeObject || { id: '-1', address: value });
        onOfficeChange(selectedOfficeObject ? selectedOfficeObject.id.toString() : '-1');
    }

    const handleDisplayLottery = (userId) =>{

        navigate('/user-lottery-history', {
            state:{
                userId: localStorage.getItem('user_id'),
            }
        });
    }

    const handleLogout = () =>{

        navigate("/auth/login");
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

            <select value={selectedOffice.id.toString()} onChange={handleOfficeChange}>
                <option value="-1">Wszystkie biura</option>
                {offices.map(office => (
                    <option key={office.id} value={office.id.toString()}>
                        Biuro {office.address}
                    </option>
                ))}
            </select>
            <button type="button" onClick={handleDisplayLottery}>Przeglądaj swoje loterie</button>
            <button type="logout" onClick={handleLogout}>Wyloguj</button>
        </div>
    );
};

export default UserHomeBar;
