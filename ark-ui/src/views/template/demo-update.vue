<template>
  <div class="dialog-update-wrapper">
    <el-dialog :title="'更新用户'" v-model="dialogShow" width="40%" @close="dialogClose()">
      <el-form ref="ruleForm" :model="params" :rules="rules" label-width="100px" class="demo-ruleForm">
        <el-form-item :label="'名称'" prop="name">
          <el-input v-model="params.userName" />
        </el-form-item>
        <el-form-item :label="'邮箱'" prop="email">
          <el-input v-model="params.email" />
        </el-form-item>
        <el-form-item :label="'密码'" prop="password">
          <el-input v-model="params.password" type="password" />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogClose()">
          {{ $t('message.operation.cancel') }}
        </el-button>
        <el-button type="primary" @click="submit()">
          {{ $t('message.operation.submit') }}
        </el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import { onMounted, ref } from 'vue';
import { ElMessage } from 'element-plus';
import { useI18n } from 'vue-i18n';

const { t } = useI18n();
const emit = defineEmits(['submit']);
defineExpose({
  // 向外抛出接口
  show,
});

let dialogShow = ref(false);
let params = ref({});
const ruleForm: any = ref(null);

onMounted(() => {
  paramsInit();
});

const validateName = (rule: any, value: any, callback: any) => {
  callback(!value ? new Error(t('message.demo.plsInputEmail')) : undefined);
};
const validateEmail = (rule: any, value: any, callback: any) => {
  callback(!value ? new Error(t('message.demo.plsInputEmail')) : undefined);
};
const validatePassword = (rule: any, value: any, callback: any) => {
  callback(!value ? new Error(t('message.demo.plsInputEmail')) : undefined);
};
const rules = {
  name: [{ required: true, trigger: 'blur', validator: validateName }],
  email: [{ required: true, trigger: 'blur', validator: validateEmail }],
  password: [{ required: true, trigger: 'blur', validator: validatePassword }],
};

function show(data) {
  params.value = Object.assign({}, data);
  dialogShow.value = true;
}

function paramsInit() {
  params.value = {
    // 新增或者修改的数据结构
    userName: '',
    email: '',
    id: '',
  };
}

function submit() {
  ruleForm.value.validate(async (valid: any) => {
    if (valid) {
      // 这里调用修改的api接口
      let res: any = {};
      if (res.success) {
        emit('submit', res);
        dialogClose();
        ElMessage.success(t('message.operation.updateSuccess'));
      } else {
        ElMessage.warning(res.message);
      }
    } else {
      ElMessage.warning(t('message.operation.validFailed'));
    }
  });
}

function dialogClose() {
  paramsInit();
  ruleForm.value.resetFields();
  dialogShow.value = false;
}
</script>

<style></style>
