<template>
  <v-navigation-drawer permanent app clipped>
    <v-list-item> 로그인 해주세요. </v-list-item>
    <v-divider></v-divider>

    <v-list dense nav>
      <v-list-item> Menu </v-list-item>
      <v-list-item
        v-for="menu in menuList"
        :key="menu.title"
        link
        :to="menu.to"
      >
        <v-list-item-icon>
          <v-icon>{{ menu.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>{{
            menu.title
          }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
export default {
  data() {
    return {
      menuList: [
        {
          title: "공지사항",
          icon: "mdi-home",
          to: "/notice",
        },
        {
          title: "자유게시판",
          icon: "mdi-view-dashboard",
          to: "/free-board",
        },
        {
          title: "스터디",
          icon: "mdi-book-open-variant",
          to: "/study",
        },
        {
          title: "멤버",
          icon: "mdi-account-multiple",
          to: "/member",
        },
        {
          title: "채팅목록",
          icon: "mdi-chat",
          to: "/chatting",
        },
      ],
      right: null,
    };
  },
};
</script>

<style></style>
