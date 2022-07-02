<template>
  <v-container>
    <v-row>
      <v-col class="ma-3">
        <h2 class="mb-3 text-center">게시글 등록</h2>
        <v-divider></v-divider>
      </v-col>
    </v-row>
    <v-row class="mx-16">
      <v-col>
        <v-row>
          <v-col>
            <div class="text-h6">제목</div>
            <v-text-field
              filled
              v-model="title"
              placeholder="제목을 입력하세요"
            ></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <div class="text-h6">내용</div>
            <v-textarea
              v-model="content"
              filled
              name="input-7-4"
              placeholder="내용을 입력하세요"
              height="250"
            ></v-textarea>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <div class="text-h6 mb-1">첨부파일</div>
            <v-file-input
              v-model="images"
              color="primary"
              multiple
              placeholder="파일을 선택하세요"
              outlined
              accept="image/png, image/jpeg, image/bmp"
            >
            </v-file-input>
          </v-col>
        </v-row>
        <v-row class="mx-16">
          <v-col>
            <v-carousel
              hide-delimiters
              v-if="images.length > 0"
            >
              <v-carousel-item
                v-for="(image, idx) in images"
                :key="idx"
                :src="url(image)"
              ></v-carousel-item>
            </v-carousel>
          </v-col>
        </v-row>
        <v-row class="mt-9 mb-6">
          <v-spacer></v-spacer>
          <v-btn
            @click="save"
            width="200"
            height="50"
            color="primary"
            :disabled="
              title.length === 0 || content.length === 0
            "
          >
            등록
          </v-btn>
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
      images: [],
      content: "",
      title: "",
    };
  },
  computed: {
    ...mapGetters("user", ["getCurrUser"]),
  },
  methods: {
    ...mapActions("post", ["SAVE_POST", "SAVE_POST_IMAGE"]),
    url(image) {
      if (!image) return;
      return URL.createObjectURL(image);
    },
    save() {
      this.SAVE_POST({
        content: this.content,
        title: this.title,
        userId: this.getCurrUser.id,
      }).then((post) => {
        if (this.images.length > 0) {
          var formdata = new FormData();
          for (let i = 0; i < this.images.length; i++) {
            formdata.append("imageList", this.images[i]);
          }
          this.SAVE_POST_IMAGE({
            postId: post.id,
            formdata: formdata,
          }).then((post) => {
            this.$router.push(`/posts/${post.id}`);
          });
        } else {
          this.$router.push(`/posts/${post.id}`);
        }
      });
    },
  },
};
</script>

<style scoped>
.image-container {
  display: flex;
  flex-wrap: wrap;
}
.image-item {
  display: flex;
  justify-content: center;
}
</style>
