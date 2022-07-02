<template>
  <div>
    <h1 class="mt-3 ml-5">자유게시판</h1>
    <v-btn elevation="2" href="/posts-add" class="ma-4"
      >글 작성</v-btn
    >
    <PostList />
  </div>
</template>

<script>
import PostList from "@/components/post/PostList";
export default {
  components: {
    PostList,
  },
};
</script>

<style></style>
