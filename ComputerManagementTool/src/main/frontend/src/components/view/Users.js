import React, {useEffect, useState} from 'react';
import { ReactTableScroll } from 'react-table-scroll';
import { Container } from "react-bootstrap";
import ManageUserBar from "../bar/ManageUserBar";
import {useNavigate} from 'react-router-dom'
import axios from "axios";


const Users = () =>{

    const navigate = useNavigate();
    const [users, setUsers] = useState([]);
    const fetchUsers = () => {
        axios.get('http://localhost:8080/users/all-standard')
            .then(response => setUsers(response.data))
            .catch(error => console.error("Error fetching data:", error));
    };



    const handleDeleteUser = (userId) =>{

        fetch(`http://localhost:8080/users/${userId}`, {
            method: 'DELETE',
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((res) => {
                if (!res.ok) {
                    throw new Error('Wystąpił problem podczas usuwania uzytkownika.');
                }
                return res.json();
            })
            .then((data) => {
                console.log('Uzytkownik został pomyślnie usunięty.');
            })
            .catch((err) => {
                console.error(err.message);
            });

        const updatedUsers = users.filter((user) => user.id !== userId);
        setUsers(updatedUsers);

    }

    const handleDisplayUserLotteryHistory = (userId) =>{

        navigate('/user-lottery-history', {
            state:{
                userId: userId,
            }
        });
    };

    const renderUsersData = (user) => {

        return(
            <>
                <td>{user.id}</td>
                <td>{user.username}</td>
                <td>{user.name}</td>
                <td>{user.surname}</td>
                <td>{user.email}</td>
                <td>
                    <button onClick={()=> handleDisplayUserLotteryHistory(user.id)}>Pokaż historie</button>
                </td>
                <td>
                    <button onClick={() => handleDeleteUser(user.id)}> Usuń użytkownika</button>
                </td>
            </>
        );
    }

    useEffect(() =>{
      fetchUsers();
    }, []);

    return (

        <Container>
            {/*<AdminManageDevices onSidebarClick={handleSidebarClick} onAddComputerClick={handleAddComputerClick}/>*/}
            <div className="outer-position">

                <div className="header-block">
                    Panel administracyjny, zarządzanie użytkownikami
                </div>
                <div className="operation-block">
                    <ManageUserBar/>
                </div>
                <div className="table-container">
                    <ReactTableScroll className="styled-table">
                        <table className="device table styled-table">
                            <thead>
                                <tr>
                                    <td>ID</td>
                                    <td>Nazwa użytkownika</td>
                                    <td>Imię</td>
                                    <td>Nazwisko</td>
                                    <td>Email</td>
                                    <td>Historia loterii</td>
                                    <td>Usuń</td>
                                </tr>
                            </thead>

                            <tbody>
                            {users.map((user) => (
                                <tr key={user.id}>
                                    {renderUsersData(user)}
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

export default Users;