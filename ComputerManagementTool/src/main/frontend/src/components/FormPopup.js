import React, {useEffect, useState} from "react";
import './ComputerForm.css'
import CpuForm from "./computer_components/CpuForm";
import StorageForm from "./computer_components/StorageForm";
import RamForm from "./computer_components/RamForm";
import ComputerForm from "./device_form/ComputerForm"
function FormPopup(props){



    return (props.trigger) ? (

        <div className="popup">
            <ComputerForm setTrigger={props.setTrigger}/>

            {props.children}
        </div>
    ) : "";
}

export default FormPopup
