import React, {useEffect, useState} from 'react';
import { Card, Button } from 'react-bootstrap';
import '../Styles/InformatiiFirma.css';
import firmaService from "../services/firmaService.js";

const InformatiiFirma = () => {
    const [firma, setFirma] = useState(null);
    const [incarcare, setIncarcare] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchDetaliiFirma = async () => {
            try {
                const data = await firmaService.getFirmaById(1);
                setFirma(data);
            } catch (error) {
                setError(error.message);
            } finally {
                setIncarcare(false);
            }
        };

        fetchDetaliiFirma();
    }, []);

    if (incarcare) {
        return <div>Incarcare...</div>;
    }

    if (error) {
        return (
            <div style={{
                color: "red",
                width: '200px',
                height: '100px',
                backgroundColor: 'white',
                textAlign: 'center',
                lineHeight: '100px',
            }}>
                Eroare: {error}
            </div>
        );
    }

    return (
        <div className="d-flex justify-content-center align-items-center" style={{minHeight: '100vh'}}>
            <Card style={{width: '18rem'}} className="m-3">
                <Card.Body>
                    <Card.Title style={{fontWeight: 800}}>{firma.nume}</Card.Title>
                    <Card.Text>
                        Oferim servicii de transport persoane de calitate foarte bună.
                        Misiunea noastră este de a asigura transportul sigur și la timp pentru toți clienții noștri.
                    </Card.Text>

                    <Card.Text>
                        <strong>Informații de contact:</strong><br/>
                        <strong>Telefon:</strong> {firma.numarTelefon}<br/>
                        <strong>Email:</strong> {firma.email}<br/>
                        <strong>Adresa:</strong> {firma.adresa}<br/>
                    </Card.Text>
                    <div className="button-container">
                        <Button className= "buton-detalii" >Mai multe detalii</Button>
                    </div>
                </Card.Body>
            </Card>
        </div>
    );
};

export default InformatiiFirma;