import { Module } from 'vuex';
import { UserState, RootStateTypes } from '/@/store/interface/index';
import { getUserInfo, userLogin } from '/@/api/user/index';
import { UserInfo } from '/@/api/interface/user-interface';
import { deleteToken, saveToken } from '/@/config/cookies';
import { initFrontEndControlRoutes } from '/@/router/index';
import { ElMessage } from 'element-plus';
import { Session } from '/@/utils/storage';
import router, { resetRoute } from '/@/router';
import { formatAxis } from '/@/utils/formatTime';
import { i18n } from '/@/i18n';
import { unref } from 'vue';
import {isProd} from "../../../env.process";
import axios from "axios";
import {
  API_USER_LOGIN
} from '/@/api/const/user-api';
import qs from 'qs'

const userModule: Module<UserState, RootStateTypes> = {
  namespaced: true,
  state: {
    userInfo: {},
    authMenu: {},
  },
  mutations: {
    // 设置用户信息
    updateUserInfo(state: UserState, user: UserInfo) {
      state.userInfo = user.sysUserInfo;
      state.authMenu = user.authMenu;
    },
  },
  actions: {
    // 用户登录
    async userLogin({ commit }, params: any) {
      console.log("params --- ", params.username, params.password)
      console.log("API_USER_LOGIN --- ", API_USER_LOGIN)
      const token = await axios({
        method: "post",
        url: API_USER_LOGIN,
        headers: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        withCredentials: true,
        data: qs.stringify(params)
      })

      console.log("res == ", token);
      await afterLoginSuccess(token, false);
    },

    // 退出登录
    async userLogout({ commit }) {
      // await logout();
      Session.clear(); // 清除缓存/token等
      deleteToken();
      resetRoute(); // 删除/重置路由
      await router.push('/login');
    },

    // 设置用户信息
    async getUserInfo({ commit }, params: any) {
      const userInfo = await getUserInfo(params);
      // 更新用户信息
      commit('updateUserInfo', userInfo);
      // 重置前端路由
      await initFrontEndControlRoutes();
    },
  },
};

async function afterLoginSuccess(token: string, isScan: boolean) {
  saveToken(token);
  await store.dispatch('user/getUserInfo');
  // 登录成功，跳到转首页
  // 添加完动态路由，再进行 router 跳转，否则可能报错 No match found for location with path "/"
  // 如果是复制粘贴的路径，非首页/登录页，那么登录成功后重定向到对应的路径中
  const route = unref(router.currentRoute);
  if (route.query?.redirect) {
    router.push({
      path: route.query?.redirect
    });
  }
  // 登录成功提示
  setTimeout(() => {
    const signInText = i18n.global.t('message.signInText');
    ElMessage.success(`${formatAxis(new Date())}，${signInText}`);
    // 修复防止退出登录再进入界面时，需要刷新样式才生效的问题，初始化布局样式等(登录的时候触发，目前方案)
  }, 300);
}
export default userModule;
