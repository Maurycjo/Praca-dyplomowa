import React, {useEffect, useState} from "react";
import axios from "axios";



function CpuForm(props){

    const [formData, setFormData] = useState({
        name: '',
        price: null
    });


    const handleChange = (e) => {
        const { name, value } = e.target;

        let parsedValue = value === '' ? null : value;

        if (name === 'price' && value !== '') {
            parsedValue = parseFloat(value);
            parsedValue = isNaN(parsedValue) ? null : parsedValue;
        }

        setFormData({ ...formData, [name]: parsedValue });
    };

    const handleAddCpu = async (e) => {
        e.preventDefault();

        try {

            const cpuData = {
                "name": formData.name,
                "price": formData.price,
            };

            await axios.post('http://localhost:8080/cpus/add', cpuData, {});
            const updatedCpus = await axios.get('http://localhost:8080/cpus/all');

            props.setCpus(updatedCpus.data);

        } catch (error) {
            console.error('Bład dodawania procesora', error)
        }


        props.setTrigger(false);

    };


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
                            type="number"
                            name="price"
                            value={formData.price}
                            onChange={handleChange}
                        />
                    </label>
                    <button className="close-btn" onClick={() => props.setTrigger(false)}>
                        Zamknij
                    </button>
                    {props.children}
                    <button className="add-button" onClick={handleAddCpu}>
                        Dodaj procesor
                    </button>
                    {/*to do*/}
                    {/*<Message trigger={messagePopup} setTrigger={setMessagePopup} msg={message}></Message>*/}
                </form>

            </div>

        </div>

    ) : "";

}

export default CpuForm