import React, {useEffect, useState} from "react";
import './DeviceForm.css'

import ComputerForm from "./add_new/ComputerForm"
import TabletForm from "./add_new/TabletForm";
import OtherDeviceForm from "./add_new/OtherDeviceForm";

function FormPopup(props){

    const [selectedString, setSelectedString] = useState('Komputer');
    const stringList = ['Komputer', 'Tablet', 'Inne'];

    const handleSelectChange = (event) => {
        const selectedString = event.target.value;
        setSelectedString(selectedString);
    };



    return (props.trigger) ? (

        <div className="popup">
                <div className='popup-select'>
                    <div className>Dodaj</div>

                    <select value={selectedString} onChange={handleSelectChange}>
                        {stringList.map((option, index) => (
                            <option key={index} value={option}>
                                {option}
                            </option>
                        ))}
                    </select>
                </div>
            <div>
                {selectedString === 'Komputer' && <ComputerForm setTrigger={props.setTrigger} />}
                {selectedString === 'Tablet' && <TabletForm setTrigger={props.setTrigger} />}
                {selectedString === 'Inne' && <OtherDeviceForm setTrigger={props.setTrigger} />}
                {props.children}
            </div>
        </div>
    ) : "";
}

export default FormPopup
