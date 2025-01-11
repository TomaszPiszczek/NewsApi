import axios from 'axios';

const API_URL = 'http://51.20.68.13:8080/api';

export const fetchCities = async () => {
    try {
        const response = await axios.get(`${API_URL}/cities`);
        return response.data;
    } catch (error) {
        console.error('Error fetching city:', error);
        throw error;
    }
};

export const fetchStates = async () => {
    try {
        const response = await axios.get(`${API_URL}/states`);
        return response.data;
    } catch (error) {
        console.error('Error fetching state:', error);
        throw error;
    }
};
