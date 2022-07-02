<template>
  <div>
    <h1 class="mt-3 ml-5">공지사항</h1>
    <v-btn elevation="2" href="/notices-add"> 등록 </v-btn>
    <NoticeList />
  </div>
</template>

<script>
import { mapGetters, mapMutations } from "vuex";
import NoticeList from "@/components/notice/NoticeList.vue";
export default {
  components: {
    NoticeList,
  },
  computed: {
    ...mapGetters("user", ["getCurrUser", "getIsAuth"]),
  },
  methods: {
    ...mapMutations("user", ["SET_LOGOUT"]),
    logout() {
      this.$router.push({ name: "Home" });
      this.SET_LOGOUT();
    },
  },
};
</script>

<style></style>
