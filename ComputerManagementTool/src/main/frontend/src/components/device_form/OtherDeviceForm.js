import React, {useEffect, useState} from "react";
import axios from "axios";

function OtherDeviceForm(props){


    const {setTrigger, formType, deviceId} = props;

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

        if(formType!=='addNew'){

            axios.get(`http://localhost:8080/other-devices/${deviceId}`)
                .then(response => {

                    const responseData = response.data;

                    setFormData(prevFormData =>({
                        ...prevFormData,
                        deviceName: responseData.deviceName,
                        price: responseData.price,
                        description: responseData.description,
                        age: responseData.age,
                        readyToSell: responseData.readyToSell,
                        office: responseData.office.address,
                       additionalInfo: responseData.additionalInfo
                    }));
                })
                .catch(error =>{
                    console.error("Error fetching data", error);
                })

        }


    }, [formType]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });

    };


    const handleAddOtherDevice = () =>{

    };

    const handleModifyOtherDevice = () =>{

    }


    return(
        <div className="popup-inner">
            <form className="computer-form">

                {formType==="information"&&(
                    <div>Informacje o urządzeniu</div>
                )}

                {formType==="modify"&&(
                    <div>Modyfikuj urządzenie</div>
                )}
                <div className="form-column-left">
                    <label className="form-label">
                        Nazwa
                        <input
                            className="form-input"
                            type="text"
                            name="deviceName"
                            value={formData.deviceName}
                            onChange={handleChange}
                            disabled={formType === 'information'}
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
                            disabled={formType === 'information'}
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
                            disabled={formType === 'information'}
                        />
                    </label>
                </div>
                <div className="form-column-right">
                    <label className="form-label">
                        Wiek
                        <input
                            className="form-input"
                            type="int"
                            name="age"
                            value={formData.age}
                            onChange={handleChange}
                            disabled={formType === 'information'}
                        />
                    </label>
                    <label className="form-label">
                        Biuro
                        <select
                            className="form-input"
                            name="office"
                            value={formData.office.address}
                            onChange={handleChange}
                            disabled={formType === 'information'}
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
                            disabled={formType === 'information'}
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
                            disabled={formType === 'information'}
                        />
                    </label>
                </div>
                <div className="form-buttons">

                    {formType ==="addNew" &&(
                        <button className="add-button" onClick={handleAddOtherDevice}>
                            Dodaj urządzenie
                        </button>
                    )}
                    {formType ==="modify" &&(
                        <button className="add-button" onClick={handleModifyOtherDevice}>
                            Modyfikuj urządzenie
                        </button>
                    )}


                    <button className="close-btn" onClick={() => props.setTrigger(false)}>
                        Zamknij
                    </button>
                </div>

            </form>
        </div>
    )
}

export default OtherDeviceForm
