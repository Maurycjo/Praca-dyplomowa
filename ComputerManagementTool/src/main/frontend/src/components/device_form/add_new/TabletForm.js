import React, {useEffect, useState} from "react";

function TabletForm(props){


    const [formData, setFormData] = useState({

        deviceName: '',
        price: '',
        description:'',
        age: '',
        readyToSell: false,
        office: '',
        screenSize: '',
        operatingSystem: '',
        batteryLife: ''
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


    const handleAddTablet = () =>{

    };

    return(
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
                </div>
                <div className="form-column-right">

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
                        Rozmiar ekranu
                        <input
                            className="form-input"
                            type="text"
                            name="screenSize"
                            value={formData.screenSize}
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
                        System operacyjny
                        <input
                            className="form-input"
                            type="text"
                            name="operatingSystem"
                            value={formData.operatingSystem}
                            onChange={handleChange}
                        />
                    </label>

                </div>
                <div className="form-buttons">

                    <button className="add-button" onClick={handleAddTablet}>
                        Dodaj Tablet
                    </button>
                    <button className="close-btn" onClick={() => props.setTrigger(false)}>
                        Zamknij
                    </button>
                </div>

            </form>
        </div>
    )
}

export default TabletForm
