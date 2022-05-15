<template>
  <v-app>
    <AppBar />
    <NavigationBar />
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import AppBar from "@/components/bar/AppBar";
import NavigationBar from "@/components/bar/NavigationBar";
export default {
  name: "App",
  components: {
    AppBar,
    NavigationBar,
  },
};
</script>
