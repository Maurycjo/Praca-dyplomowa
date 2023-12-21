import React, {useEffect, useState} from "react";
import './DeviceForm.css'

import ComputerForm from "./ComputerForm"
import TabletForm from "./TabletForm";
import OtherDeviceForm from "./OtherDeviceForm";

function AddNewFormPopup(props){

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
                {selectedString === 'Komputer' && <ComputerForm setTrigger={props.setTrigger} formType={"addNew"} /*deviceId={502}*//>}
                {selectedString === 'Tablet' && <TabletForm setTrigger={props.setTrigger} formType={"addNew"} /*deviceId={457}*//>}
                {selectedString === 'Inne' && <OtherDeviceForm setTrigger={props.setTrigger}  formType={"addNew"} /*deviceId={452}*/ />}
                {props.children}
            </div>
        </div>
    ) : "";
}

export default AddNewFormPopup
