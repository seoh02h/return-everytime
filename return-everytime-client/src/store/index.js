import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";
import user from "./user";
import notice from "./notice";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    user,
    notice,
  },
  plugins: [
    createPersistedState({
      path: ["user", "notice"],
    }),
  ],
});

export default store;
