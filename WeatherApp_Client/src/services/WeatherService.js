import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {

    getWeatherReport(request) {
        console.log(request);
        return http.get(`/weather?query=${request.query}&units=${request.units}`);
    }
}

