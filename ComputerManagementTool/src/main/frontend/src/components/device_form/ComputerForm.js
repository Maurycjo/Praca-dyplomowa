import CpuForm from "../computer_components/CpuForm";
import StorageForm from "../computer_components/StorageForm";
import RamForm from "../computer_components/RamForm";
import React, {useEffect, useState} from "react";
import axios from "axios";

function ComputerForm(props){

    const {setTrigger, formType, deviceId} = props;

    const [formData, setFormData] = useState({

        deviceName: '',
        price: '',
        description:'',
        age: '',
        office: '',
        serialNumber: '',
        model: '',
        operatingSystem: '',
        batteryLife: '',
        cpu: '',
        storage: '',
        ram: ''
    });

    const [offices, setOffices] = useState([]);
    const [cpus, setCpus] = useState([]);
    const [rams, setRams] = useState([]);
    const [storages, setStorages] = useState([]);

    const [addCpuPopup, setAddCpuPopup] = useState(false);
    const [addStoragePopup, setAddStoragePopup] = useState(false);
    const [addRamPopup, setAddRamPopup] = useState(false);

    useEffect(() => {

            fetch('http://localhost:8080/offices/all')
                .then(response => response.json())
                .then(data => setOffices(data))
                .catch(error => console.error("Error fetching offices:", error));

            fetch('http://localhost:8080/cpus/all')
                .then(response => response.json())
                .then(data => setCpus(data))
                .catch(error => console.error("Erroe fetching offices:", error));

            fetch('http://localhost:8080/storages/all')
                .then(response => response.json())
                .then(data => setStorages(data))
                .catch(error => console.error("Erroe fetching offices:", error));

            fetch('http://localhost:8080/rams/all')
                .then(response => response.json())
                .then(data => setRams(data))
                .catch(error => console.error("Erroe fetching offices:", error));


        if(formType!=='addNew'){

            axios.get(`http://localhost:8080/computers/${deviceId}`)
                .then(response => {

                    const responseData = response.data;

                    setFormData(prevFormData =>({
                        ...prevFormData,
                        deviceName: responseData.deviceName,
                        price: responseData.price,
                        description: responseData.description,
                        age: responseData.age,
                        office: responseData.office.address,
                        serialNumber: responseData.serialNumber,
                        operatingSystem: responseData.operatingSystem,
                        batteryLife: responseData.batteryLife,
                        model: responseData.model,
                        cpu: responseData.cpu===null ? 'Brak' : responseData.cpu,
                        storage: responseData.storage===null ? 'Brak' : responseData.storage,
                        ram: responseData.ram===null ? 'Brak' : responseData.ram
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

    const handleAddCpu = (e) =>{
        e.preventDefault();
        setAddCpuPopup(true)
    };

    const handleAddStorage = (e) =>{
        e.preventDefault();
        setAddStoragePopup(true)
    };

    const handleAddRam = (e) =>{
        e.preventDefault();
        setAddRamPopup(true)
    };

    const handleAddComputer = () =>{

    };

    const handleModifyComputer = () =>{

    }

    return(
    <div className="popup-inner">
        <form className="computer-form">

            {formType==="information"&&(
                <div>Informacje o komupterze</div>
            )}

            {formType==="modify"&&(
                <div>Modyfikuj komputer</div>
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
                    Numer seryjny
                    <input
                        className="form-input"
                        type="text"
                        name="serialNumber"
                        value={formData.serialNumber}
                        onChange={handleChange}
                        disabled={formType === 'information'}
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
                        disabled={formType === 'information'}
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
                        disabled={formType === 'information'}
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
                        disabled={formType === 'information'}
                    />
                </label>
                <label className="form-label">
                    Procesor
                    <div className="form-label">
                        <select
                            className="form-input"
                            name="cpuName"
                            value={formData.cpu.name}
                            onChange={handleChange}
                            disabled={formType === 'information'}
                        >
                            <option value="">Brak</option>
                            {cpus.map(cpu =>(
                                <option key={cpu.id} value={cpu.name}>
                                    {cpu.name}
                                </option>
                            ))}

                        </select>

                        {formType !== "information" && (
                            <button type="button" onClick={handleAddCpu}>
                                Dodaj nowy procesor
                            </button>
                        )}

                    </div>
                </label>
                <label className="form-label">
                    Dysk pamięci
                    <div className="form-label">
                        <select
                            className="form-input"
                            name="storageName"
                            value={formData.storage.name}
                            onChange={handleChange}
                            disabled={formType === 'information'}
                        >
                            <option value="">Brak</option>
                            {storages.map(storage =>(
                                <option key={storage.id} value={storage.name}>
                                    {storage.name}
                                </option>
                            ))}

                        </select>
                        {formType !=="information" &&(
                            <button type="button" onClick={handleAddStorage}>
                                Dodaj nowy dysk
                            </button>
                        )}


                    </div>
                </label>
                <label className="form-label">
                    Ram
                    <div className="form-label">
                        <select
                            className="form-input"
                            name="ramName"
                            value={formData.ram.name}
                            onChange={handleChange}
                            disabled={formType === 'information'}
                        >
                            <option value="">Brak</option>
                            {rams.map(ram =>(
                                <option key={ram.id} value={ram.name}>
                                    {ram.name}
                                </option>
                            ))}

                        </select>
                        {formType!=="information"&&(
                            <button type="button" onClick={handleAddRam}>
                                Dodaj nowy ram
                            </button>
                        )}

                    </div>
                </label>

            </div>

            <div className="form-buttons">
                {formType === "addNew" &&(
                    <button className="add-button" onClick={handleAddComputer}>
                        Dodaj komputer
                    </button>
                )}
                {formType === "modify" &&(
                    <button className="add-button" onClick={handleModifyComputer}>
                        Modyfikuj komputer
                    </button>
                )}


                <button className="close-btn" onClick={() => props.setTrigger(false)}>
                    Zamknij
                </button>
            </div>
            <CpuForm trigger={addCpuPopup} setTrigger={setAddCpuPopup}></CpuForm>
            <StorageForm trigger={addStoragePopup} setTrigger={setAddStoragePopup}></StorageForm>
            <RamForm trigger={addRamPopup} setTrigger={setAddRamPopup}></RamForm>
        </form>
    </div>
    )
}

export default ComputerForm
