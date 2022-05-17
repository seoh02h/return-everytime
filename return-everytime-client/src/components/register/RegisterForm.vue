<template>
  <validation-observer ref="observer" v-slot="{ invalid }">
    <form @submit.prevent="submit">
      <validation-provider
        v-slot="{ errors }"
        name="이메일"
        rules="required|email"
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
        name="이름"
        rules="required|max:10"
      >
        <v-text-field
          v-model="name"
          :counter="10"
          :error-messages="errors"
          label="이름"
          required
        ></v-text-field>
      </validation-provider>

      <validation-provider
        v-slot="{ errors }"
        name="비밀번호"
        rules="required|max:20|min:8"
      >
        <v-text-field
          label="비밀번호"
          v-model="password"
          :append-icon="
            showPassword ? 'mdi-eye' : 'mdi-eye-off'
          "
          :type="showPassword ? 'text' : 'password'"
          :counter="20"
          :error-messages="errors"
          @click:append="showPassword = !showPassword"
        ></v-text-field>
      </validation-provider>

      <validation-provider
        v-slot="{ errors }"
        name="비밀번호 확인"
        rules="required|max:20|min:8|confirmed:비밀번호"
      >
        <v-text-field
          label="비밀번호 확인"
          v-model="passwordConfirm"
          :append-icon="
            showPasswordConfirm ? 'mdi-eye' : 'mdi-eye-off'
          "
          :type="showPasswordConfirm ? 'text' : 'password'"
          :counter="20"
          :error-messages="errors"
          @click:append="
            showPasswordConfirm = !showPasswordConfirm
          "
        ></v-text-field>
      </validation-provider>

      <validation-provider
        v-slot="{ errors }"
        name="휴대폰 번호"
        :rules="{
          required: true,
          digits: 11,
          regex: '^(010|031)\\d{8}$',
        }"
      >
        <v-text-field
          v-model="phoneNumber"
          :counter="11"
          :error-messages="errors"
          label="휴대폰 번호"
          required
        ></v-text-field>
      </validation-provider>

      <v-container>
        <v-row>
          <v-btn
            block
            class="mt-7 mb-3 primary"
            type="submit"
            :disabled="invalid"
          >
            회원가입
          </v-btn>
        </v-row>
        <v-row>
          <v-btn block :to="{ name: 'Login' }">
            로그인
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
export default {
  components: {
    ValidationProvider,
    ValidationObserver,
  },
  data: () => ({
    name: "",
    phoneNumber: "",
    email: "",
    checkbox: null,
    password: "",
    showPassword: false,
    passwordConfirm: "",
    showPasswordConfirm: false,
  }),

  methods: {
    submit() {
      this.$refs.observer.validate();
    },
  },
};
</script>
<style scoped></style>
