import React from "react";

function Message(props, msg){


    return (props.trigger, msg) ? (

    <div className="popup">
        <div className="popup-inner">
            <h2>Wiadomość</h2>
            <div>{JSON.stringify(msg)}</div>
            <button className="close-btn" onClick={() => props.setTrigger(false)}>
                OK
            </button>
            {props.children}
        </div>
    </div>
    ) : "";
}

export default Message