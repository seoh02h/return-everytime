<template>
  <div>
    <v-container v-if="getIsAuth">
      <v-row>
        <v-col class="text-sm-center"
          >반갑습니다. {{ getCurrUser.name }}님</v-col
        >
      </v-row>
      <v-row>
        <v-col class="text-sm-center">
          <router-link to="Login">마이페이지</router-link>
        </v-col>
        <v-col
          class="text-sm-center logout-btn"
          @click="logout"
        >
          로그아웃
        </v-col>
      </v-row>
    </v-container>
    <v-container v-else>
      <v-row>
        <v-col class="text-sm-center">
          로그인 해주세요
        </v-col>
      </v-row>
      <v-row>
        <v-col class="text-sm-center">
          <router-link to="Login">로그인</router-link>
        </v-col>
        <v-col class="text-sm-center"
          ><router-link to="Register"
            >회원가입</router-link
          ></v-col
        >
      </v-row>
    </v-container>
  </div>
</template>

<script>
import { mapGetters, mapMutations } from "vuex";
export default {
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

<style scoped>
a {
  text-decoration: none;
}
.logout-btn {
  cursor: pointer;
}
</style>
