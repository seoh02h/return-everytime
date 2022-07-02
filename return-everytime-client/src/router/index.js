import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home";
import NoticeListView from "@/views/NoticeListView";
import Notice from "@/views/Notice";
import NoticeAdd from "@/views/NoticeAdd";
import PostAdd from "@/views/PostAdd";
import PostListView from "@/views/PostListView";
import PostView from "@/views/PostView";
import MyPage from "@/views/MyPage";
import Member from "@/views/Member";
import Login from "@/views/Login";
import Register from "@/views/Register";
import Chatting from "@/views/Chatting";
import ChattingList from "@/views/ChattingList";

import store from "@/store/index.js";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/mypage",
    name: "MyPage",
    component: MyPage,
    meta: { authRequired: true },
  },
  {
    path: "/notices",
    name: "NoticeListView",
    component: NoticeListView,
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
    name: "Notice",
    component: Notice,
    meta: { authRequired: true },
  },
  {
    path: "/posts",
    name: "PostListView",
    component: PostListView,
    meta: { authRequired: true },
  },
  {
    path: "/posts-add",
    name: "PostAdd",
    component: PostAdd,
    meta: { authRequired: true },
  },
  {
    path: "/posts/:postId",
    name: "PostView",
    component: PostView,
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
    name: "ChattingList",
    component: ChattingList,
    meta: { authRequired: true },
  },
  {
    path: "/chatting/:chattingId",
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
