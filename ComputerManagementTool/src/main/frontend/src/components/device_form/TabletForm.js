import React, {useEffect, useState} from "react";
import axios from "axios";

function TabletForm(props){


    const {setTrigger, formType, deviceId} = props;

    const [formData, setFormData] = useState({

        deviceName: '',
        price: '',
        description:'',
        age: '',
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

        if(formType!=='addNew'){

            axios.get(`http://localhost:8080/tablets/${deviceId}`)
                .then(response => {

                    const responseData = response.data;

                    setFormData(prevFormData =>({
                        ...prevFormData,
                        deviceName: responseData.deviceName,
                        price: responseData.price,
                        description: responseData.description,
                        age: responseData.age,
                        office: responseData.office.address,
                        screenSize: responseData.screenSize,
                        operatingSystem: responseData.operatingSystem,
                        batteryLife: responseData.batteryLife
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


    const handleAddTablet = async () => {

        try {

            const tabletData = {
                "deviceName": formData.deviceName,
                "price": formData.price,
                "description": formData.description,
                "age": formData.age,
                "officeAddress": formData.office,
                "screenSize": formData.screenSize,
                "operatingSystem": formData.model,
                "batteryLife": formData.batteryLife,
            };

            const response = await axios.post('http://localhost:8080/tablets/add', tabletData, {});

        } catch (error) {
            console.error('Bład dodawania komputera', error)
        }


    };

    const handleModifyTablet = async (e) => {


        try {

            const tabletData = {
                "deviceName": formData.deviceName,
                "price": formData.price,
                "description": formData.description,
                "age": formData.age,
                "officeAddress": formData.office,
                "screenSize": formData.screenSize,
                "operatingSystem": formData.model,
                "batteryLife": formData.batteryLife,
            };

            const response = await axios.patch(`http://localhost:8080/tablets/update/${deviceId}`, tabletData, {});

        } catch (error) {
            console.error('Bład modyfikacji tableta', error)
        }

    }

    return(
        <div className="popup-inner">
            <form className="computer-form">

                {formType==="information"&&(
                    <div>Informacje o tablecie</div>
                )}

                {formType==="modify"&&(
                    <div>Modyfikuj tablet</div>
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
                    <label className="form-label">
                        Wiek [Lata]
                        <input
                            className="form-input"
                            type="number"
                            name="age"
                            value={formData.age}
                            onChange={handleChange}
                            disabled={formType === 'information'}
                            step="1"
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
                </div>
                <div className="form-column-right">

                    <label className="form-label">
                        Rozmiar ekranu
                        <input
                            className="form-input"
                            type="text"
                            name="screenSize"
                            value={formData.screenSize}
                            onChange={handleChange}
                            disabled={formType === 'information'}
                        />
                    </label>
                    <label className="form-label">
                        Żywotność baterii
                        <input
                            className="form-input"
                            type="text"
                            name="batteryLife"
                            value={formData.batteryLife}
                            onChange={handleChange}
                            disabled={formType === 'information'}
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
                            disabled={formType === 'information'}
                        />
                    </label>

                </div>
                <div className="form-buttons">

                    {formType === "addNew"&&(

                        <button className="add-button" onClick={handleAddTablet}>
                            Dodaj Tablet
                        </button>
                    )}

                    {formType === "modify"&&(

                        <button className="add-button" onClick={handleModifyTablet}>
                            Modyfikuj Tablet
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

export default TabletForm
