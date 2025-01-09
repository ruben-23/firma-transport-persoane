import axios from 'axios';

const BASE_URL = 'http://localhost:8080/firma/rute';

const rutaService = {
    getAllRute: async () => {
        try {
            const response = await axios.get(BASE_URL);
            return response.data;
        } catch (error) {
            console.error('Eroare la returnarea rutelor:', error);
            throw error;
        }
    },

    getRutaById: async (id) => {
        try {
            const response = await axios.get(`${BASE_URL}/${id}`);
            return response.data;
        } catch (error) {
            console.error(`Eroare la returnarea rutei cu id ${id}:`, error);
            throw error;
        }
    },

    getLocalitatiSiPreturiRuta: async (id) => {

        try{
            const raspuns = await axios.get(`${BASE_URL}/${id}/localitati/preturi`);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la returnarea localitatilor si preturilor pentru ruta cu id ${id}:`, error);
            throw error;
        }
    },


    adaugaRuta: async (ruta) => {
        try {
            const response = await axios.post(BASE_URL, ruta);
            return response.data;
        } catch (error) {
            console.error('Eroare la adaugarea rutei', error);
            throw error;
        }
    },

    actualizareRuta: async (id, ruta) => {
        try {
            const response = await axios.put(`${BASE_URL}/${id}`, ruta);
            return response.data;
        } catch (error) {
            console.error(`Eroare la actualizarea rutei cu id ${id}`, error);
            throw error;
        }
    },

    stergeRuta: async (id) => {
        try {
            const response = await axios.delete(`${BASE_URL}/${id}`);
            return response.data;
        } catch (error) {
            console.error(`Eroare la stergerea rutei cu id ${id}`, error);
            throw error;
        }
    },
};

export default rutaService;