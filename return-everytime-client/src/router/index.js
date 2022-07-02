import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home";
import Notice from "@/views/Notice";
import NoticeDetail from "@/views/NoticeDetail";
import NoticeAdd from "@/views/NoticeAdd";

import FreeBoard from "@/views/FreeBoard";
import MyPage from "@/views/MyPage";
import Member from "@/views/Member";
import Login from "@/views/Login";
import Register from "@/views/Register";
import Chatting from "@/views/Chatting";
import store from "@/store/index.js";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/my-page",
    name: "MyPage",
    component: MyPage,
    meta: { authRequired: true },
  },
  {
    path: "/notices",
    name: "Notice",
    component: Notice,
    meta: { authRequired: true },
  },
  {
    path: "/notices-add",
    name: "NoticeAdd",
    component: NoticeAdd,
    meta: { authRequired: true },
  },
  {
    path: "/notices/:noticeId",
    name: "NoticeDetail",
    component: NoticeDetail,
    meta: { authRequired: true },
  },
  {
    path: "/free-board",
    name: "FreeBoard",
    component: FreeBoard,
    meta: { authRequired: true },
  },
  {
    path: "/member",
    name: "Member",
    component: Member,
    meta: { authRequired: true },
  },
  {
    path: "/chatting",
    name: "Chatting",
    component: Chatting,
    meta: { authRequired: true },
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
    meta: { authNotRequired: true },
  },
  {
    path: "/register",
    name: "Register",
    component: Register,
    meta: { authNotRequired: true },
  },
];

const router = new VueRouter({
  mode: "history",
  routes,
});

router.beforeEach(function (to, from, next) {
  const authRequired = to.matched.some(function (
    routeInfo
  ) {
    return routeInfo.meta.authRequired;
  });

  const authNotRequired = to.matched.some(function (
    routeInfo
  ) {
    return routeInfo.meta.authNotRequired;
  });

  if (authRequired && !store.getters["user/getIsAuth"]) {
    alert("로그인이 필요합니다.");
    next({ name: "Login" });
  }
  if (authNotRequired && store.getters["user/getIsAuth"]) {
    next({ name: "Home" });
  }
  next();
});
export default router;
