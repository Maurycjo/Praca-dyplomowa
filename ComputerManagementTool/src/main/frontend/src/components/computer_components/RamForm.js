import React, {useEffect, useState} from "react";



function RamForm(props){

    const [formData, setFormData] = useState({

        name: '',
        price: null
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });

    };

    const handleAddRam = (e) =>{

    }


    return (props.trigger) ? (

        <div className="popup">
            <div className="popup-inner">
                <h2>Dodaj Procesor</h2>
                <form className="computer-form">

                    <label className="form-label">
                        Nazwa
                        <input
                            className="form-input"
                            type="text"
                            name="name"
                            value={formData.name}
                            onChange={handleChange}
                        />
                    </label>
                    <label className="form-label">
                        Cena
                        <input
                            className="form-input"
                            type="double"
                            name="price"
                            value={formData.price}
                            onChange={handleChange}
                        />
                    </label>
                    <button className="close-btn" onClick={() => props.setTrigger(false)}>
                        Zamknij
                    </button>
                    {props.children}
                    <button className="add-button" onClick={handleAddRam}>
                        Dodaj ram
                    </button>

                </form>

            </div>

        </div>

    ) : "";

}

export default RamForm