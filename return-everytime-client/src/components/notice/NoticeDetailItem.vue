<template>
  <div>
    <h1>{{ notice.title }}</h1>
    <h1>{{ notice.editable }}</h1>
  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
  data() {
    return {
      notice: {},
    };
  },
  methods: {
    ...mapActions("notice", ["FETCH_NOTICE"]),
  },
  created() {
    this.FETCH_NOTICE({ id: this.$route.params.noticeId })
      .then((notice) => {
        this.notice = notice;
      })
      .catch(() => {
        this.$router.push({ name: "Notice" });
      });
  },
};
</script>

<style></style>
