<template>
  <div v-if="isTagsViewCurrenFull" class="layout-navbars-close-full">
    <div
      class="layout-navbars-close-full-box"
      :title="$t('message.tagsView.closeFullscreen')"
      @click="onCloseFullscreen"
    >
      <i class="el-icon-close" />
    </div>
  </div>
</template>

<script lang="ts">
import { toRefs, reactive, computed } from 'vue';
import { useStore } from '/@/store/index';
export default {
  name: 'LayoutCloseFull',
  setup() {
    const store = useStore();
    const state: any = reactive({});
    // 获取卡片全屏信息
    const isTagsViewCurrenFull = computed(() => {
      return store.state.router.isTagsViewCurrenFull;
    });
    // 关闭当前全屏
    const onCloseFullscreen = () => {
      store.dispatch('router/setCurrenFullscreen', false);
    };
    return {
      isTagsViewCurrenFull,
      onCloseFullscreen,
      ...toRefs(state),
    };
  },
};
</script>

<style scoped lang="scss">
.layout-navbars-close-full {
  position: fixed;
  z-index: 9999999999;
  right: -30px;
  top: -30px;
  .layout-navbars-close-full-box {
    width: 60px;
    height: 60px;
    border-radius: 100%;
    position: relative;
    cursor: pointer;
    background: rgba(0, 0, 0, 0.1);
    transition: all 0.3s ease;
    i {
      position: absolute;
      left: 11px;
      top: 35px;
      color: #333333;
      transition: all 0.3s ease;
    }
    &:hover {
      background: rgba(0, 0, 0, 0.2);
      transition: all 0.3s ease;
      i {
        color: var(--color-primary);
        transition: all 0.3s ease;
      }
    }
  }
}
</style>
