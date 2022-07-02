import notice from "@/api/notice";

const state = {
  noticeList: [],
};

const getters = {
  getNoticeList(state) {
    return state.noticeList;
  },
};
const mutations = {
  SET_NOTICE_LIST(state, noticeList) {
    state.noticeList = noticeList;
  },
};

const actions = {
  FETCH_NOTICE_LIST(context) {
    return notice
      .getList()
      .then((res) =>
        context.commit("SET_NOTICE_LIST", res.data)
      );
  },
  FETCH_NOTICE(context, { id }) {
    return notice
      .get(id)
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
