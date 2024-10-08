import React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import Login from './components/auth/Login';
import Register from './components/auth/Register';
import Home from './components/view/Home';
import Users from "./components/view/Users";
import ComputerComponents from "./components/view/ComputerComponents";
import UsersInLottery from "./components/view/UsersInLottery";
import UserLotteryHistory from "./components/view/UserLotteryHistory";

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/auth/login" element={<Login />} />
                <Route path="/auth/register" element={<Register />} />
                <Route path="/home" element={<Home />} />
                <Route path="/" element={<Navigate to="/auth/login" />} />
                <Route path="/auth/*" element={<Navigate to="/auth/login" />} />
                <Route path="/users" element={<Users/>}/>
                <Route path="/components" element={<ComputerComponents/>}/>
                <Route path="/users-in-lottery" element={<UsersInLottery/>}/>
                <Route path="/user-lottery-history" element={<UserLotteryHistory/>}/>
            </Routes>
        </Router>
    );
};

export default App;
