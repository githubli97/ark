<template>
  <div class="dialog-create-wrapper">
    <el-button type="primary" size="small" icon="el-icon-document-add" @click="show()" style="margin-bottom: 15px">
      {{ $t('message.operation.createButtonText') }}
    </el-button>
    <el-dialog :title="'创建用户'" v-model="dialogShow" width="40%" @close="dialogClose()">
      <el-form ref="ruleForm" :model="params" :rules="rules" label-width="100px" class="demo-ruleForm">
        <el-form-item :label="'名称'" prop="name">
          <el-input v-model="params.name"/>
        </el-form-item>
        <el-form-item :label="'邮箱'" prop="email">
          <el-input v-model="params.email"/>
        </el-form-item>
        <el-form-item :label="'密码'" prop="password">
          <el-input v-model="params.password" type="password"/>
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
import {onMounted, reactive, ref} from 'vue';
import {ElMessage} from 'element-plus';
import {useI18n} from 'vue-i18n';

const {t} = useI18n();
const emit = defineEmits(['submit']);

let dialogShow = ref(false);
let params = reactive({});
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
  name: [{required: true, trigger: 'blur', validator: validateName}],
  email: [{required: true, trigger: 'blur', validator: validateEmail}],
  password: [{required: true, trigger: 'blur', validator: validatePassword}],
};

function show() {
  dialogShow.value = true;
}

function paramsInit() {
  params = {
    // 新增或者修改的数据结构
    name: '',
    email: '',
    password: '',
  };
}

function submit() {
  ruleForm.value.validate(async (valid: any) => {
    if (valid) {
      // 这里调用添加的api接口
      let res: any = {};
      if (res.success) {
        emit('submit', res);
        dialogClose();
        ElMessage.success(t('message.operation.createSuccess'));
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
