import React, {useEffect, useState} from "react";
import './DeviceForm.css'

import ComputerForm from "./ComputerForm"
import TabletForm from "./TabletForm";
import OtherDeviceForm from "./OtherDeviceForm";

function FormPopup(props){


    const {setTrigger, formType, deviceType, deviceId} = props;


    return (props.trigger) ? (

        <div className="popup">

            {/*deviceType COMPUTER, TABLET, OTHER jest zwracany w requescie*/}
            <div>
                {deviceType === 'COMPUTER' && <ComputerForm setTrigger={props.setTrigger} formType={formType} deviceId={deviceId}/>}
                {deviceType === 'TABLET' && <TabletForm setTrigger={props.setTrigger} formType={formType} deviceId={deviceId}/>}
                {deviceType === 'OTHER' && <OtherDeviceForm setTrigger={props.setTrigger}  formType={formType} deviceId={deviceId} />}
                {props.children}
            </div>
        </div>
    ) : "";
}

export default FormPopup
