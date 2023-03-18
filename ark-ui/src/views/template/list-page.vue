<template>
  <div>
    <md-table-page
      :dataColumn="dataColumn"
      :dataList="dataList"
      :params="params"
      :loading="loading"
      @current-change="queryDataList"
      @search="search"
      @clearParams="clearParams"
      @edit="updateDialogShow"
    >
      <template #search-bar>
        <el-input
          v-model="params.userName"
          size="small"
          :placeholder="$t('adminUser.plsInputName')"
          suffix-icon="el-icon-search"
        />
        <el-input
          v-model="params.email"
          size="small"
          :placeholder="$t('adminUser.plsInputEmail')"
          suffix-icon="el-icon-search"
        />
      </template>

      <template #table-bar>
        <demo-create @submit="queryDataList"></demo-create>
      </template>
    </md-table-page>

    <demo-update ref="updateDialogRef" @submit="queryDataList"></demo-update>
  </div>
</template>

<script lang="ts" setup>
// 引入相关组件
import {demoList} from '/@/api/demo';
import {onMounted, ref} from 'vue';

// 引入模块
import MdTablePage from '/@/components/md-page/md-table-page.vue';
import DemoCreate from '/@/views/template/demo-create.vue';
import DemoUpdate from '/@/views/template/demo-update.vue';

// 业务模块
const dataColumn = [
  {prop: 'userName', label: 'message.demo.plsInputEmail', width: 150},
  {prop: 'email', label: 'email', width: 150},
  {prop: 'id', label: 'id'},
];
// 定义业务数据模块
let params: any = ref({}); // 查询参数
let loading = ref(false);
let dataList = ref([]); // 设置双向绑定的数据
const updateDialogRef: any = ref(null);

onMounted(async () => {
  clearParams();
  await search();
});

// 定义业务方法模块
async function search() {
  params.value.pageIndex = 1;
  await queryDataList();
}

async function queryDataList() {
  loading.value = true;
  // 这里返回值需要定义接口，可以把api统一抽离，然后统一返回数据即可
  dataList.value = await demoList(params.value);
  loading.value = false;
}

function clearParams() {
  params.value = {
    pageIndex: 1,
    pageSize: 50,
    email: '',
    userName: '',
  };
}

function updateDialogShow(scope: { row: any }) {
  updateDialogRef.value.show(scope.row);
}
</script>

<style scoped></style>
