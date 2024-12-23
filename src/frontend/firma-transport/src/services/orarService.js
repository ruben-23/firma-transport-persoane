
import axios from "axios";

const BASE_URL = 'http://localhost:8080/firma/orare';

const orarService = {

    getAllOrare: async () => {

        try {
            const raspuns = await axios.get(BASE_URL);
            return raspuns.data;
        } catch (error) {
            console.error('Eroare la returnarea orarelor:', error);
            throw error;
        }
    },

    getOrarById: async (id) => {

        try {
            const raspuns = await axios.get(`${BASE_URL}/${id}`);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la returnarea orarului cu id ${id}`, error);
            throw error;
        }
    },

    adaugaOrar: async (orar) => {

        try {
            const raspuns = await axios.post(BASE_URL, orar);
            return raspuns.data;
        } catch (error) {
            console.error('Eroare la adaugarea orarului:', error);
            throw error;
        }
    },

    actualizareOrar: async (id, orar) => {

        try {
            const raspuns = await axios.put(`${BASE_URL}/${id}`, orar);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la actualizarea orarului cu id ${id}`, error);
            throw error;
        }
    },

    stergeOrar: async (id) => {

        try {
            const raspuns = await axios.delete(`${BASE_URL}/${id}`);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la stergerea orarului cu id ${id}`, error);
            throw error;
        }
    },

    getOrareRute: async () => {

        try {
            const raspuns = await axios.get(`${BASE_URL}/rute`);
            return raspuns.data;
        } catch (error) {
            console.error('Eroare la returnarea orarelor pentru rute:', error);
            throw error;
        }
    },
}

export default orarService;