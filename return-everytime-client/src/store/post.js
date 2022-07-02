import post from "@/api/post";

const state = {
  postList: [],
};

const getters = {
  getPostList(state) {
    return state.postList;
  },
};

const mutations = {
  SET_POST_LIST(state, postList) {
    state.postList = postList;
  },
};

const actions = {
  FETCH_POST_LIST(context) {
    return post
      .getList()
      .then((res) =>
        context.commit("SET_POST_LIST", res.data)
      );
  },
  FETCH_POST(context, { id }) {
    return post
      .get(id)
      .then((res) => {
        return res.data;
      })
      .catch((error) => {
        throw new Error(error.response.data.message);
      });
  },
  SAVE_POST(context, { content, title, userId }) {
    return post
      .save(content, title, userId)
      .then((res) => {
        return res.data;
      })
      .catch((error) => {
        throw new Error(error.response.data.message);
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
