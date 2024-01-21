import React, {useEffect, useState} from 'react';
import {ReactTableScroll} from 'react-table-scroll';
import {Container} from "react-bootstrap";
import './Home.css'
import AdminHomeBar from "../bar/AdminHomeBar";
import axios from "axios";
import FormPopup from "../device_form/FormPopup";
import {Link, useLocation, useNavigate} from 'react-router-dom';
import UserLotteryHistoryBar from "../bar/UserLotteryHistoryBar";

const UserLotteryHistory = () => {

    const isAdmin = localStorage.getItem("role")==="ADMIN";
    const location = useLocation();
    const [participation, setParticipation] = useState([]);

    const [selectedOption, setSelectedOption] = useState('all');

    const [deviceFormPopup, setDeviceFormPopup] =useState(false);
    const [currentDeviceType, setCurrentDeviceType] = useState('');
    const [currentDeviceId, setCurrentDeviceId] = useState(0);
    const [currentFormType, setCurrentFormType] = useState('');

    const navigate = useNavigate();


    const fetchParticipation = (option) => {

        let participationId = location.state.userId;
        let url;

        switch (option){

            case 'all':
                url = `http://localhost:8080/participation/user-lottery-history/${participationId}`;
                break;
            case 'wins':
                url = `http://localhost:8080/participation/user-win-history/${participationId}`;
                break;
            case 'pending':
                url = `http://localhost:8080/participation/user-pending-lottery/${participationId}`;
                break;
        }

        axios.get(url)
            .then(response => {
                setParticipation(response.data);
            })
            .catch(error => {
                console.error("Błąd pobierania danych", error);
            })
    }

    useEffect(()=>{
        fetchParticipation(selectedOption);
    }, [selectedOption])







    const headersMap ={
        all: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Loteria', 'Czy sprzedany'],
        computer: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro', 'Numer seryjny', 'System', 'Bateria', 'Model', 'Procesor', 'Pamięć', 'Ram','Gotowy do losowania','Czy sprzedany',],
        tablet: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro','Ekran', 'System', 'Bateria', 'Gotowy do losowania','Czy sprzedany',],
        other: ['ID', 'Nazwa', 'Cena', 'Opis', 'Wiek', 'Biuro','Dodatkowy opis', 'Gotowy do losowania','Czy sprzedany',],
        cpu: ['ID', 'Nazwa', 'Cena'],
        ram: ['ID', 'Nazwa', 'Cena'],
        storage: ['ID', 'Nazwa', 'Cena'],
    };
    const renderDataForOption = (participation) => {


                return (
                    <>
                        <td>{participation.deviceCore.id}</td>
                        <td>{participation.deviceCore.deviceName}</td>
                        <td>{participation.deviceCore.price} zł</td>
                        <td>{participation.deviceCore.description}</td>
                        <td>{participation.deviceCore.age}</td>
                        <td>{participation.deviceCore.office.address}</td>
                        <td><button onClick={() => handleInfo(participation.deviceCore.id, participation.deviceCore.deviceType)}>Informacje</button></td>

                        {isAdmin===false && (
                            participation.deviceCore.lotteryDate === null ? (
                                <td><button onClick={() => handleCancelParticipation(participation.id)}>Wypisz się</button></td>
                                ) : (
                                    <td>Po loterii</td>
                                )

                        )}

                        {participation.deviceCore.lotteryDate!==null ? (

                            <td>{participation.deviceCore.lotteryDate}</td>

                        ) : (
                            <td>Oczekuje na losowanie </td>
                        )}

                        {participation.deviceCore.lotteryDate !== null ? (

                            participation.winner === true ? (
                                <td>Zwycięzca</td>
                            ) : (
                                <td>Przegrany</td>
                            )
                        ) : (
                            <td>Oczekuje na losowanie</td>
                        )}
                    </>
                );
        }


    const handleCancelParticipation = (participationId) => {

    };


    const handleOptionChange = (selectedOption) => {
        setSelectedOption(selectedOption);
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
                    Historia loterii użytkownika
                </div>
                <div className="operation-block">
                    <FormPopup trigger={deviceFormPopup} setTrigger={setDeviceFormPopup} deviceType={currentDeviceType} deviceId={currentDeviceId} formType={currentFormType}></FormPopup>
                    <UserLotteryHistoryBar onOptionChange={handleOptionChange}/>
                </div>
                <div className="table-container">
                    <ReactTableScroll className="styled-table">
                        <table className="device table styled-table">
                            <thead>
                            <tr className="table-header">
                                <td>Id urządzenia</td>
                                <td>Nazwa</td>
                                <td>Cena</td>
                                <td>Opis</td>
                                <td>Wiek</td>
                                <td>Biuro</td>
                                <td>O urządzeniu</td>
                                {isAdmin===false &&(
                                    <td>Wypisz się</td>
                                )}

                                <td>Loteria</td>
                                <td>Status uczestnika</td>
                            </tr>
                            </thead>
                            <tbody>
                            {participation.map((participation) => (
                                <tr key={participation.id}>
                                    {renderDataForOption(participation)}
                                </tr>
                            ))}
                            </tbody>
                        </table>
                    </ReactTableScroll>
                </div>
            </div>
            {/*<SidebarUserConfig/>*/}
        </Container>
    );


};

export default UserLotteryHistory;