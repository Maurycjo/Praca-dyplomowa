import React, {useState} from "react";
import './ComputerForm.css'

function ComputerForm(props){

    const [formData, setFormData] = useState({

        deviceName: '',
        price: '',
        description:'',
        age: '',
        readyToSell: false,
        office: '',
        serialNumber: '',
        model: '',
        operatingSystem: '',
        batteryLife: '',
        cpuName: '',
        storageName: '',
        ramName: ''
    });

    const handleChange = () =>{

    };

    const handleAddComputer = () =>{

    };

    return (props.trigger) ? (

        <div className="popup">
            <div className="popup-inner">
                <form className="computer-form">
                    <div className="form-column-left">

                        <label className="form-label">
                            Nazwa
                        <input
                            className="form-input"
                            type="text"
                            name="deviceName"
                            value={formData.deviceName}
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
                        <label className="form-label">
                            Opis
                            <input
                                className="form-input"
                                type="text"
                                name="description"
                                value={formData.description}
                                onChange={handleChange}
                            />
                        </label>
                        <label className="form-label">
                            Wiek
                            <input
                                className="form-input"
                                type="int"
                                name="age"
                                value={formData.age}
                                onChange={handleChange}
                            />
                        </label>
                        <label className="form-label">
                            Biuro
                            <input
                                className="form-input"
                                type="text"
                                name="office"
                                value={formData.office}
                                onChange={handleChange}
                            />
                        </label>
                        <label className="form-label">
                            Gotowy do sprzedaży
                            <input
                                className="form-input"
                                type="bool"
                                name="readytoSell"
                                value={formData.readyToSell}
                                onChange={handleChange}
                            />
                        </label>
                        <label className="form-label">
                            Numer seryjny
                            <input
                                className="form-input"
                                type="text"
                                name="serialNumber"
                                value={formData.serialNumber}
                                onChange={handleChange}
                            />
                        </label>
                    </div>
                    <div className="form-column-right">
                        <label className="form-label">
                            System operacyjny
                            <input
                                className="form-input"
                                type="text"
                                name="operatingSystem"
                                value={formData.operatingSystem}
                                onChange={handleChange}
                            />
                        </label>
                        <label className="form-label">
                            Żywotność baterii
                            <input
                                className="form-input"
                                type="int"
                                name="battery"
                                value={formData.batteryLife}
                                onChange={handleChange}
                            />
                        </label>
                        <label className="form-label">
                            Model
                            <input
                                className="form-input"
                                type="text"
                                name="model"
                                value={formData.model}
                                onChange={handleChange}
                            />
                        </label>
                        <label className="form-label">
                            Procesor
                            <input
                                className="form-input"
                                type="text"
                                name="cpu"
                                value={formData.cpuName}
                                onChange={handleChange}
                            />
                        </label>
                        <label className="form-label">
                            Pamięć dyskowa
                            <input
                                className="form-input"
                                type="text"
                                name="storage"
                                value={formData.storageName}
                                onChange={handleChange}
                            />
                        </label>
                        <label className="form-label">
                            Pamięć Ram
                            <input
                                className="form-input"
                                type="text"
                                name="ram"
                                value={formData.ramName}
                                onChange={handleChange}
                            />
                        </label>

                    </div>
                    <div className="form-buttons">
                        <button className="close-btn" onClick={() => props.setTrigger(false)}>
                            Zamknij
                        </button>
                        {props.children}
                        <button className="add-button" onClick={handleAddComputer}>
                            Dodaj komputer
                        </button>
                    </div>
                </form>




            </div>
        </div>
    ) : "";
}

export default ComputerForm
