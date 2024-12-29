import axios from "axios";

const BASE_URL = 'http://localhost:8080/firma';

const firmaService = {

    getAllFirme: async () => {
        try {
            const raspuns = await axios.get(BASE_URL);
            return raspuns.data;
        } catch (error) {
            console.error('Eroare la returnarea firmelor:', error);
            throw error;
        }
    },

    getFirmaById: async (id) => {
        try {
            const raspuns = await axios.get(`${BASE_URL}/${id}`);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la returnarea firmei cu id ${id}:`, error);
            throw error;
        }
    },

    adaugaFirma: async (firmaDTO) => {
        try {
            const raspuns = await axios.post(BASE_URL, firmaDTO);
            return raspuns.data;
        } catch (error) {
            console.error('Eroare la adaugarea firmei:', error);
            throw error;
        }
    },

    actualizareFirma: async (id, firmaDTO) => {
        try {
            const raspuns = await axios.put(`${BASE_URL}/${id}`, firmaDTO);
            return raspuns.data;
        } catch (error) {
            console.error(`Eroare la actualizarea firmei cu id ${id}:`, error);
            throw error;
        }
    },

    stergeFirma: async (id) => {
        try {
            await axios.delete(`${BASE_URL}/${id}`);
        } catch (error) {
            console.error(`Eroare la stergerea firmei cu id ${id}:`, error);
            throw error;
        }
    }
};

export default firmaService;