<template>
  <v-app-bar app color="primary" dark clipped-left>
    <div class="d-flex align-center" @click="toHome">
      <div class="logo-container d-flex">
        <v-img
          alt="Logo"
          class="shrink mr-2 cursor-pointer"
          contai
          src="@/assets/images/logo.png"
          transition="scale-transition"
          width="30"
        />
        <div
          class="text-h5 font-weight-medium cursor-pointer"
        >
          RETURN
        </div>
      </div>
    </div>

    <v-spacer></v-spacer>

    <v-btn
      href="https://github.com/seoh02h/return-everytime"
      target="_blank"
      style="text-transform: none"
      text
    >
      <span class="mr-2 text-h6">Github</span>
      <v-icon>mdi-github</v-icon>
    </v-btn>
  </v-app-bar>
</template>

<script>
export default {
  methods: {
    toHome() {
      if (this.$route.path !== "/") {
        this.$router.push({ name: "Home" });
      }
    },
  },
};
</script>

<style scoped>
.logo-container {
  cursor: pointer;
}
</style>
