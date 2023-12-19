import React, {useEffect, useState} from "react";



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
        const params = new URLSearchParams();
        params.append('name', formData.name);
        params.append('price', formData.price);

        // fetch(`http://localhost:8080/cpus/add?${params.toString()}`, {
        //     method: 'POST',
        // })




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