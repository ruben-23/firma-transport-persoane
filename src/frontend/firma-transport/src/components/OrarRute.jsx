
import React, { useEffect, useState } from "react";
import { Container, Row, Col, Button, Table, Form } from "react-bootstrap";
import Dropdown from "react-bootstrap/Dropdown";
import CustomToggle from "./custom/CustomToggle.jsx";
import CustomMenu from "./custom/CustomMenu.jsx";
import localitateService from "../services/localitateService.js";
import orarService from "../services/orarService.js";
import '../Styles/OrarRute.css';


const OrarRute = () => {
  const [incarcare, setIncarcare] = useState(false);
  const [error, setError] = useState(null);
  const [punctDePlecare, setPunctDePlecare] = useState("");
  const [ziua, setZiua] = useState("");
  const [orareRute, setOrareRute] = useState([]);
  const [orareRuteFiltrate, setOrareRuteFiltrate] = useState([]);
  const [localitati, setLocalitati] = useState([]);

  useEffect(() => {
    const fetchOrareRute = async () => {
      try {
        setIncarcare(true);
        const data = await orarService.getOrareRute();
        setOrareRute(data);
      } catch (err) {
        console.error("Eroare la returnarea orarelor pentru rute:", err);
        setError(err);
      } finally {
        setIncarcare(false);
      }
    };
    fetchOrareRute();
  }, []);


  useEffect(() => {
    const fetchLocalitati = async () => {
      try {
        setIncarcare(true);
        const data = await localitateService.getAllLocalitati();
        setLocalitati(data);
      } catch (err) {
        console.error("Eroare la returnarea localitatilor:", err);
        setError(err);
      } finally {
        setIncarcare(false);
      }
    };
    fetchLocalitati();
  }, []);


  const handleSubmit = (event) => {
    event.preventDefault();

    const orareRuteFiltrate = orareRute.filter(
        (orar) => {

          // verificare daca localitatea de plecare selectata de utilizator si cea din orar sunt la fel
          const verifPunctDePlecare = punctDePlecare && (orar.plecare.toLowerCase() === punctDePlecare.toLowerCase());

          // verificare daca ziua selectata de utilizator si ziua din orar sunt la fel
          const verifZiua = ziua && (orar.zi.toLowerCase() === ziua.toLowerCase());

          // daca ziua nu e selectata, returneaza doar verificarea localitatii
          if (!ziua) {
            return verifPunctDePlecare;
          }

          // daca ziua e selectata, se verifica daca ambele conditii de zi si localitate sunt indeplinite
          return verifPunctDePlecare && verifZiua;
        });

    setOrareRuteFiltrate(orareRuteFiltrate);
  };

  const formatareOra = (ora) => {
    return ora ? ora.slice(0, 5) : ora;
  };

  return (
      <Container className="mt-5">
        <h1 className="text-center">Orar Rute</h1>

        <Form onSubmit={handleSubmit}>
          <Row className="mb-3">
            <Col md={6}>
              <Form.Group controlId="punctDePlecare">
                <Form.Label>Alegeți localitatea:</Form.Label>

                <Dropdown>
                  <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components">
                    {punctDePlecare || "Selectați localitatea"}
                  </Dropdown.Toggle>
                  <Dropdown.Menu as={CustomMenu}>
                    {localitati.map((localitate, index) => (
                        <Dropdown.Item
                            key={index}
                            onClick={() => setPunctDePlecare(localitate.nume)}
                        >
                          {localitate.nume}
                        </Dropdown.Item>
                    ))}
                  </Dropdown.Menu>
                </Dropdown>
              </Form.Group>
            </Col>
            <Col md={6}>
              <Form.Group controlId="ziua">
                <Form.Label>Alegeți ziua:</Form.Label>
                <Form.Select
                    value={ziua}
                    onChange={(e) => setZiua(e.target.value)}
                    style={{
                      display: "flex",
                      alignItems: "center",
                      justifyContent: "space-between",
                      padding: "10px",
                      border: "1px solid #ced4da",
                      borderRadius: "4px",
                      cursor: "pointer",
                      backgroundColor: "#fff",
                    }}
                >
                  <option value="">Selectați ziua</option>
                  <option value="Luni">Luni</option>
                  <option value="Marti">Marți</option>
                  <option value="Miercuri">Miercuri</option>
                  <option value="Joi">Joi</option>
                  <option value="Vineri">Vineri</option>
                  <option value="Sambata">Sâmbătă</option>
                  <option value="Duminica">Duminică</option>
                </Form.Select>
              </Form.Group>
            </Col>
          </Row>
          <Button variant="success" type="submit">
            Vezi orare
          </Button>
        </Form>

        {incarcare && <div>încărcare...</div>}
        {error && <div style={{
                color: "red",
                width: '200px',
                height: '100px',
                backgroundColor: 'white',
                textAlign: 'center',
                lineHeight: '100px', }}
        >Error: {error.message}</div>}

        <h2 className="mt-5">Listă Rute</h2>
        <Table striped bordered hover className="mt-3 custom-table">
          <thead>
          <tr className="ct-tr">
            <th className="ct-th">Ziua</th>
            <th className="ct-th">Ruta</th>
            <th className="ct-th">Plecare</th>
            <th className="ct-th">Ora</th>
            <th className="ct-th">Preț</th>
          </tr>
          </thead>

          <tbody>
          { (orareRuteFiltrate.length > 0) ?
              ( orareRuteFiltrate.map( (orar, index) => (
                      <tr key={index} className="ct-tr">
                        <td className="ct-td">{orar.zi}</td>
                        <td className="ct-td">{`${orar.rutaPlecare} - ${orar.rutaDestinatie}`}</td>
                        <td className="ct-td">{orar.plecare}</td>
                        <td className="ct-td">{formatareOra(orar.ora)}</td>
                        <td className="ct-td">{`${orar.pret} lei`}</td>
                      </tr>
                  ))
              ) : (
              <tr className="ct-tr">
                <td colSpan="5" className="text-center">
                  Nu există rute disponibile.
                </td>
              </tr>
          )}

          </tbody>
        </Table>
      </Container>
  );
};

export default OrarRute;


