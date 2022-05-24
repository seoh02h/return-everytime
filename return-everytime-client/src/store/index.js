import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";
import user from "./user";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    user,
  },
  plugins: [
    createPersistedState({
      path: ["user"],
    }),
  ],
});

export default store;
