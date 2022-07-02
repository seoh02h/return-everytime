<template>
  <v-row
    style="cursor: pointer"
    class="ma-1 post-list-item"
    @click="goToPost"
  >
    <v-col class="text-center" cols="1">{{
      post.id
    }}</v-col>
    <v-col cols="7">
      <div class="text-subtitle-1 ml-3">
        {{ post.title }}
      </div>
    </v-col>
    <v-col class="d-flex justify-center text-center">
      <div class="d-flex">
        <img :src="post.user.imageUrl" height="23px" />
        <div class="ml-2">{{ post.user.name }}</div>
      </div>
    </v-col>
    <v-col class="text-center">
      <div class="text-body-2">
        {{ post.createdDate }}
      </div>
    </v-col>
  </v-row>
</template>

<script>
export default {
  props: ["post"],
  methods: {
    goToPost() {
      this.$router.push(`/posts/${this.post.id}`);
    },
  },
};
</script>

<style scoped>
.post-list-item {
  border-bottom: 1px solid rgba(206, 206, 206, 0.594);
}
</style>
