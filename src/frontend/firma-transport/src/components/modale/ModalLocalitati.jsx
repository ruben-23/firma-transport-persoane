
import React, { useEffect, useState } from "react";
import { Button, Modal, Table } from "react-bootstrap";
import rutaService from "../../services/rutaService.js";
import '../../Styles/ModalLocalitati.css';

const ModalLocalitati = ({ ruta, onClose }) => {
    const [localitati, setLocalitati] = useState([
        {
            idLocalitate: null,
            localitate: '',
            ordine: '',
            pret: '',
            isNew: true,
            isEdited: false,
            isEditable: true,
        },
    ]);

    useEffect(() => {
        const fetchLocalitati = async () => {
            if (ruta?.idRuta) {
                try {
                    const localitati = await rutaService.getLocalitatiSiPreturiRuta(ruta.idRuta);
                    const localitatiMapate = localitati.map((item) => ({
                        idLocalitate: item.idLocalitate,
                        localitate: item.localitate,
                        ordine: item.ordine,
                        pret: item.pret,
                        isNew: false,
                        isEdited: false,
                        isEditable: false,
                    }));

                    setLocalitati([
                        {
                            idLocalitate: null,
                            localitate: '',
                            ordine: '',
                            pret: '',
                            isNew: true,
                            isEdited: false,
                            isEditable: true,
                        },
                        ...localitatiMapate,
                    ]);
                } catch (error) {
                    console.error("Eroare la încărcarea localităților:", error);
                }
            }
        };

        fetchLocalitati();
    }, [ruta]);

    const handleModificare = (id, field, value) => {
        setLocalitati((prev) =>
            prev.map((item) =>
                item.idLocalitate === id || (id === null && item.idLocalitate === null)
                    ? { ...item, [field]: value, isEdited: true }
                    : item
            )
        );
    };

    const handleAdaugare = async () => {

    };

    const handleSalvare = async (id) => {

        setLocalitati((prev) =>
                prev.map((element) => element.idLocalitate === id
                    ? { ...element, isEditable: false, isEdited: false }
                    : element
                )
            );

    };

    const handleEditare = (id) => {
        setLocalitati((prev) =>
            prev.map((element) =>
                element.idLocalitate === id ? { ...element, isEditable: true } : element
            )
        );
    };

    const handleStergere = async (id) => {

    };

    return (
        <Modal show={true} onHide={onClose}>
            <Modal.Header closeButton>
                <Modal.Title>Localități și Prețuri</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Table striped bordered hover>
                    <thead className="bg-dark">
                    <tr>
                        <th>Localitate</th>
                        <th>Ordine</th>
                        <th>Preț</th>
                        <th>Acțiuni</th>
                    </tr>
                    </thead>
                    <tbody>
                    {localitati.map((localitate) => (
                        <tr key={localitate.idLocalitate ?? "new"}>
                            <td>
                                <input
                                    type="text"
                                    className="form-control"
                                    value={localitate.localitate}
                                    onChange={(e) =>
                                        handleModificare(localitate.idLocalitate, 'localitate', e.target.value)
                                    }
                                    disabled={!localitate.isEditable}
                                />
                            </td>
                            <td>
                                <input
                                    type="number"
                                    className="form-control"
                                    value={localitate.ordine}
                                    onChange={(e) =>
                                        handleModificare(localitate.idLocalitate, 'ordine', e.target.value)
                                    }
                                    disabled={!localitate.isEditable}
                                />
                            </td>
                            <td>
                                <input
                                    type="number"
                                    className="form-control"
                                    value={localitate.pret}
                                    onChange={(e) =>
                                        handleModificare(localitate.idLocalitate, 'pret', e.target.value)
                                    }
                                    disabled={!localitate.isEditable}
                                />
                            </td>
                            <td>
                                {localitate.isNew ? (
                                    <Button variant="success" onClick={handleAdaugare}>
                                        Adaugă
                                    </Button>
                                ) : localitate.isEditable ? (
                                    <Button variant="success" onClick={() => handleSalvare(localitate.idLocalitate)}>
                                        Salvează
                                    </Button>
                                ) : (
                                    <Button variant="secondary" onClick={() => handleEditare(localitate.idLocalitate)}>
                                        Editează
                                    </Button>
                                )}
                                {!localitate.isNew && (
                                    <Button
                                        variant="danger"
                                        onClick={() => handleStergere(localitate.idLocalitate)}
                                    >
                                        Șterge
                                    </Button>
                                )}
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </Table>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={onClose}>
                    Închide
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

export default ModalLocalitati;
