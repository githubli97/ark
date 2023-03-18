import { Module } from 'vuex';
import { RootStateTypes, RouterState } from '/@/store/interface/index';

const routerModule: Module<RouterState, RootStateTypes> = {
  namespaced: true,
  state: {
    keepAliveNames: [],
    routesList: [],
    tagsViewRoutes: [],
    isTagsViewCurrenFull: false,
  },
  mutations: {
    // 设置路由缓存（name字段）
    getCacheKeepAlive(state: any, data: Array<string>) {
      state.keepAliveNames = data;
    },
    // 设置路由，菜单中使用到
    getRoutesList(state: any, data: Array<any>) {
      state.routesList = data;
    },
    // 设置 TagsView 路由
    getTagsViewRoutes(state: any, data: Array<string>) {
      state.tagsViewRoutes = data;
    },
    // 设置卡片全屏
    getCurrenFullscreen(state: any, bool: boolean) {
      state.isTagsViewCurrenFull = bool;
    },
  },
  actions: {
    // 设置路由缓存（name字段）
    async setCacheKeepAlive({ commit }, data: Array<string>) {
      commit('getCacheKeepAlive', data);
    },
    // 设置路由，菜单中使用到
    async setRoutesList({ commit }, data: any) {
      commit('getRoutesList', data);
    },
    // 设置 TagsView 路由
    async setTagsViewRoutes({ commit }, data: Array<string>) {
      commit('getTagsViewRoutes', data);
    },
    // 设置卡片全屏
    setCurrenFullscreen({ commit }, bool: boolean) {
      commit('getCurrenFullscreen', bool);
    },
  },
};

export default routerModule;
