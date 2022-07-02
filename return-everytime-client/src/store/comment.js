import comment from "@/api/comment";

const state = {};

const getters = {};

const mutations = {};

const actions = {
  SAVE_COMMENT(context, { content, userId, postId }) {
    return comment
      .save(content, userId, postId)
      .then((res) => {
        return res.data;
      });
  },
};
export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};
