import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home";
import Notice from "@/views/Notice";
import FreeBoard from "@/views/FreeBoard";
import Study from "@/views/Study";
import MyPage from "@/views/MyPage";
import Member from "@/views/Member";

import Chatting from "@/views/Chatting";

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
  },
  {
    path: "/notice",
    name: "Notice",
    component: Notice,
  },
  {
    path: "/study",
    name: "Study",
    component: Study,
  },
  {
    path: "/free-board",
    name: "FreeBoard",
    component: FreeBoard,
  },
  {
    path: "/member",
    name: "Member",
    component: Member,
  },
  {
    path: "/chatting",
    name: "Chatting",
    component: Chatting,
  },
];

const router = new VueRouter({
  mode: "history",
  routes,
});

export default router;
