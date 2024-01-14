import React, {useEffect, useState} from "react";
import axios from "axios";



function RamForm(props){

    const [formData, setFormData] = useState({

        name: '',
        price: null
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });

    };

    const handleAddRam = async (e) => {
        e.preventDefault();

        try {

            const ramData = {
                "name": formData.name,
                "price": formData.price,
            };

            await axios.post('http://localhost:8080/rams/add', ramData, {});
            const updatedRams = await axios.get('http://localhost:8080/rams/all');

            props.setRams(updatedRams.data);

        } catch (error) {
            console.error('Bład dodawania ram', error)
        }
        props.setTrigger(false);
    }


    return (props.trigger) ? (

        <div className="popup">
            <div className="popup-inner">
                <h2>Dodaj pamięć RAM</h2>
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