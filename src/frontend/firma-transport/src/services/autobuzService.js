import axios from 'axios';

const BASE_URL = 'http://localhost:8080/firma/autobuze';

const autobuzService = {

    getAllAutobuze: async () => {
        try {
            const raspuns = await axios.get(BASE_URL);
            return raspuns.data;
        } catch (error) {
            console.error('Eroare la returnarea autobuzelor:', error);
            throw error;
        }
    },

    getAutobuzById: async (id) => {
        try {
            const raspuns = await axios.get(`${BASE_URL}/${id}`);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la returnarea autobuzului cu id ${id}:`, error);
            throw error;
        }
    },

    adaugaAutobuz: async (autobuz) => {
        try {
            const raspuns = await axios.post(BASE_URL, autobuz);
            return raspuns.data;
        } catch (error) {
            console.error('Eroare la adaugarea autobuzului', error);
            throw error;
        }
    },

    actualizareAutobuz: async (id, autobuz) => {
        try {
            const raspuns = await axios.put(`${BASE_URL}/${id}`, autobuz);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la actualizarea autobuzului cu id ${id}`, error);
            throw error;
        }
    },

    stergeAutobuz: async (id) => {
        try {
            const raspuns = await axios.delete(`${BASE_URL}/${id}`);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la stergerea autobuzului cu id ${id}`, error);
            throw error;
        }
    },
};

export default autobuzService;