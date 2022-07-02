<template>
  <div class="post-list-item" @click="goToDetail">
    <h4>{{ post.title }}</h4>
    <div>
      {{ post.content }}
    </div>

    <div class="user-info">
      <img :src="post.user.imageUrl" width="20px" />
      <div class="ml-1">{{ post.user.name }}</div>
      <div class="ml-3">{{ post.createdDate }}</div>
    </div>
    <hr class="mt-2" />
  </div>
</template>

<script>
export default {
  props: ["post"],
  methods: {
    goToDetail() {
      this.$router.push(`/posts/${this.post.id}`);
    },
  },
};
</script>

<style scoped>
.post-list-item {
  padding: 20px;
}
hr {
  border-top: 1px solid rgb(199, 199, 199);
}
div {
  cursor: pointer;
}
.user-info {
  display: flex;
  align-items: center;
}
</style>
