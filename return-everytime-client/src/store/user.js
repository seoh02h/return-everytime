import user from "../api/user";

const state = {
  userList: [],
};

const mutations = {
  setUserList(state, payload) {
    state.userList = payload;
  },
};

const actions = {
  getUserList(context) {
    return user
      .getList()
      .then((res) => context.commit("setUserList", res));
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
