import axios from "axios";

const user = {
  getList() {
    return axios.get("/users");
  },
  register(email, name, password, phone) {
    return axios.post("/users", {
      email,
      name,
      password,
      phone,
    });
  },
  login(email, password, isAdmin) {
    return axios.post("/users/login", {
      email,
      password,
      isAdmin,
    });
  },
  getLoggedIn() {
    return axios.get("/users/logged-in");
  },
};

export default user;
