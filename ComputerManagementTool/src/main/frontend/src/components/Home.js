import React, {useEffect, useState} from 'react';
import { ReactTableScroll } from 'react-table-scroll';
import { Container } from "react-bootstrap";
import './Home.css'
import Sidebar from "./Sidebar";
import SidebarUserConfig from "./SidebarUserConfig";
import {selectOptions} from "@testing-library/user-event/dist/select-options";
const Home = () => {

    const [devices, setDevices] = useState([]);
    const [selectedOption, setSelectedOption] = useState('all');
    const fetchData = (option) =>{
        let url;

        switch (option){

            case 'all':
                url = 'http://localhost:8080/devices/all';
                break;
            case 'computer':
                url = 'http://localhost:8080/computers/all';
                break;
            case 'tablet':
                url = 'http://localhost:8080/tablets/all';
                break;
            case 'other':
                url = 'http://localhost:8080/other-devices/all';
                break;
            default:
                url = 'http://localhost:8080/devices/all';
        }

        fetch(url)
            .then(response =>response.json())
            .then(data => setDevices(data))
            .catch(error => console.error("Error fetchin data:",error));
    }

    const headersMap ={
      all: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Gotowy do sprzedaży'],
        computer: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Gotowy do sprzedaży', 'Numer seryjny', 'System', 'Bateria', 'Model', 'Procesor', 'Pamięć', 'Ram'],
        tablet: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Gotowy do sprzedaży','Ekran', 'System', 'Bateria'],
        other: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Gotowy do sprzedaży','Dodatkowy opis'],
    };

    const handleSidebarClick = (selectedOption) => {
        setSelectedOption(selectedOption);
    };

    const renderDataForOption = (device, option) => {
        switch (option) {
            case 'all':
                return (
                    <>
                        <td>{device.id}</td>
                        <td>{device.deviceName}</td>
                        <td>{device.price} zł</td>
                        <td>{device.description}</td>
                        <td>{device.age}</td>
                        <td>{device.office.address}</td>
                        <td>{device.readyToSell ? 'Tak' : 'Nie'}</td>
                        <td>
                            <button onClick={() => handleDelete(device.id)}>Usuń</button>
                            <button onClick={() => handleEdit(device.id)}>Modyfikuj</button>
                            <button onClick={() => handleInfo(device.id)}>Informacje</button>
                        </td>
                    </>
                );
            case 'computer':
                return (
                    <>
                        <td>{device.id}</td>
                        <td>{device.deviceName}</td>
                        <td>{device.price} zł</td>
                        <td>{device.description}</td>
                        <td>{device.age}</td>
                        <td>{device.office.address}</td>
                        <td>{device.readyToSell ? 'Tak' : 'Nie'}</td>
                        <td>{device.serialNumber}</td>
                        <td>{device.operatingSystem}</td>
                        <td>{device.batteryLife}</td>
                        <td>{device.model}</td>
                        <td>{device.cpu ? device.cpu.name : 'Brak'}</td>
                        <td>{device.storage ? device.storage.name : 'Brak'}</td>
                        <td>{device.ram ? device.storage.name : 'Brak'}</td>
                        <td>
                            <button onClick={() => handleDelete(device.id)}>Usuń</button>
                            <button onClick={() => handleEdit(device.id)}>Modyfikuj</button>
                            <button onClick={() => handleInfo(device.id)}>Informacje</button>
                        </td>
                    </>
                );
            case 'tablet':

                return (
                    <>
                        <td>{device.id}</td>
                        <td>{device.deviceName}</td>
                        <td>{device.price} zł</td>
                        <td>{device.description}</td>
                        <td>{device.age}</td>
                        <td>{device.office.address}</td>
                        <td>{device.readyToSell ? 'Tak' : 'Nie'}</td>
                        <td>{device.screenSize}</td>
                        <td>{device.operatingSystem}</td>
                        <td>{device.batteryLife}</td>
                        <td>
                            <button onClick={() => handleDelete(device.id)}>Usuń</button>
                            <button onClick={() => handleEdit(device.id)}>Modyfikuj</button>
                            <button onClick={() => handleInfo(device.id)}>Informacje</button>
                        </td>
                    </>
                );
            case 'other':
                return (
                    <>
                        <td>{device.id}</td>
                        <td>{device.deviceName}</td>
                        <td>{device.price} zł</td>
                        <td>{device.description}</td>
                        <td>{device.age}</td>
                        <td>{device.office.address}</td>
                        <td>{device.readyToSell ? 'Tak' : 'Nie'}</td>
                        <td>{device.additionalInfo}</td>
                        <td>
                            <button onClick={() => handleDelete(device.id)}>Usuń</button>
                            <button onClick={() => handleEdit(device.id)}>Modyfikuj</button>
                            <button onClick={() => handleInfo(device.id)}>Informacje</button>
                        </td>
                    </>
                );
            default:
                return null;
        }
    };


    useEffect(() => {
        fetchData(selectedOption);
    }, [selectedOption]);

    const handleDelete = (deviceId) => {
        console.log(`Usuń urządzenie o ID: ${deviceId}`);
    };

    const handleEdit = (deviceId) => {
        console.log(`Edytuj urządzenie o ID: ${deviceId}`);
    };

    const handleInfo = (deviceId) => {
        console.log(`Informacje o urządzeniu o ID: ${deviceId}`);
    };

    return (
        <Container className="container">
                <Sidebar onSidebarClick={handleSidebarClick}/>
                <div className="table-container">
                    <ReactTableScroll className="styled-table">
                        <table className="device table styled-table">
                            <thead>
                            <tr key={selectedOption} className="table-header">
                                {headersMap[selectedOption].map((header, index) => (
                                    <td key={index}>{header}</td>
                                ))}
                                <td>Akcja</td>
                            </tr>
                            </thead>
                            <tbody>
                            {devices.map((device) => (
                                <tr key={device.id}>
                                    {renderDataForOption(device, selectedOption)}
                                </tr>
                            ))}
                            </tbody>
                        </table>
                    </ReactTableScroll>
                </div>
                <SidebarUserConfig/>
        </Container>
    );


};

export default Home;