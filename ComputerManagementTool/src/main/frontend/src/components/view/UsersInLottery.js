import React, {useEffect, useState} from 'react';
import { ReactTableScroll } from 'react-table-scroll';
import { Container } from "react-bootstrap";
import ManageUserBar from "../bar/ManageUserBar";
import {useNavigate, useParams} from 'react-router-dom'
import axios from "axios";
import UsersInLotteryBar from "../bar/UsersInLotteryBar";
import {useLocation} from "react-router-dom";

const UsersInLottery = () =>{

    const location = useLocation();
    const [dataLoaded, setDataLoaded] = useState(false);

    const navigate = useNavigate();
    const [participations, setParticipations] = useState([]);
    const fetchUsers = () => {
        let deviceId = location.state.deviceId;

        axios.get(`http://localhost:8080/participation/device-participation/${deviceId}`)
            .then(response => setParticipations(response.data))
            .catch(error => console.error("Error fetching data:", error));
    };



    const renderParticipationData = (participation) => {

        return(
            <>
                <td>{participation.id}</td>
                <td>{participation.user.id}</td>
                <td>{participation.user.username}</td>
                <td>{participation.user.name}</td>
                <td>{participation.user.surname}</td>
                <td>{participation.user.email}</td>
                <td>
                    {participation.winner ? 'Tak' : 'Nie'}
                </td>
            </>
        );
    }

    useEffect(() =>{
        fetchUsers();
    }, []);

    return (

        <Container>
            <div className="outer-position">

                <div className="header-block">

                 Lista uczestników

                </div>
                <div className="operation-block">
                    <UsersInLotteryBar/>
                </div>
                <div className="table-container">
                    <ReactTableScroll className="styled-table">
                        <table className="device table styled-table">
                            <thead>
                            <td>ID</td>
                            <td>User ID</td>
                            <td>Nazwa użytkownika</td>
                            <td>Imię</td>
                            <td>Nazwisko</td>
                            <td>Email</td>
                            <td>Czy wygrał</td>
                            </thead>

                            <tbody>
                            {participations.map((participation) => (
                                <tr key={participation.id}>
                                    {renderParticipationData(participation)}
                                </tr>
                            ))}
                            </tbody>
                        </table>
                    </ReactTableScroll>
                </div>
            </div>
        </Container>

    )




};

export default UsersInLottery;