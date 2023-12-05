import CpuForm from "../computer_components/CpuForm";
import StorageForm from "../computer_components/StorageForm";
import RamForm from "../computer_components/RamForm";
import React, {useEffect, useState} from "react";

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
    }, []);

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

    return(
    <div className="popup-inner">
        <div className='popup-header'>Dodaj Komputer</div>
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
                    <div className="form-label">
                        <select
                            className="form-input"
                            name="cpuName"
                            value={formData.cpu.name}
                            onChange={handleChange}
                        >
                            <option value="">Brak</option>
                            {cpus.map(cpu =>(
                                <option key={cpu.id} value={cpu.name}>
                                    {cpu.name}
                                </option>
                            ))}

                        </select>
                        <button type="button" onClick={handleAddCpu}>
                            Dodaj nowy procesor
                        </button>

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
                        >
                            <option value="">Brak</option>
                            {storages.map(storage =>(
                                <option key={storage.id} value={storage.name}>
                                    {storage.name}
                                </option>
                            ))}

                        </select>
                        <button type="button" onClick={handleAddStorage}>
                            Dodaj nowy dysk
                        </button>

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
                        >
                            <option value="">Brak</option>
                            {rams.map(ram =>(
                                <option key={ram.id} value={ram.name}>
                                    {ram.name}
                                </option>
                            ))}

                        </select>
                        <button type="button" onClick={handleAddRam}>
                            Dodaj nowy ram
                        </button>

                    </div>
                </label>

            </div>
            <div className="form-buttons">

                <button className="add-button" onClick={handleAddComputer}>
                    Dodaj komputer
                </button>
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
