import React, {useEffect, useState} from 'react';
import { ReactTableScroll } from 'react-table-scroll';
import { Container } from "react-bootstrap";
import './Home.css'
import Sidebar from "./Sidebar";
const Home = () => {

    const [devices, setDevices] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/devices/all')
            .then(response => response.json())
            .then(data => setDevices(data))
            .catch(error => console.error('Error fetching data:', error));
    }, []);

    const handleDelete = (deviceId) => {
        // Logika obsługi usuwania urządzenia o danym ID
        console.log(`Usuń urządzenie o ID: ${deviceId}`);
    };

    const handleEdit = (deviceId) => {
        // Logika obsługi edycji urządzenia o danym ID
        console.log(`Edytuj urządzenie o ID: ${deviceId}`);
    };

    const handleInfo = (deviceId) => {
        // Logika obsługi informacji o urządzeniu o danym ID
        console.log(`Informacje o urządzeniu o ID: ${deviceId}`);
    };

    return (
        <Container style={{ display: 'flex', justifyContent: 'space-between' }}>
            <div style={{display: 'flex', flexDirection: 'row', width: '100%'}}>
            <Sidebar/>
                <div className="table-container">
            <ReactTableScroll className="styled-table">
                <table
                    width="100%"
                    className="device table styled-table">
                    <thead>
                    <tr className="table-header">
                        <td width>ID</td>
                        <td width>Nazwa</td>
                        <td width>Cena</td>
                        <td width>Opis</td>
                        <td width>Biuro</td>
                        <td width>Gotowy do sprzedaży</td>
                        <td width>Akcja</td>


                    </tr>
                    </thead>

                    <tbody className>
                    {devices.map(device => (
                        <tr key={device.id}>
                            <td>{device.id}</td>
                            <td>{device.deviceName}</td>
                            <td>{device.price}zł</td>
                            <td>{device.description}</td>
                            <td>{device.office.address}</td>
                            <td>{device.readyToSell ? 'Tak' : 'Nie'}</td>
                            <td>
                                {/* Przyciski do działań */}
                                <button onClick={() => handleDelete(device.id)}>Usuń</button>
                                <button onClick={() => handleEdit(device.id)}>Modyfikuj</button>
                                <button onClick={() => handleInfo(device.id)}>Informacje</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </ReactTableScroll>
                </div>
            </div>
        </Container>
    );


};

export default Home;