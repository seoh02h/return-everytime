<template>
  <div class="notice-container">
    <Notice
      :notice="notice"
      v-for="(notice, idx) in getNoticeList"
      :key="getNoticeList[idx].id"
    />
  </div>
</template>

<script>
import Notice from "@/components/notice/NoticeItem.vue";
import { mapGetters, mapActions } from "vuex";

export default {
  computed: {
    ...mapGetters("notice", ["getNoticeList"]),
  },
  components: {
    Notice,
  },
  methods: {
    ...mapActions("notice", ["FETCH_NOTICE_LIST"]),
  },
  created() {
    this.FETCH_NOTICE_LIST();
    console.log(this.getNoticeList);
  },
};
</script>

<style scoped>
.notice-container {
  display: flex;
  flex-wrap: wrap;
}
</style>
