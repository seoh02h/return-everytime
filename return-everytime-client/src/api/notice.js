import axios from "axios";

const notice = {
  getList() {
    return axios.get("/notices");
  },
  get(id) {
    return axios.get(`/notices/${id}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem(
          "token"
        )}`,
      },
    });
  },
};

export default notice;
