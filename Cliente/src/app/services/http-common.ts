import axios from "axios";
import {properties} from "../../properties";
//clean code: propiedades de archivo properties en vex de hardcoded
export default axios.create({
  baseURL: properties.baseURL,
  headers: {
    "Content-type": "application/json"
  }, auth: {
    username: properties.username,
    password: properties.password
  }
});
