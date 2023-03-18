<template>
  <el-form class="login-content-form">
    <el-form-item>
      <el-input
        type="text"
        :placeholder="$t('message.username.usernamePlaceholder1')"
        prefix-icon="el-icon-user"
        v-model.trim="state.ruleForm.username"
        clearable
        autocomplete="off"
      >
      </el-input>
    </el-form-item>
    <el-form-item>
      <el-input
        :type="state.isShowPassword ? 'text' : 'password'"
        :placeholder="$t('message.username.usernamePlaceholder2')"
        prefix-icon="el-icon-lock"
        v-model.trim="state.ruleForm.password"
        autocomplete="off"
      >
        <template #suffix>
          <i
            class="iconfont el-input__icon login-content-password"
            :class="state.isShowPassword ? 'icon-yincangmima' : 'icon-xianshimima'"
            @click="state.isShowPassword = !state.isShowPassword"
          >
          </i>
        </template>
      </el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" class="login-content-submit" round @click="onSignIn" :loading="state.loading.signIn">
        <span>{{ $t('message.username.usernameBtnText') }}</span>
      </el-button>
    </el-form-item>
  </el-form>
</template>

<script lang="ts" setup>
import { reactive, computed, getCurrentInstance } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { ElMessage } from 'element-plus';
import { useI18n } from 'vue-i18n';
import { useStore } from '/@/store/index';
import { formatAxis } from '/@/utils/formatTime';
import JSEncrypt from 'jsencrypt';


const { t } = useI18n();
const { proxy } = getCurrentInstance() as any;
const store = useStore();
const route = useRoute();
const router = useRouter();
const state = reactive({
  isShowPassword: false,
  ruleForm: {
    username: '',
    password: '',
  },
  loading: {
    signIn: false,
  },
});
// 时间获取
const currentTime = computed(() => {
  return formatAxis(new Date());
});

// 登录
const onSignIn = async () => {
  try {
    state.loading.signIn = true;
    await store.dispatch('user/userLogin', state.ruleForm);
  }catch (e) {
    state.loading.signIn = false;
  }
};
</script>

<style scoped lang="scss">
.login-content-form {
  margin-top: 20px;

  .login-content-password {
    display: inline-block;
    width: 25px;
    cursor: pointer;

    &:hover {
      color: #909399;
    }
  }

  .login-content-code {
    display: flex;
    align-items: center;
    justify-content: space-around;

    .login-content-code-img {
      width: 100%;
      height: 40px;
      line-height: 40px;
      background-color: #ffffff;
      border: 1px solid rgb(220, 223, 230);
      color: #333;
      font-size: 16px;
      font-weight: 700;
      letter-spacing: 5px;
      text-indent: 5px;
      text-align: center;
      cursor: pointer;
      transition: all ease 0.2s;
      border-radius: 4px;
      user-select: none;

      &:hover {
        border-color: #c0c4cc;
        transition: all ease 0.2s;
      }
    }
  }

  .login-content-submit {
    width: 100%;
    letter-spacing: 2px;
    font-weight: 300;
    margin-top: 15px;
  }
}
</style>
