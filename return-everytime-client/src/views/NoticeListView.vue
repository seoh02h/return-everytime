<template>
  <v-container>
    <v-row>
      <v-col class="ma-3">
        <h2 class="mb-3 text-center">공지사항</h2>
        <v-divider></v-divider>
      </v-col>
    </v-row>
    <v-row class="d-flex justify-center" no-gutters>
      <v-col class="justify-space-between"></v-col>
      <v-col class="justify-space-between" cols="6">
        <v-row justify="center" align="center">
          <v-col cols="10">
            <v-text-field
              placeholder="검색어를 입력하세요"
            ></v-text-field>
          </v-col>
          <v-col class="pa-0">
            <v-btn text rounded class="pa-0">
              <v-icon>mdi-magnify</v-icon>
            </v-btn>
          </v-col>
        </v-row>
      </v-col>
      <v-col class="justify-space-between text-right mt-2">
        <v-btn
          v-if="getCurrUser.isAdmin"
          class="mr-10"
          fab
          dark
          color="primary"
          href="/notices-add"
        >
          <v-icon dark> mdi-pencil </v-icon>
        </v-btn>
      </v-col>
    </v-row>
    <v-row class="mx-9">
      <NoticeList />
    </v-row>
  </v-container>
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
