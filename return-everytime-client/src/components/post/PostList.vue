<template>
  <div class="post-container">
    <PostListItem
      v-for="(post, idx) in getPostList"
      :key="getPostList[idx].id"
      :post="post"
    />
  </div>
</template>

<script>
import PostListItem from "@/components/post/PostListItem.vue";
import { mapGetters, mapActions } from "vuex";

export default {
  components: {
    PostListItem,
  },
  computed: {
    ...mapGetters("post", ["getPostList"]),
  },
  methods: {
    ...mapActions("post", ["FETCH_POST_LIST"]),
  },
  created() {
    this.FETCH_POST_LIST();
  },
};
</script>

<style></style>
