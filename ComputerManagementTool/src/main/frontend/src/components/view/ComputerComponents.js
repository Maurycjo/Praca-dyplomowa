import React, {useEffect, useState} from 'react';
import {ReactTableScroll} from 'react-table-scroll';
import {Container} from "react-bootstrap";
import './Home.css'
import AdminHomeBar from "../bar/AdminHomeBar";
import axios from "axios";
import FormPopup from "../device_form/FormPopup";
import ComputerComponentsBar from "../bar/ComputerComponentsBar";

const ComputerComponents = () => {

    const [components, setComponents] = useState([]);
    const [selectedOption, setSelectedOption] = useState('cpus');


    const fetchData = (option) =>{
        let url;

        switch (option){

            case 'cpus':
                url = 'http://localhost:8080/cpus/all';
                break;
            case 'rams':
                url = 'http://localhost:8080/rams/all';
                break;
            case 'storages':
                url = 'http://localhost:8080/storages/all';
                break;
        }

        fetch(url)
            .then(response =>response.json())
            .then(data => setComponents(data))
            .catch(error => console.error("Error fetching data:",error));
    }

    useEffect(() => {
        fetchData(selectedOption);
    }, [selectedOption]);

    const headersMap ={

        cpus: ['ID', 'Nazwa', 'Cena'],
        rams: ['ID', 'Nazwa', 'Cena'],
        storages: ['ID', 'Nazwa', 'Cena'],
    };
    const renderDataForOption = (device) => {
                return (
                    <>
                        <td>{device.id}</td>
                        <td>{device.name}</td>
                        <td>{device.price} zł</td>
                        <td>
                            <button onClick={() => handleDelete(device.id, selectedOption)}>Usuń</button>
                        </td>
                        <td>
                            <button onClick={() => handleEdit(device.id)}>Modyfikuj</button>
                        </td>
                    </>
                );
    };

    const handleComponentChange = (selectedOption) => {
        setSelectedOption(selectedOption);
    };




    const handleDelete = (id, option) => {

        let url;

        switch (option){

            case 'cpus':
                url = `http://localhost:8080/cpus/${id}`;
                break;
            case 'rams':
                url = `http://localhost:8080/rams/${id}`;
                break;
            case 'storages':
                url = `http://localhost:8080/storages/${id}`;
                break;
        }



        fetch(url, {
            method: 'DELETE',
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((res) => {
                if (!res.ok) {
                    throw new Error('Wystąpił problem podczas usuwania');
                }
                return res.json();
            })
            .then((data) => {
                console.log('pomyślnie usunięte.');
            })
            .catch((err) => {
                console.error(err.message);
            });

        const updatedComponents = components.filter((component) => component.id !== id);
        setComponents(updatedComponents);
    };

    const handleEdit = (deviceId) => {

    };

    const handleInfo = (deviceId) => {

    };




    return (
        <Container>
            {/*<Sidebar onSidebarClick={handleSidebarClick} onAddComputerClick={handleAddComputerClick}/>*/}
            <div className="outer-position">

                <div className="header-block">
                    Komponenty sprzetu komputerowego
                </div>
                <div className="operation-block">

                    <ComputerComponentsBar onComponentChange={handleComponentChange}/>
                </div>
                <div className="table-container">
                    <ReactTableScroll className="styled-table">
                        <table className="device table styled-table">
                            <thead>
                            <tr key={selectedOption} className="table-header">
                                {headersMap[selectedOption].map((header, index) => (
                                    <td key={index}>{header}</td>
                                ))}
                                <td>Usuń</td>
                                <td>Modyfikuj</td>
                            </tr>
                            </thead>
                            <tbody>
                            {components.map((component) => (
                                <tr key={component.id}>
                                    {renderDataForOption(component, selectedOption)}
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

export default ComputerComponents;