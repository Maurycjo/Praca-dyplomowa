import React, {useEffect, useState} from 'react';
import {ReactTableScroll} from 'react-table-scroll';
import {Container} from "react-bootstrap";
import './Home.css'
import AdminHomeBar from "../bar/AdminHomeBar";
import axios from "axios";
import FormPopup from "../device_form/FormPopup";
import { Link, useNavigate } from 'react-router-dom';

const Home = () => {





    const [devices, setDevices] = useState([]);
    const [selectedOption, setSelectedOption] = useState('all');
    const [selectedOffice, setSelectedOffice] =useState('-1');

    const [deviceFormPopup, setDeviceFormPopup] =useState(false);
    const [currentDeviceType, setCurrentDeviceType] = useState('');
    const [currentDeviceId, setCurrentDeviceId] = useState(0);
    const [currentFormType, setCurrentFormType] = useState('');

    const navigate = useNavigate();

    const fetchData = (option, office) =>{
        let url;

        switch (option){

            case 'all':
                if(office==='-1'){
                    url = 'http://localhost:8080/devices/all';
                } else{
                    url =`http://localhost:8080/devices/by-office/${office}`;
                }
                break;
            case 'computer':
                if(office==='-1'){
                    url = 'http://localhost:8080/computers/all';
                }else{
                    url = `http://localhost:8080/computers/by-office/${office}`;
                }
                break;
            case 'tablet':
                if(office==='-1'){
                    url = 'http://localhost:8080/tablets/all';
                } else{
                    url = `http://localhost:8080/tablets/by-office/${office}`;
                }
                break;
            case 'other':
                if(office==='-1'){
                    url = 'http://localhost:8080/other-devices/all';
                } else{
                    url = `http://localhost:8080/other-devices/by-office/${office}`;
                }
                break;
            default:
                if(office==='-1'){
                    url = 'http://localhost:8080/devices/all';
                } else{
                    url =`http://localhost:8080/devices/by-office/${office}`;
                }

        }

        axios.get(url)
            .then(response => {
                setDevices(response.data);
            })
            .catch(error => {
                console.error("Błąd pobierania danych:", error);
            });


    }

    useEffect(() => {
        fetchData(selectedOption, selectedOffice);
    }, [selectedOption, selectedOffice]);

    const headersMap ={
        all: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Gotowy do Losowania', 'Czy sprzedany'],
        computer: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Numer seryjny', 'System', 'Bateria', 'Model', 'Procesor', 'Pamięć', 'Ram','Gotowy do losowania','Czy sprzedany',],
        tablet: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro','Ekran', 'System', 'Bateria', 'Gotowy do losowania','Czy sprzedany',],
        other: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro','Dodatkowy opis', 'Gotowy do losowania','Czy sprzedany',],
        cpu: ['ID', 'Nazwa', 'Cena'],
        ram: ['ID', 'Nazwa', 'Cena'],
        storage: ['ID', 'Nazwa', 'Cena'],
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
                        <td>
                            {device.readyToLottery ? 'Tak' : 'Nie'}
                            <button onClick={() => handleSetReadyToLottery(device.id, device.readyToLottery)}>Zmień</button>
                        </td>
                        <td>
                            {device.ordered ? 'Tak' : 'Nie'}
                            <button onClick={() => handleSetOrdered(device.id, device.ordered)}>Zmień</button>
                        </td>
                        <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>
                        <td><button onClick={() => handleDisplayUsersFromLottery(device.id)}>Wyświetl</button> </td>


                        {device.lotteryDate!==null ? (

                            <td>{device.lotteryDate}</td>

                        ) : device.readyToLottery===true ? (
                            <td><button onClick={() => handleCreateLottery(device.id)}>Losuj</button> </td>
                        ) : (
                            <td>Oczekuje na zatwierdzenie</td>
                            )


                        }

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
                        <td>{device.serialNumber}</td>
                        <td>{device.operatingSystem}</td>
                        <td>{device.batteryLife}</td>
                        <td>{device.model}</td>
                        <td>{device.cpu ? device.cpu.name : 'Brak'}</td>
                        <td>{device.storage ? device.storage.name : 'Brak'}</td>
                        <td>{device.ram ? device.storage.name : 'Brak'}</td>
                        <td>
                            {device.readyToLottery ? 'Tak' : 'Nie'}
                            <button onClick={() => handleSetReadyToLottery(device.id, device.readyToLottery)}>Zmień</button>
                        </td>
                        <td>
                            {device.ordered ? 'Tak' : 'Nie'}
                            <button onClick={() => handleSetOrdered(device.id, device.ordered)}>Zmień</button>
                        </td>

                        <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>
                        <td><button onClick={() => handleDisplayUsersFromLottery(device.id)}>Wyświetl</button> </td>
                        {device.lotteryDate===null ? (
                            <td><button onClick={() => handleCreateLottery(device.id)}>Losuj</button> </td>
                        ) : (
                            <td>{device.lotteryDate}</td>
                        )}

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
                        <td>{device.readyToLottery ? 'Tak' : 'Nie'}</td>
                        <td>{device.screenSize}</td>
                        <td>{device.operatingSystem}</td>
                        <td>{device.batteryLife}</td>
                        <td>
                            {device.readyToLottery ? 'Tak' : 'Nie'}
                            <button onClick={() => handleSetReadyToLottery(device.id, device.readyToLottery)}>Zmień</button>
                        </td>
                        <td>
                            {device.ordered ? 'Tak' : 'Nie'}
                            <button onClick={() => handleSetOrdered(device.id, device.sold)}>Zmień</button>
                        </td>
                        <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>
                        <td><button onClick={() => handleDisplayUsersFromLottery(device.id)}>Wyświetl</button> </td>
                        {device.lotteryDate===null ? (
                            <td><button onClick={() => handleCreateLottery(device.id)}>Losuj</button> </td>
                        ) : (
                            <td>{device.lotteryDate}</td>
                        )}
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
                        <td>{device.additionalInfo}</td>
                        <td>
                            {device.readyToLottery ? 'Tak' : 'Nie'}
                            <button onClick={() => handleSetReadyToLottery(device.id, device.readyToLottery)}>Zmień</button>
                        </td>
                        <td>
                            {device.ordered ? 'Tak' : 'Nie'}
                            <button onClick={() => handleSetOrdered(device.id, device.ordered)}>Zmień</button>
                        </td>
                        <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>
                        <td><button onClick={() => handleDisplayUsersFromLottery(device.id)}>Wyświetl</button> </td>
                        {device.lotteryDate===null ? (
                            <td><button onClick={() => handleCreateLottery(device.id)}>Losuj</button> </td>
                        ) : (
                            <td>{device.lotteryDate}</td>
                        )}

                    </>
                );
            default:
                return null;
        }
    };

    const handleCreateLottery = (deviceId) => {


    };

    const handleSetOrdered = (deviceId, isSold) =>{

        const endpoint = isSold
            ? `http://localhost:8080/devices/set-not-ordered/${deviceId}`
            : `http://localhost:8080/devices/set-ordered/${deviceId}`

        axios.put(endpoint)
            .then(response => {
                setDevices(prevDevices => {
                    return prevDevices.map(device => {
                        if (device.id === deviceId) {
                            return {...device, ordered: !isSold};
                        }
                        return device;
                    });
                });
            })
            .catch(error => {
                console.error("Error setting ordered:", error);
            });
    }

    const handleDeviceChange = (selectedOption) => {
        setSelectedOption(selectedOption);
    };
    const handleOfficeChange = (selectedOffice) =>{
      setSelectedOffice(selectedOffice);
    };
    const handleSetReadyToLottery = (deviceId, isReady) =>{

        const endpoint = isReady
            ? `http://localhost:8080/devices/set-not-ready-to-lottery/${deviceId}`
            : `http://localhost:8080/devices/set-ready-to-lottery/${deviceId}`

        axios.put(endpoint)
            .then(response => {
                setDevices(prevDevices => {
                    return prevDevices.map(device => {
                        if (device.id === deviceId) {
                            return {...device, readyToLottery: !isReady};
                        }
                        return device;
                    });
                });
            })
            .catch(error => {
                console.error("Error setting ready to sell:", error);
            });

    };


    const handleDelete = (deviceId) => {

        fetch(`http://localhost:8080/devices/${deviceId}`, {
            method: 'DELETE',
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((res) => {
                if (!res.ok) {
                    throw new Error('Wystąpił problem podczas usuwania urządzenia.');
                }
                return res.json();
            })
            .then((data) => {
                console.log('Urządzenie zostało pomyślnie usunięte.');
            })
            .catch((err) => {
                console.error(err.message);
            });

        const updatedDevices = devices.filter((device) => device.id !== deviceId);
        setDevices(updatedDevices);
    };

    const handleEdit = (deviceId, deviceType) => {
        setCurrentDeviceId(deviceId);
        setCurrentDeviceType(deviceType);
        setCurrentFormType("modify")
        setDeviceFormPopup(true);
    };

    const handleInfo = (deviceId, deviceType) => {

        setCurrentDeviceId(deviceId);
        setCurrentDeviceType(deviceType);
        setCurrentFormType("information")
        setDeviceFormPopup(true);
    };

    const handleDisplayUsersFromLottery = (deviceId) =>{

        navigate(`/users-in-lottery`, {
            state:{
                deviceId: deviceId,
            }
        });

    };

    return (
        <Container>
                {/*<Sidebar onSidebarClick={handleSidebarClick} onAddComputerClick={handleAddComputerClick}/>*/}
            <div className="outer-position">

                <div className="header-block">
                    Zarządzanie sprzętem komputerowym
                </div>
                <div className="operation-block">
                    <FormPopup trigger={deviceFormPopup} setTrigger={setDeviceFormPopup} deviceType={currentDeviceType} deviceId={currentDeviceId} formType={currentFormType}></FormPopup>
                    <AdminHomeBar onDeviceChange={handleDeviceChange} onOfficeChange={handleOfficeChange}/>
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
                                <td>Informacje</td>
                                <td>Lista uczestników</td>
                                <td>Loteria</td>
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
            </div>
                {/*<SidebarUserConfig/>*/}
            {/*<AddNewFormPopup trigger={addComputerPopup} setTrigger={setAddComputerPopup}></AddNewFormPopup>*/}
        </Container>
    );


};

export default Home;