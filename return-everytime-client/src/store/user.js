import user from "../api/user";

const state = {
  userList: [],
  isAuth: false,
  currUser: {},
  authToken: "",
};

const getters = {
  getAuthToken(state) {
    return state.authToken;
  },
  getCurrUser(state) {
    return state.currUser;
  },
};

const mutations = {
  setIsAuthTrue(state) {
    state.isAuth = true;
  },
  setUserList(state, payload) {
    state.userList = payload;
  },
  setAuthToken(state, payload) {
    state.authToken = payload;
  },
  setCurrUser(state, payload) {
    state.currUser = payload;
  },
};

const actions = {
  getUserList(context) {
    console.log("getUser");
    return user
      .getList()
      .then((res) => context.commit("setUserList", res));
  },
  register(context, { email, name, password, phone }) {
    return user
      .register(email, name, password, phone)
      .then(() => context.dispatch("getUserList"))
      .catch((e) => {
        throw new Error(e.message);
      });
  },
  login(context, { email, password }) {
    return user
      .login(email, password)
      .then((data) => {
        context.commit("setIsAuthTrue");
        context.commit("setAuthToken", data.token);
      })
      .catch((e) => {
        throw new Error(e.message);
      });
  },
  getLoggedIn(context) {
    return user
      .getLoggedIn(context.getters.getAuthToken)
      .then((data) => context.commit("setCurrUser", data));
  },
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};
