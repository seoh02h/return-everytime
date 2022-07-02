<template>
  <v-container>
    <v-row>
      <v-col>
        <h3 class="ma-4 mb-0">{{ post.title }}</h3>
      </v-col>
    </v-row>
    <v-row v-if="post.editable">
      <v-btn v-if="post.user.id === getCurrUser.id">
        수정
      </v-btn>
      <v-btn>삭제</v-btn>
    </v-row>
    <v-row>
      <v-col class="ml-4">
        <div class="user-info">
          <img :src="post.user.imageUrl" width="25px" />
          <div class="ml-1">{{ post.user.name }}</div>
        </div>

        <div>{{ post.createdDate }}</div>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <p class="ml-4">{{ post.content }}</p>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-row>
          <v-col class="comment-form-container ml-10 mr-10">
            <v-text-field
              v-model="content"
              class="mt-4 mr-5"
              label="댓글을 입력하세요"
              solo
            ></v-text-field>
            <v-btn @click="saveComment">댓글작성</v-btn>
          </v-col>
        </v-row>
        <v-row
          class="ml-3"
          v-for="(comment, idx) in post.commentList"
          :key="idx"
        >
          {{ comment }}
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
export default {
  data() {
    return {
      post: {},
      content: "",
    };
  },
  computed: {
    ...mapGetters("user", ["getCurrUser"]),
  },
  methods: {
    ...mapActions("post", ["FETCH_POST"]),
    saveComment() {
      console.log(this.content);
    },
  },
  created() {
    this.FETCH_POST({ id: this.$route.params.postId })
      .then((post) => {
        this.post = post;
      })
      .catch(() => {
        this.$router.push({ name: "Post" });
      });
  },
};
</script>

<style scoped>
.comment-form-container {
  display: flex;
  justify-content: center;
  align-items: center;
}
.user-info {
  display: flex;
}
</style>
