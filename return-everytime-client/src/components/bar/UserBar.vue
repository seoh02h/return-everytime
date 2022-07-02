<template>
  <div>
    <v-container v-if="getIsAuth">
      <v-row>
        <v-col class="text-center user-box ma-3 mb-0">
          <img
            :src="getCurrUser.imageUrl"
            width="45px"
            class="mr-4"
          />
          <div class="text-left">
            <div>
              {{ getCurrUser.name }}
            </div>
            <div>
              {{ getCurrUser.email }}
            </div>
          </div>
        </v-col>
      </v-row>
      <v-row>
        <v-col class="text-center ml-2">
          <v-btn elevation="0" rounded text color="primary"
            >마이페이지</v-btn
          >
        </v-col>
        <v-col class="text-center mr-2">
          <v-btn elevation="0" rounded @click="logout" text>
            로그아웃
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
    <v-container v-else>
      <v-row>
        <v-col class="text-center ma-3 mb-0">
          로그인이 필요합니다.
        </v-col>
      </v-row>
      <v-row>
        <v-col class="text-center ml-2">
          <v-btn
            elevation="0"
            rounded
            href="/login"
            text
            color="primary"
          >
            로그인
          </v-btn>
        </v-col>
        <v-col class="text-center mr-2">
          <v-btn
            elevation="0"
            rounded
            href="/register"
            text
            color="primary"
          >
            회원가입
          </v-btn>
        </v-col>
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

.user-box {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
