import axios from "axios";

const comment = {
  save(content, userId, postId) {
    return axios.post(`/comments`, {
      content,
      userId,
      postId,
    });
  },
};

export default comment;
