
import axios from 'axios';

const BASE_URL = 'http://localhost:8080/firma/feedbackuri';

const feedbackService = {

    getAllFeedbackuri: async () => {

        try {
            const raspuns = await axios.get(BASE_URL);
            return raspuns.data;
        } catch(error) {
            console.error("Eroare la returnarea feedbackurilor:", error);
            throw error;
        }
    },

    getFeedbackById: async (id) => {

        try {
            const raspuns = await axios.get(`${BASE_URL}/${id}`);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la returnarea feedbackului cu id ${id}:`, error);
            throw error;
        }
    },

    adaugaFeedback: async (feedback) => {

        try {
            const raspuns = await axios.post(BASE_URL, feedback);
            return raspuns.data;
        } catch(error) {
            console.error("Eroare la adaugarea feedbackului:", error);
            throw error;
        }
    },

    actualizeazaFeedback: async (id, feedback) => {

        try {
            const raspuns = await axios.put(`${BASE_URL}/${id}`, feedback);
            return raspuns.data;
        } catch(error) {
            console.error(`Eroare la actualizarea feedbackului cu id ${id}:`, error);
            throw error;
        }
    },

    stergeFeedback: async (id) => {

        try {
            const raspuns = await axios.delete(`${BASE_URL}/${id}`);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la stergerea feedbackului cu id ${id}`, error);
            throw error;
        }
    },

};

export default feedbackService;