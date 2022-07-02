<template>
  <v-container>
    <v-row>
      <v-col class="ma-3">
        <h2 class="mb-3 text-center">채팅목록</h2>
        <v-divider></v-divider>
      </v-col>
    </v-row>
    <v-row class="mx-16 chat-box" @click="goToChattingRoom">
      <v-col class="d-flex align-center">
        <img
          src="http://localhost:8080/uploads/user.png"
          width="50px"
        />
        <div>
          <div class="ml-4 text-h6">김민지</div>
          <div class="ml-4">아아아아</div>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapState, mapActions } from "vuex";
export default {
  data() {
    return {};
  },
  computed: {
    ...mapState("user", ["userList"]),
  },
  methods: {
    ...mapActions("user", ["getUserList"]),
    goToChattingRoom() {
      this.$router.push("/chatting/1");
    },
  },
  mounted() {
    this.getUserList();
  },
};
</script>

<style>
.chat-box {
  cursor: pointer;
}
</style>
