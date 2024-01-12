import React, {useEffect, useState} from 'react';
import {ReactTableScroll} from 'react-table-scroll';
import {Container} from "react-bootstrap";
import './Home.css'
import AdminHomeBar from "../bar/AdminHomeBar";
import axios from "axios";
import FormPopup from "../device_form/FormPopup";

const Home = () => {

    const [devices, setDevices] = useState([]);
    const [selectedOption, setSelectedOption] = useState('all');
    const [selectedOffice, setSelectedOffice] =useState('-1');

    const [deviceFormPopup, setDeviceFormPopup] =useState(false);
    const [currentDeviceType, setCurrentDeviceType] = useState('');
    const [currentDeviceId, setCurrentDeviceId] = useState(0);
    const [currentFormType, setCurrentFormType] = useState('');

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
                const devices = response.data;

                // Pobierz status uczestnictwa w loterii dla każdego urządzenia
                const fetchLotteryStates = devices.map(device =>
                    axios.get(`http://localhost:8080/participation/state/${device.id}`)
                        .then(response => response.data)
                        .catch(error => {
                            console.error(`Błąd pobierania stanu loterii dla urządzenia o ID ${device.id}:`, error);
                            return 'Błąd pobierania stanu loterii';
                        })
                );

                // Po zakończeniu wszystkich żądań, ustaw stan urządzeń i stanów loterii
                Promise.all(fetchLotteryStates)
                    .then(lotteryStates => {
                        setDevices(devices.map((device, index) => ({
                            ...device,
                            lotteryState: lotteryStates[index]
                        })));
                    })
                    .catch(error => {
                        console.error('Błąd przy pobieraniu stanów loterii dla urządzeń:', error);
                    });
            })
            .catch(error => {
                console.error("Błąd pobierania danych:", error);
            });


    }

    useEffect(() => {
        fetchData(selectedOption, selectedOffice);
    }, [selectedOption, selectedOffice]);

    const headersMap ={
        all: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Gotowy do sprzedaży', 'Czy sprzedany'],
        computer: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Gotowy do sprzedaży','Czy sprzedany', 'Numer seryjny', 'System', 'Bateria', 'Model', 'Procesor', 'Pamięć', 'Ram'],
        tablet: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Gotowy do sprzedaży','Czy sprzedany','Ekran', 'System', 'Bateria'],
        other: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Gotowy do sprzedaży','Czy sprzedany','Dodatkowy opis'],
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
                            {device.readyToSell ? 'Tak' : 'Nie'}
                            <button onClick={() => handleSetReadyToSell(device.id, device.readyToSell)}>Zmień</button>
                        </td>
                        <td>{device.sold ? 'Tak' : 'Nie'}</td>
                        <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>
                        <td>{device.lotteryState}</td>

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
                        <td>{device.sold ? 'Tak' : 'Nie'}</td>
                        <td>{device.serialNumber}</td>
                        <td>{device.operatingSystem}</td>
                        <td>{device.batteryLife}</td>
                        <td>{device.model}</td>
                        <td>{device.cpu ? device.cpu.name : 'Brak'}</td>
                        <td>{device.storage ? device.storage.name : 'Brak'}</td>
                        <td>{device.ram ? device.storage.name : 'Brak'}</td>
                        <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>
                        {device.sold ===false &&(
                            <td><button onClick={() => handleCreateLottery(device.id)}>Utwórz</button></td>
                        )}
                        {device.sold ===true &&(
                            <td><button onClick={() => handleManageLottery(device.id)}>Zarządzaj</button></td>
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
                        <td>{device.readyToSell ? 'Tak' : 'Nie'}</td>
                        <td>{device.sold ? 'Tak' : 'Nie'}</td>
                        <td>{device.screenSize}</td>
                        <td>{device.operatingSystem}</td>
                        <td>{device.batteryLife}</td>
                        <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>
                        {device.sold ===false &&(
                            <td><button onClick={() => handleCreateLottery(device.id)}>Utwórz</button></td>
                        )}
                        {device.sold ===true &&(
                            <td><button onClick={() => handleManageLottery(device.id)}>Zarządzaj</button></td>
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
                        <td>{device.readyToSell ? 'Tak' : 'Nie'}</td>
                        <td>{device.sold ? 'Tak' : 'Nie'}</td>
                        <td>{device.additionalInfo}</td>
                        <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>
                        {device.sold ===false &&(
                            <td><button onClick={() => handleCreateLottery(device.id)}>Utwórz</button></td>
                        )}
                        {device.sold ===true &&(
                            <td><button onClick={() => handleManageLottery(device.id)}>Zarządzaj</button></td>
                        )}


                    </>
                );
            default:
                return null;
        }
    };

    const handleCreateLottery = (deviceId) => {

    };

    const handleManageLottery = (deviceId) =>{

        return axios.get(`http://localhost:8080/participation/state/${deviceId}`)
            .then(response => {
            return response.data;
        })
        .catch(error => {
            return 'Error'
        });


    }

    const handleCheckLotteryStatusForDevice = (deviceId) =>{

    }

    const handleDeviceChange = (selectedOption) => {
        setSelectedOption(selectedOption);
    };
    const handleOfficeChange = (selectedOffice) =>{
      setSelectedOffice(selectedOffice);
    };
    const handleSetReadyToSell = (deviceId, isReady) =>{

        const endpoint = isReady
            ? `http://localhost:8080/devices/set-not-ready-to-sell/${deviceId}`
            : `http://localhost:8080/devices/set-ready-to-sell/${deviceId}`

        axios.put(endpoint)
            .then(response => {
                setDevices(prevDevices => {
                    return prevDevices.map(device => {
                        if (device.id === deviceId) {
                            return {...device, readyToSell: !isReady};
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