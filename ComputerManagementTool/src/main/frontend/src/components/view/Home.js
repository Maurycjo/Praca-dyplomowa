import React, {useEffect, useState} from 'react';
import {ReactTableScroll} from 'react-table-scroll';
import {Container} from "react-bootstrap";
import './Home.css'
import AdminHomeBar from "../bar/AdminHomeBar";
import axios from "axios";
import FormPopup from "../device_form/FormPopup";
import {Link, useLocation, useNavigate} from 'react-router-dom';
import UserHomeBar from "../bar/UserHomeBar";

const Home = () => {

    const isAdmin = localStorage.getItem("role")==="ADMIN";
    const userId = localStorage.getItem("user_id");


    const [devices, setDevices] = useState([]);
    const [selectedOption, setSelectedOption] = useState('all');
    const [selectedOffice, setSelectedOffice] =useState('-1');

    const [deviceFormPopup, setDeviceFormPopup] =useState(false);
    const [currentDeviceType, setCurrentDeviceType] = useState('');
    const [currentDeviceId, setCurrentDeviceId] = useState(0);
    const [currentFormType, setCurrentFormType] = useState('');

    const navigate = useNavigate();

    const fetchData = async (option, office) => {
        let url;


        if (isAdmin) {
            switch (option) {

                case 'all':
                    if (office === '-1') {
                        url = 'http://localhost:8080/devices/all';
                    } else {
                        url = `http://localhost:8080/devices/by-office/${office}`;
                    }
                    break;
                case 'computer':
                    if (office === '-1') {
                        url = 'http://localhost:8080/computers/all';
                    } else {
                        url = `http://localhost:8080/computers/by-office/${office}`;
                    }
                    break;
                case 'tablet':
                    if (office === '-1') {
                        url = 'http://localhost:8080/tablets/all';
                    } else {
                        url = `http://localhost:8080/tablets/by-office/${office}`;
                    }
                    break;
                case 'other':
                    if (office === '-1') {
                        url = 'http://localhost:8080/other-devices/all';
                    } else {
                        url = `http://localhost:8080/other-devices/by-office/${office}`;
                    }
                    break;
                default:
                    if (office === '-1') {
                        url = 'http://localhost:8080/devices/all';
                    } else {
                        url = `http://localhost:8080/devices/by-office/${office}`;
                    }

            }
        } else {

            switch (option) {

                case 'all':
                    if (office === '-1') {
                        url = 'http://localhost:8080/devices/all-ready-to-lottery';
                    } else {
                        url = `http://localhost:8080/devices/all-ready-to-lottery-by-officeId/${office}`;
                    }
                    break;
                case 'computer':
                    if (office === '-1') {
                        url = 'http://localhost:8080/computers/all-ready-to-lottery';
                    } else {
                        url = `http://localhost:8080/computers/all-ready-to-lottery-by-officeId/${office}`;
                    }
                    break;
                case 'tablet':
                    if (office === '-1') {
                        url = 'http://localhost:8080/tablets/all-ready-to-lottery';
                    } else {
                        url = `http://localhost:8080/tablets/all-ready-to-lottery-by-officeId/${office}`;
                    }
                    break;
                case 'other':
                    if (office === '-1') {
                        url = 'http://localhost:8080/other-devices/all-ready-to-lottery';
                    } else {
                        url = `http://localhost:8080/other-devices/all-ready-to-lottery-by-officeId/${office}`;
                    }
                    break;
                default:
                    if (office === '-1') {
                        url = 'http://localhost:8080/devices/all-ready-to-lottery';
                    } else {
                        url = `http://localhost:8080/devices/all-ready-to-lottery-by-officeId/${office}`;
                    }


            }
        }

        try {
            const response = await axios.get(url);
            const devicesData = response.data;

            const devicesWithStatus = await Promise.all(devicesData.map(async device => {
                const isInLottery = await checkIfUserIsInLottery(device.id);
                return {...device, isInLottery};
            }));

            setDevices(devicesWithStatus);
        } catch (error) {
            console.error("Błąd pobierania danych:", error);
        }


        // axios.get(url)
        //     .then(response => {
        //         setDevices(response.data);
        //     })
        //     .catch(error => {
        //         console.error("Błąd pobierania danych:", error);
        //     });


    }

    useEffect(() => {
        fetchData(selectedOption, selectedOffice);
    }, [selectedOption, selectedOffice]);

    const headersMap ={
        all: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Czy sprzedany'],
        computer: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Numer seryjny', 'System', 'Bateria', 'Model', 'Procesor', 'Pamięć', 'Ram','Czy sprzedany',],
        tablet: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro','Ekran', 'System', 'Bateria','Czy sprzedany',],
        other: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro','Dodatkowy opis','Czy sprzedany',],
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
                            {device.ordered ? 'Tak' : 'Nie'}
                            {isAdmin &&(
                                <button onClick={() => handleSetOrdered(device.id, device.ordered)}>Zmień</button>
                            )}

                        </td>

                        {isAdmin &&(
                            <td>
                                {device.readyToLottery ? 'Tak' : 'Nie'}
                                <button onClick={() => handleSetReadyToLottery(device.id, device.readyToLottery)}>Zmień</button>
                            </td>
                        )}


                        {isAdmin &&(
                            <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        )}
                        {isAdmin &&(
                            <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        )}

                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>

                        {isAdmin &&(
                            <td><button onClick={() => handleDisplayUsersFromLottery(device.id)}>Wyświetl</button> </td>
                        )}


                        {device.lotteryDate!==null ? (

                            <td>{device.lotteryDate}</td>

                        ) : device.readyToLottery===true ? (
                                isAdmin ? (
                                        <td><button onClick={() => handleRandomLotteryWinner(device.id)}>Losuj</button> </td>
                                    ) : (
                                        device.isInLottery===true ? (
                                            <td><button onClick={() => handleCancelPartInLottery(device.id)}>Wypisz się</button> </td>
                                            ) : (
                                            <td><button onClick={() => handleTakePartInLottery(device.id)}>Weź udział w loterii</button> </td>
                                            )

                                    )
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
                            {device.ordered ? 'Tak' : 'Nie'}
                            {isAdmin &&(
                                <button onClick={() => handleSetOrdered(device.id, device.ordered)}>Zmień</button>
                            )}
                        </td>

                        {isAdmin &&(
                            <td>
                                {device.readyToLottery ? 'Tak' : 'Nie'}
                                <button onClick={() => handleSetReadyToLottery(device.id, device.readyToLottery)}>Zmień</button>
                            </td>
                        )}

                        {isAdmin &&(
                            <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        )}
                        {isAdmin &&(
                            <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        )}

                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>

                        {isAdmin &&(
                            <td><button onClick={() => handleDisplayUsersFromLottery(device.id)}>Wyświetl</button> </td>
                        )}

                        {device.lotteryDate!==null ? (

                            <td>{device.lotteryDate}</td>

                        ) : device.readyToLottery===true ? (
                            isAdmin ? (
                                <td><button onClick={() => handleRandomLotteryWinner(device.id)}>Losuj</button> </td>
                            ) : (
                                device.isInLottery===true ? (
                                    <td><button onClick={() => handleCancelPartInLottery(device.id)}>Wypisz się</button> </td>
                                ) : (
                                    <td><button onClick={() => handleTakePartInLottery(device.id)}>Weź udział w loterii</button> </td>
                                )
                            )
                        ) : (
                            <td>Oczekuje na zatwierdzenie</td>
                        )
                        }

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
                        <td>{device.screenSize}</td>
                        <td>{device.operatingSystem}</td>
                        <td>{device.batteryLife}</td>
                        <td>
                            {device.ordered ? 'Tak' : 'Nie'}
                            {isAdmin &&(
                                <button onClick={() => handleSetOrdered(device.id, device.ordered)}>Zmień</button>
                            )}

                        </td>

                        {isAdmin &&(
                            <td>
                                {device.readyToLottery ? 'Tak' : 'Nie'}
                                <button onClick={() => handleSetReadyToLottery(device.id, device.readyToLottery)}>Zmień</button>
                            </td>
                        )}
                        {isAdmin &&(
                            <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        )}
                        {isAdmin &&(
                            <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        )}

                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>

                        {isAdmin &&(
                            <td><button onClick={() => handleDisplayUsersFromLottery(device.id)}>Wyświetl</button> </td>
                        )}

                        {device.lotteryDate!==null ? (

                            <td>{device.lotteryDate}</td>

                        ) : device.readyToLottery===true ? (
                            isAdmin ? (
                                <td><button onClick={() => handleRandomLotteryWinner(device.id)}>Losuj</button> </td>
                            ) : (
                                device.isInLottery===true ? (
                                    <td><button onClick={() => handleCancelPartInLottery(device.id)}>Wypisz się</button> </td>
                                ) : (
                                    <td><button onClick={() => handleTakePartInLottery(device.id)}>Weź udział w loterii</button> </td>
                                )
                            )
                        ) : (
                            <td>Oczekuje na zatwierdzenie</td>
                        )
                        }
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
                            {device.ordered ? 'Tak' : 'Nie'}
                            {isAdmin &&(
                                <button onClick={() => handleSetOrdered(device.id, device.ordered)}>Zmień</button>
                            )}
                        </td>

                        {isAdmin &&(
                            <td>
                                {device.readyToLottery ? 'Tak' : 'Nie'}
                                <button onClick={() => handleSetReadyToLottery(device.id, device.readyToLottery)}>Zmień</button>
                            </td>
                        )}
                        {isAdmin &&(
                            <td><button onClick={() => handleDelete(device.id)}>Usuń</button></td>
                        )}
                        {isAdmin &&(
                            <td><button onClick={() => handleEdit(device.id, device.deviceType)}>Modyfikuj</button></td>
                        )}

                        <td><button onClick={() => handleInfo(device.id, device.deviceType)}>Informacje</button></td>

                        {isAdmin &&(
                            <td><button onClick={() => handleDisplayUsersFromLottery(device.id)}>Wyświetl</button> </td>
                        )}


                        {device.lotteryDate!==null ? (

                            <td>{device.lotteryDate}</td>

                        ) : device.readyToLottery===true ? (
                            isAdmin ? (
                                <td><button onClick={() => handleRandomLotteryWinner(device.id)}>Losuj</button> </td>
                            ) : (
                                device.isInLottery===true ? (
                                    <td><button onClick={() => handleCancelPartInLottery(device.id)}>Wypisz się</button> </td>
                                ) : (
                                    <td><button onClick={() => handleTakePartInLottery(device.id)}>Weź udział w loterii</button> </td>
                                )
                            )
                        ) : (
                            <td>Oczekuje na zatwierdzenie</td>
                        )
                        }

                    </>
                );
            default:
                return null;
        }
    };

    const handleRandomLotteryWinner = (deviceId) => {


    };

    const checkIfUserIsInLottery = async (deviceId) => {

        try {
            const response = await axios.get(`http://localhost:8080/participation/check-if-user-in-lottery`, {

                params: {
                    deviceId: deviceId,
                    userId: userId
                }
            })
            return response.data;
        } catch (error) {
            console.error("Błąd przy sprawdzaniu statusu:", error);
            return false
        }
    }
    const handleTakePartInLottery = (deviceId) =>{

        try{
            const participantData ={
                "deviceId" : deviceId,
                "userId" : userId
            }
            axios.post('http://localhost:8080/participation/add', participantData);
            updateLotteryStatus(deviceId, true)
        } catch (error){
            console.error("Błąd uczestnictwa", error);
        }

    };

    const handleCancelPartInLottery = async (deviceId) => {

        try {
            const response = await axios.delete(`http://localhost:8080/participation/delete-by-user_id-and-device_id`, {

                params: {
                    "userId": userId,
                    "deviceId": deviceId
                }
            })
            updateLotteryStatus(deviceId, false)
        } catch (error) {
            console.error("Błąd przy usuwaniu uczestnictwa:", error);
        }
    };

    const updateLotteryStatus = (deviceId, isInLottery) => {
        setDevices(prevDevices => {
            const updatedDevices = prevDevices.map(device =>
                device.id === deviceId ? {...device, isInLottery} : device
            );
            return updatedDevices;
        });
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
                    {isAdmin ? (
                        <AdminHomeBar onDeviceChange={handleDeviceChange} onOfficeChange={handleOfficeChange}/>
                    ) : (
                        <UserHomeBar onDeviceChange={handleDeviceChange} onOfficeCHange={handleOfficeChange}/>
                    )}

                </div>
                    <div className="table-container">
                    <ReactTableScroll className="styled-table">
                        <table className="device table styled-table">
                            <thead>
                            <tr key={selectedOption} className="table-header">
                                {headersMap[selectedOption].map((header, index) => (
                                    <td key={index}>{header}</td>
                                ))}
                                {isAdmin &&(
                                    <td>Gotowy na losowanie</td>
                                )}
                                {isAdmin &&(
                                    <td>Usuń</td>
                                )}
                                {isAdmin && (
                                    <td>Modyfikuj</td>
                                )}
                                <td>Informacje</td>
                                {isAdmin && (
                                    <td>Lista uczestników</td>
                                )}
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