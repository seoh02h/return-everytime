<template>
  <validation-observer ref="observer" v-slot="{ invalid }">
    <form @submit.prevent="submit">
      <validation-provider
        v-slot="{ errors }"
        name="이메일"
        rules="required"
      >
        <v-text-field
          v-model="email"
          :error-messages="errors"
          label="이메일"
          required
        ></v-text-field>
      </validation-provider>

      <validation-provider
        v-slot="{ errors }"
        name="비밀번호"
        rules="required"
      >
        <v-text-field
          label="비밀번호"
          v-model="password"
          :append-icon="
            showPassword ? 'mdi-eye' : 'mdi-eye-off'
          "
          :type="showPassword ? 'text' : 'password'"
          :error-messages="errors"
          @click:append="showPassword = !showPassword"
        ></v-text-field>
      </validation-provider>

      <validation-provider
        v-slot="{ errors }"
        name="관리자 로그인"
      >
        <v-checkbox
          v-model="isAdmin"
          :error-messages="errors"
          label="관리자 로그인"
          type="checkbox"
        ></v-checkbox>
      </validation-provider>

      <v-container>
        <v-row>
          <v-btn
            block
            class="mb-3 primary"
            type="submit"
            :disabled="invalid"
          >
            로그인
          </v-btn>
        </v-row>
        <v-row>
          <v-btn block :to="{ name: 'Register' }">
            회원가입
          </v-btn>
        </v-row>
      </v-container>
    </form>
  </validation-observer>
</template>
<script>
import {
  required,
  digits,
  email,
  min,
  max,
  regex,
  confirmed,
} from "vee-validate/dist/rules";
import {
  extend,
  ValidationObserver,
  ValidationProvider,
  setInteractionMode,
} from "vee-validate";

setInteractionMode("eager");

extend("digits", {
  ...digits,
  message: "{_field_} 항목은 {length} 자를 입력해주세요.",
});

extend("required", {
  ...required,
  message: "{_field_} 항목을 입력해주세요",
});

extend("max", {
  ...max,
  message:
    "{_field_} 항목은 {length}자를 초과할 수 없습니다.",
});

extend("min", {
  ...min,
  message: "{_field_} 항목은 {length}자 이상 입니다.",
});

extend("regex", {
  ...regex,
  message: "{_field_} 형식이 올바르지 않습니다.",
});

extend("email", {
  ...email,
  message: "이메일 형식이 올바르지 않습니다.",
});

extend("confirmed", {
  ...confirmed,
  message: "비밀번호와 비밀번호 확인이 일치하지 않습니다.",
});
import { mapActions } from "vuex";
export default {
  components: {
    ValidationProvider,
    ValidationObserver,
  },
  data: () => ({
    email: "",
    isAdmin: false,
    password: "",
    showPassword: false,
    passwordConfirm: "",
    showPasswordConfirm: false,
  }),

  methods: {
    ...mapActions("user", ["LOGIN"]),
    submit() {
      this.$refs.observer.validate();
      this.LOGIN({
        email: this.email,
        password: this.password,
        isAdmin: this.isAdmin,
      })
        .then(() => this.$router.push({ name: "Home" }))
        .catch(() => alert("잘못된 로그인 정보입니다."));
    },
  },
};
</script>
<style scoped></style>
