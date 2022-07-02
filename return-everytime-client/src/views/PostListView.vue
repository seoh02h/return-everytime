<template>
  <v-container>
    <v-row>
      <v-col class="ma-3">
        <h2 class="mb-3 text-center">자유게시판</h2>
        <v-divider></v-divider>
      </v-col>
    </v-row>
    <v-row class="d-flex justify-center" no-gutters>
      <v-col class="justify-space-between"></v-col>
      <v-col class="justify-space-between" cols="6">
        <v-row justify="center" align="center">
          <v-col cols="10">
            <v-text-field
              placeholder="검색어를 입력하세요"
            ></v-text-field>
          </v-col>
          <v-col class="pa-0">
            <v-btn text rounded class="pa-0">
              <v-icon>mdi-magnify</v-icon>
            </v-btn>
          </v-col>
        </v-row>
      </v-col>
      <v-col class="justify-space-between text-right mt-2">
        <v-btn
          class="mr-10"
          fab
          dark
          color="primary"
          href="/posts-add"
        >
          <v-icon dark> mdi-pencil </v-icon>
        </v-btn>
      </v-col>
    </v-row>
    <v-row class="mx-9">
      <PostList />
    </v-row>
  </v-container>
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
