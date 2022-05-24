<template>
  <div class="d-flex justify-center">
    <div class="register-form mt-10">
      <div
        class="text-h4 font-weight-bold text-md-center primary--text mb-5"
      >
        회원가입
      </div>
      <RegisterForm />
    </div>
  </div>
</template>

<script>
import RegisterForm from "@/components/register/RegisterForm";
export default {
  components: {
    RegisterForm,
  },
};
</script>

<style scoped>
.register-form {
  width: 350px;
}
</style>
