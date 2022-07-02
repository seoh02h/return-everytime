import axios from "axios";

const post = {
  getList() {
    return axios.get("/posts", {
      headers: {
        Authorization: `Bearer ${localStorage.getItem(
          "token"
        )}`,
      },
    });
  },
  get(id) {
    return axios.get(`/posts/${id}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem(
          "token"
        )}`,
      },
    });
  },
  save(content, title, userId) {
    return axios.post("/posts", {
      content,
      title,
      userId,
    });
  },
  saveImage(postId, formdata) {
    return axios.post(`/posts/${postId}/images`, formdata, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });
  },
};

export default post;
