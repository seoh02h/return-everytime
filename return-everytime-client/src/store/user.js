import user from "../api/user";

const state = {
  userList: [],
  isAuth: false,
  currUser: {},
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
