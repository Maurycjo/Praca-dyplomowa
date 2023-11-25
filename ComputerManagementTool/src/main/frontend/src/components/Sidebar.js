import React, { Component } from "react";
import './sidebar.css'
export default class Sidebar extends Component {

    handleLinkClick = (selectedOption) =>{
        this.props.onSidebarClick(selectedOption);
    }

    render() {
        return (
            <div className="sidebar-container">
                <div className="sidebar">
                    <a className="sidebar-link" onClick={() => this.handleLinkClick('all')}>Wszystkie urządzenia</a>
                    <a className="sidebar-link" onClick={() => this.handleLinkClick('computer')}>Wszystkie komputery</a>
                    <a className="sidebar-link" onClick={() => this.handleLinkClick('tablet')} >Wszystkie tablety</a>
                    <a className="sidebar-link" onClick={() => this.handleLinkClick('other')}>Wszystkie inne urządzenia</a>
                    <a className="sidebar-link">Dodaj komputer</a>
                    <a className="sidebar-link">Dodaj tablet</a>
                    <a className="sidebar-link">Dodaj inne urządzenie</a>
                    <a className="sidebar-link">Procesory</a>
                    <a className="sidebar-link">Ram</a>
                    <a className="sidebar-link">Pamięci</a>
                </div>
            </div>
        );
    }
}