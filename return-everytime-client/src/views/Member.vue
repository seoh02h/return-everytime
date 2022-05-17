<template>
  <div>
    <div
      v-for="(user, idx) in userList"
      :key="userList[idx].id"
    >
      {{ user }}
    </div>
  </div>
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
