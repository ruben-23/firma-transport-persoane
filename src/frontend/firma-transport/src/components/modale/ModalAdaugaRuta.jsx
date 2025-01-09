import React, { useState } from 'react';
import {Modal, Button, Form, InputGroup} from 'react-bootstrap';
import PropTypes from 'prop-types';
import Dropdown from "react-bootstrap/Dropdown";
import CustomToggle from "../custom/CustomToggle.jsx";
import CustomMenu from "../custom/CustomMenu.jsx";
import '../../Styles/ModalAdaugaRuta.css';
import localitateService from "../../services/localitateService.js";

const ModalAdaugaRuta = ({ onClose, onSave, localitati, onAdaugaLocalitate}) => {
    const [formData, setFormData] = useState({
        localitatePlecare: '',
        localitateDestinatie: '',
        localitateNoua: '',
    });

    const handleAdaugareRuta = () => {
        onSave(formData);
        onClose();
    };

    const handleAdaugaLocalitate = async () => {
        try {
            const localitateNoua = formData.localitateNoua.trim();
            if (localitateNoua) {
                await localitateService.adaugaLocalitate({ nume: localitateNoua });
                onAdaugaLocalitate(localitateNoua);
                setFormData({ ...formData, localitateNoua: '' });
            } else {
                alert("Vă rugăm să introduceți un nume pentru localitate.");
            }
        } catch (err) {
            console.error("Eroare la adăugarea localității:", err);
            alert("A apărut o eroare la adăugarea localității.");
        }

    };

    return (
        <Modal show={true} onHide={onClose} className="modal-adauga-ruta">
            <Modal.Header closeButton>
                <Modal.Title>Adaugă Ruta</Modal.Title>
            </Modal.Header>
            <Modal.Body className="mdr-body">
                <Form>
                    <Form.Group controlId="localitatePlecare" className="mdr-form-group">
                        <Form.Label className="mdr-form-label">Alegeți localitatea de plecare</Form.Label>
                        <Dropdown>
                            <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components">
                                {formData.localitatePlecare || "Selectați localitatea de plecare"}
                            </Dropdown.Toggle>
                            <Dropdown.Menu as={CustomMenu}>
                                {localitati.map((localitate, index) => (
                                    <Dropdown.Item
                                        key={index}
                                        onClick={() => setFormData({ ...formData,localitatePlecare: localitate.nume })}
                                    >
                                        {localitate.nume}
                                    </Dropdown.Item>
                                ))}
                            </Dropdown.Menu>
                        </Dropdown>
                    </Form.Group>

                    <Form.Group controlId="LocalitateDestinatie" className="mdr-form-group">
                        <Form.Label className="mdr-form-label">Alegeți localitatea de destinație</Form.Label>
                        <Dropdown>
                            <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components">
                                {formData.localitateDestinatie || "Selectați localitatea de destinație"}
                            </Dropdown.Toggle>
                            <Dropdown.Menu as={CustomMenu}>
                                {localitati.map((localitate, index) => (
                                    <Dropdown.Item
                                    key={index}
                                    onClick={() => setFormData({ ...formData, localitateDestinatie: localitate.nume })}
                                    >
                                        {localitate.nume}
                                    </Dropdown.Item>
                                    ))}
                            </Dropdown.Menu>
                        </Dropdown>
                    </Form.Group>

                    <Form.Group controlId="localitateNoua" className="mdr-form-group">
                        <Form.Label className="mdr-form-label">Adăugați o localitate nouă</Form.Label>
                        <InputGroup>
                            <Form.Control
                                type="text"
                                placeholder="Introduceți numele localității"
                                value={formData.localitateNoua}
                                onChange={(e) => setFormData({ ...formData, localitateNoua: e.target.value })}
                            />
                            <Button variant="outline-secondary" onClick={handleAdaugaLocalitate}>
                                Adaugă
                            </Button>
                        </InputGroup>
                    </Form.Group>

                </Form>
            </Modal.Body>
            <Modal.Footer className="mdr-footer">
                <Button className="btn btn-success" onClick={handleAdaugareRuta}>
                    Adaugă Ruta
                </Button>
            </Modal.Footer>
        </Modal>

    );
};

ModalAdaugaRuta.propTypes = {
    onClose: PropTypes.func.isRequired,
    onSave: PropTypes.func.isRequired,
    localitati: PropTypes.array.isRequired,
};

export default ModalAdaugaRuta;