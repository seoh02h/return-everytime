import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";
import user from "./user";
import notice from "./notice";
import post from "./post";
import comment from "./comment";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    user,
    notice,
    post,
    comment,
  },
  plugins: [
    createPersistedState({
      path: ["user", "notice", "post", "comment"],
    }),
  ],
});

export default store;
