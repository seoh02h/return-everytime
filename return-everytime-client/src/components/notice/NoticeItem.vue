<template>
  <v-card
    class="mt-4 ml-4"
    max-width="300"
    :href="`notices/${notice.id}`"
  >
    <v-img
      class="white--text align-end"
      height="200px"
      src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
    >
    </v-img>
    <v-card-title>{{ notice.title }}</v-card-title>

    <v-card-subtitle class="pb-0">
      {{ notice.user.name }}
    </v-card-subtitle>

    <v-card-text class="text--primary">
      <div>{{ notice.content }}</div>
      <div>{{ notice.createdDate }}</div>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  props: ["notice"],
  data() {
    return {};
  },
};
</script>

<style scoped></style>
