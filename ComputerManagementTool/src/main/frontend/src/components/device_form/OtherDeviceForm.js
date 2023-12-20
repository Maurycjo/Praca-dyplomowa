import React, {useEffect, useState} from "react";

function OtherDeviceForm(props){


    const [formData, setFormData] = useState({

        deviceName: '',
        price: '',
        description:'',
        age: '',
        readyToSell: false,
        office: '',
        additionalInfo: ''
    });

    const [offices, setOffices] = useState([]);




    useEffect(() => {
        fetch('http://localhost:8080/offices/all')
            .then(response => response.json())
            .then(data => setOffices(data))
            .catch(error => console.error("Error fetching offices:", error));

    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });

    };


    const handleAddOtherDevice = () =>{

    };

    return(
        <div className="popup-inner">
            <form className="computer-form">

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
                        <select
                            className="form-input"
                            name="office"
                            value={formData.office.address}
                            onChange={handleChange}
                        >
                            {/*<option value="">Wybierz biuro</option>*/}
                            {offices.map(office => (
                                <option key={office.id} value={office.address}>
                                    {office.address}
                                </option>
                            ))}
                        </select>
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
                        Dodatkowe informacje
                        <input
                            className="form-input"
                            type="text"
                            name="additionalInfo"
                            value={formData.additionalInfo}
                            onChange={handleChange}
                        />
                    </label>

                <div className="form-buttons">

                    <button className="add-button" onClick={handleAddOtherDevice}>
                        Dodaj urządzenie
                    </button>
                    <button className="close-btn" onClick={() => props.setTrigger(false)}>
                        Zamknij
                    </button>
                </div>

            </form>
        </div>
    )
}

export default OtherDeviceForm
