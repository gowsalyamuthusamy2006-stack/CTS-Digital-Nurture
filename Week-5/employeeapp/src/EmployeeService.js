import axios from "axios";

const URL = "https://jsonplaceholder.typicode.com/users";

export const getEmployees = () => {
    return axios.get(URL);
};