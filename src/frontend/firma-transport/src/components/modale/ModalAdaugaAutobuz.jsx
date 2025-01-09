import React, {useEffect, useState} from 'react';
import { Modal, Button, Form } from 'react-bootstrap';
import PropTypes from 'prop-types';
import Dropdown from "react-bootstrap/Dropdown";
import CustomToggle from "../custom/CustomToggle.jsx";
import CustomMenu from "../custom/CustomMenu.jsx";
import '../../Styles/ModalAdaugaRuta.css';
import localitateService from "../../services/localitateService.js";
import rutaService from "../../services/rutaService.js";

const ModalAdaugaAutobuz = ({ onClose, onSave }) => {
    const [formData, setFormData] = useState({
        numarInmatriculare: '',
        capacitate: '',
        status: 'Disponibil',
        idRuta: '',
    });
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

    const handleAdaugareAutobuz = () => {
        onSave(formData);
        onClose();
    };

    return (
        <Modal show={true} onHide={onClose} className="modal-adauga-autobuz">
            <Modal.Header closeButton>
                <Modal.Title>Adaugă Autobuz</Modal.Title>
            </Modal.Header>
            <Modal.Body className="mda-body">
                <Form>
                    <Form.Group controlId="numarInmatriculare" className="mda-form-group">
                        <Form.Label className="mda-form-label">Număr Înmatriculare</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Introduceți numărul de înmatriculare"
                            value={formData.numarInmatriculare}
                            onChange={(e) => setFormData({ ...formData, numarInmatriculare: e.target.value })}
                        />
                    </Form.Group>

                    <Form.Group controlId="capacitate" className="mda-form-group">
                        <Form.Label className="mda-form-label">Capacitate</Form.Label>
                        <Form.Control
                            type="number"
                            placeholder="Introduceți capacitatea"
                            value={formData.capacitate}
                            onChange={(e) => setFormData({ ...formData, capacitate: e.target.value })}
                        />
                    </Form.Group>

                    <Form.Group controlId="status" className="mda-form-group">
                        <Form.Label className="mda-form-label">Status</Form.Label>
                        <Form.Select
                            value={formData.status}
                            onChange={(e) => setFormData({ ...formData, status: e.target.value })}
                        >
                            <option value="Disponibil">Disponibil</option>
                            <option value="Indisponibil">Indisponibil</option>
                        </Form.Select>
                    </Form.Group>

                    <Form.Group controlId="idRuta" className="mda-form-group">
                        <Form.Label className="mda-form-label">Ruta</Form.Label>
                        <Dropdown>
                            <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-ruta">
                                {formData.idRuta ? rute.find(r => r.idRuta === formData.idRuta)?.nume : "Selectați o rută"}
                            </Dropdown.Toggle>
                            <Dropdown.Menu as={CustomMenu}>
                                {rute.map((ruta) => (
                                <Dropdown.Item
                                    key={ruta.idRuta}
                                    onClick={() => setFormData({ ...formData, idRuta: ruta.idRuta })}
                                >
                                    {ruta.nume}
                                </Dropdown.Item>
                                ))}
                            </Dropdown.Menu>
                        </Dropdown>
                    </Form.Group>

                </Form>
            </Modal.Body>
            <Modal.Footer className="mda-footer">
                <Button className="btn btn-success" onClick={handleAdaugareAutobuz}>
                    Adaugă Autobuz
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

ModalAdaugaAutobuz.propTypes = {
    onClose: PropTypes.func.isRequired,
    onSave: PropTypes.func.isRequired,
};

export default ModalAdaugaAutobuz;