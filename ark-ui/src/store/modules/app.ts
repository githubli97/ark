import { Module } from 'vuex';
import { AppState, ModuleInfo, RootStateTypes } from '/@/store/interface';

const appModule: Module<AppState, RootStateTypes> = {
  namespaced: true,
  state: {
    currentModule: {
      name: '',
      id: '',
    },
  },
  mutations: {
    setCurrentModule(state: any, module: ModuleInfo) {
      state.currentModule = module;
    },
  },
  actions: {},
};

export default appModule;
