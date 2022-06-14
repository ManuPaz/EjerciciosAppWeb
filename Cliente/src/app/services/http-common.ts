import axios from "axios";
export default axios.create({
  baseURL: "http://localhost:8080/juegos",
  headers: {
    "Content-type": "application/json"
  }, auth: {
    username: 'admin',
    password: 'manuel'
  }
});
