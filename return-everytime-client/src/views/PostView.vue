<template>
  <v-container>
    <v-row>
      <v-col class="ma-3">
        <h2 class="mb-3 text-center">자유게시판</h2>
        <v-divider></v-divider>
      </v-col>
    </v-row>
    <v-row no-gutters class="mx-16">
      <v-col cols="10">
        <div class="text-h6">{{ post.title }}</div>
      </v-col>
      <v-col
        v-if="post.editable"
        class="d-flex justify-center"
      >
        <v-btn
          v-if="post.user.id === getCurrUser.id"
          class="mr-3"
        >
          수정
        </v-btn>
        <v-btn>삭제</v-btn>
      </v-col>
    </v-row>
    <v-row>
      <v-col class="ml-16 mb-10 d-flex align-center">
        <img :src="post.user.imageUrl" height="23px" />
        <div class="ml-2">{{ post.user.name }}</div>
        <div class="ml-3">
          {{ post.createdDate }}
        </div>
      </v-col>
    </v-row>
    <v-row class="mx-16">
      <v-col class="content-box">
        <p class="ml-4">{{ post.content }}</p>
      </v-col>
    </v-row>
    <v-row
      class="mx-16 mt-4"
      v-if="post.imageList.length > 0"
    >
      <v-col>
        <v-carousel hide-delimiters>
          <v-carousel-item
            v-for="(image, idx) in post.imageList"
            :key="idx"
            :src="image.url"
          ></v-carousel-item>
        </v-carousel>
      </v-col>
    </v-row>
    <v-divider class="ma-10"></v-divider>
    <v-row class="mx-16 d-flex justify-center">
      <v-col cols="10 d-flex justify-center align-center">
        <v-text-field
          v-model="content"
          class="mt-4 mr-5"
          label="댓글을 입력하세요"
          solo
        ></v-text-field>
        <v-btn
          @click="saveComment"
          text
          color="primary"
          large
        >
          <v-icon>mdi-comment-plus-outline</v-icon>
        </v-btn>
      </v-col>
    </v-row>
    <v-row
      class="mx-16"
      v-for="(comment, idx) in post.commentList"
      :key="idx"
    >
      <v-col>
        <v-row no-gutters>
          <v-col>
            <div>
              {{ comment.content }}
            </div>
          </v-col>
        </v-row>

        <v-row no-gutters class="mb-2">
          <v-col class="d-flex align-center text-body-2">
            <img
              :src="comment.user.imageUrl"
              height="25px"
            />
            <div class="ml-2">
              {{ comment.user.name }}
            </div>
            <div class="ml-3 mr-10">
              {{ comment.createdDate }}
            </div>
            <div class="comment-detail-box">
              <v-btn text rounded
                ><v-icon
                  >mdi-trash-can-outline</v-icon
                ></v-btn
              >
            </div>
          </v-col>
        </v-row>
        <v-divider></v-divider>
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
    ...mapActions("comment", ["SAVE_COMMENT"]),

    saveComment() {
      this.SAVE_COMMENT({
        content: this.content,
        postId: this.post.id,
        userId: this.getCurrUser.id,
      }).then(() => this.getPost());
    },
    getPost() {
      this.FETCH_POST({ id: this.$route.params.postId })
        .then((post) => {
          this.post = post;
        })
        .catch(() => {
          this.$router.push({ name: "Post" });
        });
    },
  },
  created() {
    this.getPost();
  },
};
</script>

<style scoped>
.content-box {
  border: 1px solid #eeeeee;
  border-radius: 10px;
}
</style>
