<template>
  <div>
    <el-button @click="showProcess"> 查看流程图</el-button>
    <el-button @click="editProcess"> 编辑流程图</el-button>
    <el-button @click="editPermission"> 编辑权限</el-button>
    <md-iframe-page ref="processDesigner" @on-handle-message="onHandleMessage"></md-iframe-page>
    <md-permission-dialog
      ref="permissionTreeRef"
      :data="treeDataList"
      @handleConfirm="handleConfirm"
    ></md-permission-dialog>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
import { BASE_CONFIG } from '../../../env.process';
import MdIframePage from '/@/components/md-page/md-iframe-page.vue';
import { templatePublishList } from '/@/api/formCenter';
import { permissionFileTree } from '/@/api/workFlow/workFlow';

const processDesigner: any = ref(null);

const permissionTreeRef: any = ref(null);

function showProcess() {
  processDesigner.value.showDialog(BASE_CONFIG.WORKFLOW_URL);
}

function editProcess() {
  processDesigner.value.showDialog(`${BASE_CONFIG.WORKFLOW_URL}?id=1000`);
}
function editPermission() {
  getPermissionFileTree();
  permissionTreeRef.value.show();
}

const treeDataList: any = ref([]);

const getPermissionFileTree = async () => {
  try {
    const res = await permissionFileTree();
    if (res) treeDataList.value = res;
  } catch (e) {
    console.log(e);
  }
};
function handleConfirm(value) {
  alert(value);
}

async function onHandleMessage(data) {
  switch (data.cmd) {
    case 'onMounted':
      {
        const data = await templatePublishList({});
        console.log('onHandleMessage ==== ', data.list);
        processDesigner.value.sendMessage({ cmd: 'setFormList', params: data.list });
      }
      break;
  }
}
</script>

<style scoped lang="scss"></style>
