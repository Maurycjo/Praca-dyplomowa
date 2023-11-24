import React, { Component } from "react";
import './sidebar.css'
export default class Sidebar extends Component {
    render() {
        return (
            <div className="sidebar-container">
                <div className="sidebar">
                    <a className="sidebar-link">Link</a>
                    <a className="sidebar-link">Link</a>
                    <a className="sidebar-link">Link</a>
                </div>
            </div>
        );
    }
}