import React, { Component } from "react";
import './sidebar.css'
export default class Sidebar extends Component {
    render() {
        return (
            <div className="sidebar-container">
                <div className="sidebar">
                    <a className="sidebar-link">Wszystkie urządzenia</a>
                    <a className="sidebar-link">Wszystkie komputery</a>
                    <a className="sidebar-link">Wszystkie tablety</a>
                    <a className="sidebar-link">Wszystkie inne urządzenia</a>
                    <a className="sidebar-link">Dodaj komputer</a>
                    <a className="sidebar-link">Dodaj tablet</a>
                    <a className="sidebar-link">Dodaj inne urządzenie</a>
                </div>
            </div>
        );
    }
}