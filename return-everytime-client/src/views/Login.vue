<template>
  <div class="d-flex justify-center">
    <div class="login-form mt-16">
      <div
        class="text-h4 font-weight-bold text-md-center primary--text mb-5"
      >
        로그인
      </div>
      <LoginForm />
    </div>
  </div>
</template>

<script>
import LoginForm from "@/components/login/LoginForm";
export default {
  components: {
    LoginForm,
  },
};
</script>

<style scoped>
.login-form {
  width: 40%;
}
</style>
