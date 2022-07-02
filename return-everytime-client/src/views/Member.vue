<template>
  <v-container>
    <v-row>
      <v-col class="ma-3">
        <h2 class="mb-3 text-center">멤버</h2>
        <v-divider></v-divider>
      </v-col>
    </v-row>
    <v-row
      class="mx-16"
      v-for="(user, idx) in userList"
      :key="userList[idx].id"
    >
      <v-col class="d-flex align-center">
        <img :src="user.imageUrl" width="40px" />
        <div class="ml-4">{{ user.name }}</div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapState, mapActions } from "vuex";
export default {
  computed: {
    ...mapState("user", ["userList"]),
  },
  methods: {
    ...mapActions("user", ["getUserList"]),
  },
  mounted() {
    this.getUserList();
  },
};
</script>

<style></style>
