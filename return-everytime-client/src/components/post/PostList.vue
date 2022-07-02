<template>
  <v-col>
    <v-row class="table-header text-center ma-1 py-1">
      <v-col cols="1">번호</v-col>
      <v-divider vertical></v-divider>
      <v-col cols="7">제목</v-col>
      <v-divider vertical></v-divider>
      <v-col>작성자</v-col>
      <v-divider vertical></v-divider>
      <v-col>작성일시</v-col>
    </v-row>
    <PostListItem
      v-for="(post, idx) in getPostList"
      :key="getPostList[idx].id"
      :post="post"
    />
  </v-col>
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

<style>
.table-header {
  border-top: 1px solid rgb(69, 69, 69);

  border-bottom: 1px solid rgb(69, 69, 69);
}
</style>
