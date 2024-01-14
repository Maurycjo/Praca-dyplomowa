import React, {useEffect, useState} from "react";
import axios from "axios";



function StorageForm(props){

    const [formData, setFormData] = useState({

        name: '',
        price: null
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });

    };

    const handleAddStorage = async (e) => {

        e.preventDefault();

        try {

            const storageData = {
                "name": formData.name,
                "price": formData.price,
            };

            await axios.post('http://localhost:8080/storages/add', storageData, {});
            const updatedStorages = await axios.get('http://localhost:8080/storages/all');

            props.setStorages(updatedStorages.data);

        } catch (error) {
            console.error('Bład dodawania pamieci', error)
        }


        props.setTrigger(false);


    }


    return (props.trigger) ? (

        <div className="popup">
            <div className="popup-inner">
                <h2>Dodaj dysk</h2>
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
                    <button className="add-button" onClick={handleAddStorage}>
                        Dodaj dysk
                    </button>

                </form>

            </div>

        </div>

    ) : "";

}

export default StorageForm