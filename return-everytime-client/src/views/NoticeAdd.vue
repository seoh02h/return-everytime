<template>
  <v-container>
    <v-row
      ><v-col><h1>공지사항 등록</h1></v-col></v-row
    >
    <v-row>
      <v-col>
        <h3 class="ml-1">제목</h3>
        <v-text-field
          label="제목을 입력하세요"
          solo
        ></v-text-field>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <h3 class="ml-1">내용</h3>
        <v-textarea
          solo
          name="input-7-4"
          label="내용을 입력하세요"
        ></v-textarea>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <h3 class="ml-1">첨부파일</h3>

        <v-file-input
          v-model="files"
          color="primary"
          counter
          label="파일을 선택하세요"
          multiple
          placeholder="Select your files"
          prepend-icon="mdi-paperclip"
          outlined
          :show-size="1000"
        >
          <template v-slot:selection="{ index, text }">
            <v-chip color="primary" dark label small>
              {{ text }}
            </v-chip>
          </template>
        </v-file-input>
      </v-col>
    </v-row>
    <v-row class="image-container">
      <v-col v-for="(file, idx) in files" :key="idx">
        <v-img :src="url(file)" max-width="200" />
      </v-col>
    </v-row>
    <v-row>
      <v-btn>취소</v-btn>
      <v-btn>등록</v-btn>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      files: [],
    };
  },
  methods: {
    url(file) {
      console.log(file);
      if (!file) return;
      return URL.createObjectURL(file);
    },
  },
};
</script>

<style scoped>
.image-container {
  display: flex;
  flex-wrap: wrap;
}
</style>
