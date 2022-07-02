<template>
  <v-container>
    <v-row>
      <v-col class="ma-3">
        <h2 class="mb-3 text-center">채팅방</h2>
        <v-divider></v-divider>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <div>김민지 | 아아아아</div>
        <div v-for="(message, idx) in messages" :key="idx">
          김서현 | {{ message.content }}
        </div>
      </v-col>
    </v-row>
    <v-row class="d-flex justify-center">
      <v-col cols="8" class="d-flex align-center">
        <v-text-field
          v-model="content"
          :prepend-icon="icon"
          filled
          clearable
          placeholder="메시지를 입력하세요"
          type="text"
        ></v-text-field>
        <v-btn
          text
          color="primary"
          class="mx-2 pl-1 mb-8 text-center"
          fab
          @click="send"
          ><v-icon large>mdi-send</v-icon></v-btn
        >
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      messages: [],
      content: "",
    };
  },
  methods: {
    send() {
      this.messages.push({ content: this.content });
      this.content = "";
    },
  },
};
</script>

<style></style>
