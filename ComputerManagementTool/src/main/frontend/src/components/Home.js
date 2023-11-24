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



    return (
        <Container fluid className="p-5">
            <ReactTableScroll className="styled-table">
                <table
                    width="100%"
                    className="device table styled-table"
                >
                    <thead>
                    <tr className="table-header">
                        <td width>ID</td>
                        <td width>Nazwa</td>
                        <td width>Cena</td>
                        <td width>Opis</td>
                        <td width>Biuro</td>
                        <td width>Gotowy do sprzedaży</td>
                    </tr>
                    </thead>

                    <tbody>
                    {devices.map(device => (
                        <tr key={device.id}>
                            <td>{device.id}</td>
                            <td>{device.deviceName}</td>
                            <td>{device.price}</td>
                            <td>{device.description}</td>
                            <td>{device.office.address}</td>
                            <td>{device.readyToSell ? 'Tak' : 'Nie'}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </ReactTableScroll>

        </Container>
    );


};

export default Home;