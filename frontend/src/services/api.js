import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8899",
  headers: {
    "Content-Type": "application/json",
  },
});

export default api;
