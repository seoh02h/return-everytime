import axios from "axios";

const user = {
  getList() {
    return axios
      .get("/users")
      .then((res) => res.data)
      .catch(() => {});
  },
  register(email, name, password, phone) {
    return axios
      .post("/users", { email, name, password, phone })
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  },
  login(email, password) {
    return axios
      .post("/users/login", {
        email,
        password,
        role: "ROLE_USER",
      })
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  },
  getLoggedIn(token) {
    return axios
      .get("/users/logged-in", {
        headers: {
          Authorization: token,
        },
      })
      .then((res) => res.data)
      .catch(() => {});
  },
};

export default user;
