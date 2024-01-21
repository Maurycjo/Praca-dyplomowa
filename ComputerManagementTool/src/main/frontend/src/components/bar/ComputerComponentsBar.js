import React, {useEffect, useState} from 'react';
import {useNavigate} from 'react-router-dom'
import CpuForm from "../computer_components/CpuForm";
import RamForm from "../computer_components/RamForm";
import StorageForm from "../computer_components/StorageForm";
const ComputerComponentBar = ({ onComponentChange}) => {
    const [selectedString, setSelectedString] = useState('Procesory');
    const componentsStringList = ['Procesory', 'RAM', 'Pamięci dyskowe'];

    const [addCpuPopup, setAddCpuPopup] = useState(false);
    const [addRamPopup, setAddRamPopup] = useState(false);
    const [addStoragePopup, setAddStoragePopup] = useState(false);


    const navigate = useNavigate();

    const optionToStateMap = {
        'Procesory': 'cpus',
        'RAM': 'rams',
        'Pamięci dyskowe': 'storages',
    };



    const handleSelectChange = (event) => {
        const selectedString = event.target.value;
        const selectedState = optionToStateMap[selectedString];
        setSelectedString(selectedString);
        onComponentChange(selectedState);
    };




    const handleAddCpu = () =>{
        setAddCpuPopup(true);
    };


    const handleAddRam = () =>{
        setAddRamPopup(true);
    };


    const handleAddStorage = () =>{
        setAddStoragePopup(true);
    };


    const handleDisplayDevices = () =>{
      navigate("/home");
    };
    const handleDisplayUsers = () =>{
        navigate("/users");
    };

    const handleLogout = () =>{

        navigate("/auth/login");
    }

    return (
        <div>
            <select value={selectedString} onChange={handleSelectChange}>
                {componentsStringList.map((option) => (
                    <option key={option} value={option}>
                        {option}
                    </option>
                ))}
            </select>

            <button type="button" onClick={handleDisplayDevices}>Urządzenia</button>
            <button type="button" onClick={handleAddCpu}>Dodaj procesor</button>
            <button type="button" onClick={handleAddRam}>Dodaj RAM</button>
            <button type="button" onClick={handleAddStorage}>Dodaj dysk</button>
            <button type="button" onClick={handleDisplayUsers}>Zarządzaj użytkownikami</button>
            <button type="logout" onClick={handleLogout}>Wyloguj</button>
            <CpuForm trigger={addCpuPopup} setTrigger={setAddCpuPopup}></CpuForm>
            <RamForm trigger={addRamPopup} setTrigger={setAddRamPopup}></RamForm>
            <StorageForm trigger={addStoragePopup} setTrigger={setAddStoragePopup}></StorageForm>
        </div>
    );
};

export default ComputerComponentBar;
