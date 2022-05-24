<template>
  <div>
    <v-container v-if="isAuth">
      <v-row>
        <v-col class="text-sm-center">반갑습니다</v-col>
      </v-row>
      <v-row>
        <v-col class="text-sm-center"
          ><router-link to="Login"
            >마이페이지</router-link
          ></v-col
        >
        <v-col class="text-sm-center">로그아웃</v-col>
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
import { mapState } from "vuex";
export default {
  computed: {
    ...mapState("user", ["isAuth"]),
  },
};
</script>

<style scoped>
a {
  text-decoration: none;
}
</style>
