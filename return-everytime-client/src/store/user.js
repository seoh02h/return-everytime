import user from "../api/user";

const state = {
  userList: [],
  isAuth: false,
  currUser: {},
};

const getters = {
  getIsAuth(state) {
    return state.isAuth;
  },
  getCurrUser(state) {
    return state.currUser;
  },
};

const mutations = {
  SET_ISAUTH(state, isAuth) {
    state.isAuth = isAuth;
  },
  SET_LOGIN(state, user) {
    localStorage.setItem("token", user.token);
    state.isAuth = true;
    state.currUser = user;
  },
  SET_LOGOUT(state) {
    state.isAuth = false;
    state.currUser = {};
    state.authToken = "";
  },
  setUserList(state, payload) {
    state.userList = payload;
  },

  SET_CURRUSER(state, currUser) {
    state.currUser = currUser;
  },
};

const actions = {
  FETCH_USER_LIST(context) {
    return user
      .getList()
      .then((res) =>
        context.commit("setUserList", res.data)
      )
      .catch((error) => console.log(error));
  },
  REGISTER(context, { email, name, password, phone }) {
    return user
      .register(email, name, password, phone)
      .then(() => context.dispatch("FETCH_USER_LIST"))
      .catch((error) => {
        throw new Error(error.response.data.message);
      });
  },
  LOGIN(context, { email, password, isAdmin }) {
    return user
      .login(email, password, isAdmin)
      .then((res) => {
        context.commit("SET_LOGIN", res.data);
      })
      .catch((error) => {
        throw new Error(error.response.data.message);
      });
  },
  FETCH_LOGGEDIN(context) {
    return user
      .getLoggedIn()
      .then((res) =>
        context.commit("SET_CURRUSER", res.data)
      );
  },
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};
