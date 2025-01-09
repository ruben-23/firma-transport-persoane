
import React, {useEffect, useState} from "react";
import '../Styles/GestionareOrareRute.css';
import ModalAdaugaRuta from "./modale/ModalAdaugaRuta.jsx";
import localitateService from "../services/localitateService.js";
import rutaService from "../services/rutaService.js";
import ModalLocalitati from "./modale/ModalLocalitati.jsx";

const GestionareOrareRute = () => {
    const [rute, setRute] = useState([]);
    const [localitati, setLocalitati] = useState([]);
    const [modalAdaugaRutaDeschis, setModalAdaugaRutaDeschis] = useState(false);
    const [modalLocalitatiDeschis, setModalLocalitatiDeschis] = useState(false);
    const [incarcare, setIncarcare] = useState(false);
    const [error, setError] = useState(null);
    const [rutaSelectata, setRutaSelectata] = useState(null);

    // incarcare localitati din baza de date
    useEffect(() => {
        const fetchLocalitati = async () => {
            try {
                setIncarcare(true);
                const localitati = await localitateService.getAllLocalitati();
                setLocalitati(localitati);
            } catch (err) {
                console.error("Eroare la returnarea localitatilor:", err);
                setError(err);
            } finally {
                setIncarcare(false);
            }
        };
        fetchLocalitati();
    }, []);

    const fetchRute = async () => {
        try {
            setIncarcare(true);
            const rute = await rutaService.getAllRute();
            setRute(rute);
        } catch (err) {
            console.error("Eroare la returnarea rutelor:", err);
            setError(err);
        } finally {
            setIncarcare(false);
        }
    };

    useEffect(() => {
        fetchRute();
    }, []);


    const getNumeLocalitateDupaId = (id) => {
        const localitate = localitati.find(loc => loc.idLocalitate === id);
        return localitate ? localitate.nume : 'Nu exista';
    };

    const handleAdaugareRuta = async (dateFormular) => {

        const idLocalitatePlecare = localitati.find(loc => loc.nume === dateFormular.localitatePlecare)?.idLocalitate;
        const idLocalitateDestinatie = localitati.find(loc => loc.nume === dateFormular.localitateDestinatie)?.idLocalitate;

        if (idLocalitatePlecare && idLocalitateDestinatie){
            const rutaNoua = {
                idLocalitateInceput: idLocalitatePlecare,
                idLocalitateDestinatie: idLocalitateDestinatie,
            };

            try {
                const rutaAdaugata = await rutaService.adaugaRuta(rutaNoua);
                setRute([...rute, rutaAdaugata]);
                setModalAdaugaRutaDeschis(false);
            } catch (error) {
                console.error("Eroare la adaugarea rutei:", error);
            }
        } else {
            alert("Localitate de plecare sau destinatie invalida.");
        }
    };

    const handleModalLocalitatiDeschis = (ruta) => {
        setRutaSelectata(ruta);
        setModalLocalitatiDeschis(true);
    };

    const handleAdaugareLocalitate = (localitateNoua) => {
        setLocalitati((prevLocalitati) => [...prevLocalitati, localitateNoua]);
    };

    const renderModal = (ModalComponent, modalState, setModalState, onSave, additionalProps={}) => {
        return modalState && (
            <ModalComponent
                onClose={() => setModalState(false)}
                onSave={onSave}
                onAdaugaLocalitate={handleAdaugareLocalitate}
                localitati={localitati}
                ruta={rutaSelectata}
                {...additionalProps}
            />
        );
    };

    return (
        <div className="main-content">
            <h2>Gestioneaza Rute si Orare</h2>

            <div className="search-and-dropdowns">

                <button className="btn btn-warning" onClick={() => setModalAdaugaRutaDeschis(true)}>
                    Adaugă Ruta
                </button>

                <input
                    type="text"
                    placeholder="Caută după nume"
                    className="search-bar"
                />
            </div>


            <div className="table-responsive">
                    <table className="table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Plecare</th>
                            <th>Destinatie</th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody>
                        {rute.map((ruta) => (
                            <tr key={ruta.idRuta}>
                                <td>{ruta.idRuta}</td>
                                <td>{getNumeLocalitateDupaId(ruta.idLocalitateInceput)}</td>
                                <td>{getNumeLocalitateDupaId(ruta.idLocalitateDestinatie)}</td>
                                <td className="butoane">
                                    <button
                                        className="btn btn-outline-dark"
                                    >
                                        Orare
                                    </button>
                                    <button
                                        className="btn btn-outline-dark"
                                        onClick={() => handleModalLocalitatiDeschis(ruta)}
                                    >
                                        Localități
                                    </button>
                                    <button className="btn btn-danger">
                                        Șterge
                                    </button>
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
            </div>

            {renderModal(ModalAdaugaRuta, modalAdaugaRutaDeschis, setModalAdaugaRutaDeschis, handleAdaugareRuta,
                localitati, handleAdaugareLocalitate)}
            {renderModal(ModalLocalitati, modalLocalitatiDeschis, setModalLocalitatiDeschis, ()=>{
                alert("Localitate Adaugata");
            })}

        </div>
    );

}

export default GestionareOrareRute;