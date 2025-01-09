
import React, { useEffect, useState } from "react";
import '../Styles/GestionareOrareRute.css';
import autobuzService from "../services/autobuzService.js";
import ModalAdaugaAutobuz from "./modale/ModalAdaugaAutobuz.jsx";
import ModalDetaliiAutobuz from "./modale/ModalDetaliiAutobuz.jsx";

const GestionareAutobuze = () => {
    const [autobuze, setAutobuze] = useState([]);
    const [modalAdaugaAutobuzDeschis, setModalAdaugaAutobuzDeschis] = useState(false);
    const [modalDetaliiAutobuzDeschis, setModalDetaliiAutobuzDeschis] = useState(false);
    const [incarcare, setIncarcare] = useState(false);
    const [error, setError] = useState(null);
    const [autobuzSelectat, setAutobuzSelectat] = useState(null);

    // incarcare autobuze
    useEffect(() => {
        const fetchAutobuze = async () => {
            try {
                setIncarcare(true);
                const data = await autobuzService.getAllAutobuze();
                setAutobuze(data);
            } catch (err) {
                console.error("Eroare la returnarea autobuzelor:", err);
                setError(err);
            } finally {
                setIncarcare(false);
            }
        };
        fetchAutobuze();
    }, []);

    const handleAdaugareAutobuz = async (dateFormular) => {
        try {
            const autobuzNou = await autobuzService.adaugaAutobuz(dateFormular);
            setAutobuze([...autobuze, autobuzNou]);
            setModalAdaugaAutobuzDeschis(false);
        } catch (error) {
            console.error("Eroare la adaugarea autobuzului:", error);
        }
    };
    const handleStergeAutobuz = async (idAutobuz) => {
        try {
            await autobuzService.stergeAutobuz(idAutobuz);
            setAutobuze((prevAutobuze) => prevAutobuze.filter(autobuz => autobuz.idAutobuz !== idAutobuz));
        } catch (error) {
            console.error("Eroare la stergerea autobuzului:", error);
        }
    }

    const handleActualizareAutobuz = (autobuzActualizat) => {
        setAutobuze((prevAutobuze) =>
            prevAutobuze.map((autobuz) =>
                autobuz.idAutobuz === autobuzActualizat.idAutobuz ? autobuzActualizat : autobuz
            )
        );
    };

    const handleModalDetaliiAutobuzDeschis = (autobuz) => {
        setAutobuzSelectat(autobuz);
        setModalDetaliiAutobuzDeschis(true);
    };

    const renderModal = (ModalComponent, modalState, setModalState, onSave, additionalProps = {}) => {
        return modalState && (
            <ModalComponent
                onClose={() => setModalState(false)}
                onSave={onSave}
                autobuz={autobuzSelectat}
                {...additionalProps}
            />
        );
    };

    return (
        <div className="main-content">
            <h2>Gestioneaza Autobuze</h2>

            <div className="search-and-dropdowns">
                <button className="btn btn-warning" onClick={() => setModalAdaugaAutobuzDeschis(true)}>
                    Adaugă Autobuz
                </button>
                <input
                    type="text"
                    placeholder="Cauta dupa numar inmatriculare"
                    className="search-bar"
                />
            </div>

            <div className="table-responsive">
                <table className="table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Număr Înmatriculare</th>
                        <th>Status</th>
                        <th>Capacitate</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {autobuze.map((autobuz) => (
                        <tr key={autobuz.idAutobuz}>
                            <td>{autobuz.idAutobuz}</td>
                            <td>{autobuz.numarInmatriculare}</td>
                            <td>{autobuz.status}</td>
                            <td>{autobuz.capacitate}</td>
                            <td  className="butoane">
                                <button
                                    className="btn btn-outline-dark"
                                    onClick={() => handleModalDetaliiAutobuzDeschis(autobuz)}
                                >
                                    Detalii
                                </button>

                                <button
                                    className="btn btn-danger"
                                    onClick={()=>handleStergeAutobuz(autobuz.idAutobuz)}
                                >
                                    Șterge
                                </button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

            {renderModal(ModalAdaugaAutobuz, modalAdaugaAutobuzDeschis, setModalAdaugaAutobuzDeschis, handleAdaugareAutobuz)}
            {renderModal(ModalDetaliiAutobuz, modalDetaliiAutobuzDeschis, setModalDetaliiAutobuzDeschis,handleActualizareAutobuz)}
        </div>
    );
}

export default GestionareAutobuze;