import axios from "axios";

const user = {
  getList() {
    return axios
      .get("/user")
      .then((res) => res.data)
      .catch(() => {});
  },
};

export default user;
