
import axios from 'axios';

const BASE_URL = 'http://localhost:8080/firma/localitati';

const localitateService = {

    getAllLocalitati: async () => {

        try {
            const raspuns = await axios.get(BASE_URL);
            return raspuns.data;
        } catch (error) {
            console.error('Eroare la returnarea localitatilor:', error);
            throw error;
        }
    },

    getLoclitateById: async (id) => {

        try{
            const raspuns = await axios.get(`${BASE_URL}/${id}`);
            return raspins.data;
        } catch (error) {
            console.error(`Eroare la returnarea localitatii cu id ${id}:`, error);
            throw error;
        }
    },

    adaugaLocalitate: async (localitate) => {

        try{
            const raspuns = await axios.post(BASE_URL, localitate);
            return raspuns.data;
        } catch (error) {
            console.error('Eroare la adaugarea localitatii', error);
            throw error;
        }
    },

    actualizareLocalitate: async (id, localitate) => {

        try{
            const raspuns = await axios.put(`${BASE_URL}/${id}`, localitate);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la actualizarea localitatii cu id ${id}`, error);
            throw error;
        }
    },

    stergeLocalitate: async (id) => {

        try{
            const raspuns = await axios.delete(`${BASE_URL}/${id}`);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la stergerea localitatii cu id ${id}`, error);
            throw error;
        }
    },
};

export default localitateService;