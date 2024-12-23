import React, { useState } from "react";
import {Form, Button, Container, Alert} from "react-bootstrap";
import feedbackService from "../services/feedbackService.js";

const Feedback = () => {
  const [tipFeedback, setTipFeedback] = useState("Sugestie");
  const [mesaj, setMesaj] = useState("");
  const [error, setError] = useState(null);
  const [succes, setSucces] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const feedback = {
      "tip": tipFeedback,
      "timpTrimitere": Date.now(),
      "mesaj": mesaj
    };

    try {
      await feedbackService.adaugaFeedback(feedback);
      setSucces(true);
      setError(null);
    } catch (err) {
        setError("A aparut o eroare la trimiterea feedback-ului.");
        setSucces(false);
    }

    setMesaj("");
  };

  return (
    <Container className="mt-5">
      <h2>Feedback</h2>
      {error && <Alert variant="danger">{error}</Alert>}
      {succes && <Alert variant="success">Feedback-ul a fost trimis cu succes!</Alert>}
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="tipFeedback">
          <Form.Label>Tipul Feedback-ului</Form.Label>
          <Form.Select
            value={tipFeedback}
            onChange={(e) => setTipFeedback(e.target.value)}
          >
            <option value="Sugestie">Sugestie</option>
            <option value="Reclamatie">Reclamație</option>
          </Form.Select>
        </Form.Group>

        <Form.Group controlId="mesaj" className="mt-3">
          <Form.Label>Mesaj</Form.Label>
          <Form.Control
            as="textarea"
            rows={3}
            value={mesaj}
            onChange={(e) => setMesaj(e.target.value)}
            placeholder="Scrie mesajul aici"
            required
          />
        </Form.Group>

        <Button variant="primary" type="submit" className="mt-3">
          Trimite Feedback
        </Button>
      </Form>
    </Container>
  );
};

export default Feedback;
