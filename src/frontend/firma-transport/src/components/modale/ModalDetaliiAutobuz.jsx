import React, {useEffect, useState} from 'react';
import { Modal, Form, Button } from 'react-bootstrap';
import PropTypes from 'prop-types';
import rutaService from "../../services/rutaService.js";
import CustomToggle from "../custom/CustomToggle.jsx";
import CustomMenu from "../custom/CustomMenu.jsx";
import localitateService from "../../services/localitateService.js";
import Dropdown from "react-bootstrap/Dropdown";
import autobuzService from "../../services/autobuzService.js";
import '../../Styles/ModalDetaliiAutobuz.css';

const ModalDetaliiAutobuz = ({ autobuz, onSave, onClose }) => {
    const [isEditable, setIsEditable] = useState(false);
    const [autobuzEditat, setAutobuzEditat] = useState(autobuz);
    const [rute, setRute] = useState([]);

    useEffect(() => {
        const fetchRute = async () => {
            try {
                const data = await rutaService.getAllRute();
                const ruteCuNume = await Promise.all(data.map(async (ruta) => {
                    const localitatePlecare = await localitateService.getLoclitateById(ruta.idLocalitateInceput);
                    const localitateDestinatie = await localitateService.getLoclitateById(ruta.idLocalitateDestinatie);
                    return {
                        ...ruta,
                        nume: `${localitatePlecare.nume} - ${localitateDestinatie.nume}`,
                    };
                }));
                setRute(ruteCuNume);
            } catch (error) {
                console.error("Eroare la încărcarea rutelor:", error);
            }
        };

        fetchRute();
    }, []);


    const handleModificare = (e) => {
        const { name, value } = e.target;
        setAutobuzEditat({ ...autobuzEditat, [name]: value });
    };

    const handleEditare = () => {
        setIsEditable(true);
    };

    const handleSalvare = async () => {
        try {
            await autobuzService.actualizareAutobuz(autobuzEditat.idAutobuz, autobuzEditat);
            onSave(autobuzEditat);
            setIsEditable(false);
        } catch (error) {
            console.error("Eroare la actualizarea autobuzului:", error);
            alert("Autobuzul nu a putut fi editat");
        }
    };

    return (
        <Modal show={true} onHide={onClose} className="modal-detalii-autobuz">
            <Modal.Header closeButton>
                <Modal.Title>Detalii Autobuz {autobuzEditat.numarInmatriculare}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                    <Form.Group controlId="numarInmatriculare" className="mda-form-group">
                        <Form.Label className="mda-form-label">Număr Înmatriculare</Form.Label >
                        <Form.Control
                            name="numarInmatriculare"
                            type="text"
                            value={autobuzEditat.numarInmatriculare || ''}
                            onChange={handleModificare}
                            readOnly={!isEditable}
                        />
                    </Form.Group>

                    <Form.Group controlId="capacitate" className="mda-form-group">
                        <Form.Label className="mda-form-label">Capacitate</Form.Label>
                        <Form.Control
                            name="capacitate"
                            type="number"
                            value={autobuzEditat.capacitate || ''}
                            onChange={handleModificare}
                            readOnly={!isEditable}
                        />
                    </Form.Group>

                    <Form.Group controlId="status" className="mda-form-group">
                        <Form.Label className="mda-form-label">Status</Form.Label>
                        <Form.Select
                            name="status"
                            value={autobuzEditat.status || ''}
                            onChange={handleModificare}
                            disabled={!isEditable}
                        >
                            <option value="Disponibil">Disponibil</option>
                            <option value="Indisponibil">Indisponibil</option>
                        </Form.Select>
                    </Form.Group>

                    <Form.Group controlId="idRuta" className="mda-form-group">
                        <Form.Label className="mda-form-label">Ruta</Form.Label>
                        <Dropdown >
                            <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-ruta" >
                                {autobuzEditat.idRuta ? rute.find(r => r.idRuta === autobuzEditat.idRuta)?.nume : "Selectați o rută"}
                            </Dropdown.Toggle>
                            <Dropdown.Menu as={CustomMenu} >
                                {rute.map((ruta) => (
                                    <Dropdown.Item
                                        key={ruta.idRuta}
                                        onClick={() => isEditable && setAutobuzEditat({ ...autobuzEditat, idRuta: ruta.idRuta })}
                                        disabled={!isEditable}
                                    >
                                        {ruta.nume}
                                    </Dropdown.Item>
                                ))}
                            </Dropdown.Menu>
                        </Dropdown>
                    </Form.Group>

                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant={isEditable ? "success" : "warning"} onClick={isEditable ? handleSalvare : handleEditare}>
                    {isEditable ? "Salvează Modificările" : "Editează"}
                </Button>
                <Button variant="secondary" onClick={onClose}>
                    Închide
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

ModalDetaliiAutobuz.propTypes = {
    autobuz: PropTypes.object.isRequired,
    onSave: PropTypes.func.isRequired,
    onClose: PropTypes.func.isRequired,
};

export default ModalDetaliiAutobuz;