import React, {useEffect, useState} from "react";
import axios from "axios";

function OtherDeviceForm(props){


    const {setTrigger, formType, deviceId} = props;

    const [formData, setFormData] = useState({

        deviceName: '',
        price: '',
        description:'',
        age: '',
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


    const handleAddOtherDevice = async () => {

        try {

            const otherDeviceData = {
                "deviceName": formData.deviceName,
                "price": formData.price,
                "description": formData.description,
                "age": formData.age,
                "officeAddress": formData.office,
                "additionalInfo": formData.additionalInfo,

            };

            const response = await axios.post('http://localhost:8080/other-devices/add', otherDeviceData, {});

        } catch (error) {
            console.error('Bład dodawania innego urzadzenia', error)
        }


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
                        Wiek [Lata]
                        <input
                            className="form-input"
                            type="number"
                            name="age"
                            value={formData.age}
                            onChange={handleChange}
                            disabled={formType === 'information'}
                            step ="1"
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
