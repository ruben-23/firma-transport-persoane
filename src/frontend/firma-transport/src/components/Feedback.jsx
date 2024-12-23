import React, { useState } from "react";
import { Form, Button, Container } from "react-bootstrap";

const Feedback = () => {
  const [tipFeedback, setTipFeedback] = useState("sugestie");
  const [mesaj, setMesaj] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    
    console.log("Tip Feedback:", tipFeedback);
    console.log("Mesaj:", mesaj);

    setTipFeedback("sugestie");
    setMesaj("");
  };

  return (
    <Container className="mt-5">
      <h2>Feedback</h2>
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="tipFeedback">
          <Form.Label>Tipul Feedback-ului</Form.Label>
          <Form.Select
            value={tipFeedback}
            onChange={(e) => setTipFeedback(e.target.value)}
          >
            <option value="sugestie">Sugestie</option>
            <option value="reclamatie">Reclamație</option>
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
