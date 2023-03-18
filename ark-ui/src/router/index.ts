import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router';
import NProgress from 'nprogress';
import 'nprogress/nprogress.css';
import { store } from '/@/store/index.ts';
import { NextLoading } from '/@/utils/loading';
import { staticRoutes } from '/@/router/staticRoute';
import { dynamicArkRoutes } from '/@/router/arkRoutes';
import { deleteToken, getToken } from '/@/config/cookies';
import { isDevEnv, isTestEnv } from '/@/config/env-filter'

const router = createRouter({
  history: createWebHashHistory(),
  routes: staticRoutes,
});

const pathMatch = {
  path: '/:path(.*)*',
  redirect: '/404',
};

/**
 * 路由多级嵌套数组处理成一维数组
 * @param arr 传入路由菜单数据数组
 * @returns 返回处理后的一维路由菜单数组
 */
export function formatFlatteningRoutes(arr: any) {
  if (arr.length <= 0) return false;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i].children) {
      arr = arr.slice(0, i + 1).concat(arr[i].children, arr.slice(i + 1));
    }
  }
  return arr;
}

/**
 * 一维数组处理成多级嵌套数组（只保留二级：也就是二级以上全部处理成只有二级，keep-alive 支持二级缓存）
 * @description isKeepAlive 处理 `name` 值，进行缓存。顶级关闭，全部不缓存
 * @link 参考：https://v3.cn.vuejs.org/api/built-in-components.html#keep-alive
 * @param arr 处理后的一维路由菜单数组
 * @returns 返回将一维数组重新处理成 `定义动态路由（dynamicRoutes）` 的格式
 */
export function formatTwoStageRoutes(arr: any) {
  if (arr.length <= 0) return false;
  const newArr: any = [];
  const cacheList: Array<string> = [];
  arr.forEach((v: any) => {
    if (v.path === '/') {
      newArr.push({
        component: v.component,
        name: v.name,
        path: v.path,
        redirect: v.redirect,
        meta: v.meta,
        children: [],
      });
    } else {
      // 判断是否是动态路由（xx/:id/:name），用于 tagsView 等中使用
      // 修复：https://gitee.com/lyt-top/vue-next-admin/issues/I3YX6G
      if (v.path.indexOf('/:') > -1) {
        v.meta['isDynamic'] = true;
        v.meta['isDynamicPath'] = v.path;
      }
      newArr[0].children.push({ ...v });
      // 存 name 值，keep-alive 中 include 使用，实现路由的缓存
      // 路径：/@/layout/routerView/parent.vue
      if (newArr[0].meta.isKeepAlive && v.meta.isKeepAlive) {
        cacheList.push(v.name);
        store.dispatch('router/setCacheKeepAlive', cacheList);
      }
    }
  });
  return newArr;
}

/**
 * 缓存多级嵌套数组处理后的一维数组
 * @description 用于 tagsView、菜单搜索中：未过滤隐藏的(isHide)
 */
export function setCacheTagsViewRoutes() {
  // 获取有权限的路由，否则 tagsView、菜单搜索中无权限的路由也将显示
  const authsRoutes = setFilterHasAuthMenu(dynamicArkRoutes(), store.state.user.authMenu);
  // 添加到 vuex setTagsViewRoutes 中
  store.dispatch('router/setTagsViewRoutes', formatTwoStageRoutes(formatFlatteningRoutes(authsRoutes))[0].children);
}

/**
 * 判断路由 `meta.auth` 中是否包含当前登录用户权限字段
 * @param auths 用户权限标识，在 userInfos（用户信息）的 authPageList（登录页登录时缓存到浏览器）数组
 * @param route 当前循环时的路由项
 * @returns 返回对比后有权限的路由项
 */
export function hasAuth(auths: any, route: any) {
  if (route.meta.code && auths) {
    // eslint-disable-next-line no-prototype-builtins
    const result = auths.hasOwnProperty(route.meta.code);
    return result;
  }
  return true;
}

/**
 * 获取当前用户权限标识去比对路由表，设置递归过滤有权限的路由
 * @param routes 当前路由 children
 * @param auth 用户权限标识，在 userInfos（用户信息）的 authPageList（登录页登录时缓存到浏览器）数组
 * @returns 返回有权限的路由数组 `meta.auth` 中控制
 */
export function setFilterHasAuthMenu(routes: any, auth: any) {
  const menu: any = [];
  routes.forEach((route: any) => {
    const item = { ...route };
    if (hasAuth(auth, item)) {
      if (item.children) item.children = setFilterHasAuthMenu(item.children, auth);
      menu.push(item);
    }
  });
  return menu;
}

/**
 * 设置递归过滤有权限的路由到 vuex routesList 中（已处理成多级嵌套路由）及缓存多级嵌套数组处理后的一维数组
 * @description 用于左侧菜单、横向菜单的显示
 * @description 用于 tagsView、菜单搜索中：未过滤隐藏的(isHide)
 */
export async function setFilterMenuAndCacheTagsViewRoutes() {
  await store.dispatch(
    'router/setRoutesList',
    setFilterHasAuthMenu(dynamicArkRoutes()[0].children, store.state.user.authMenu)
  );

  setCacheTagsViewRoutes();
}

/**
 * 获取当前用户权限标识去比对路由表（未处理成多级嵌套路由）
 * @description 这里主要用于动态路由的添加，router.addRoute
 * @link 参考：https://next.router.vuejs.org/zh/api/#addroute
 * @param chil dynamicRoutes（/@/router/route）第一个顶级 children 的下路由集合
 * @returns 返回有当前用户权限标识的路由数组
 */
export function setFilterRoute(chil: any) {
  return chil;
}

/**
 * 获取有当前用户权限标识的路由数组，进行对原路由的替换
 * @description 替换 dynamicRoutes（/@/router/route）第一个顶级 children 的路由
 * @returns 返回替换后的路由数组
 */
export function setFilterRouteEnd() {
  const filterRouteEnd: any = formatTwoStageRoutes(formatFlatteningRoutes(dynamicArkRoutes()));
  filterRouteEnd[0].children = [...setFilterRoute(filterRouteEnd[0].children), { ...pathMatch }];
  return filterRouteEnd;
}

/**
 * 添加动态路由
 * @method router.addRoute
 * @description 此处循环为 dynamicRoutes（/@/router/route）第一个顶级 children 的路由一维数组，非多级嵌套
 * @link 参考：https://next.router.vuejs.org/zh/api/#addroute
 */
export function setAddRoute() {
  setFilterRouteEnd().forEach((route: RouteRecordRaw) => {
    const routeName: any = route.name;
    if (!router.hasRoute(routeName)) router.addRoute(route);
  });
}

/**
 * 删除/重置路由
 * @method router.removeRoute
 * @description 此处循环为 dynamicRoutes（/@/router/route）第一个顶级 children 的路由一维数组，非多级嵌套
 * @link 参考：https://next.router.vuejs.org/zh/api/#push
 */
export function resetRoute() {
  setFilterRouteEnd().forEach((route: RouteRecordRaw) => {
    const routeName: any = route.name;
    router.hasRoute(routeName) && router.removeRoute(routeName);
  });
}

export async function initFrontEndControlRoutes() {
  // 界面 loading 动画开始执行
  if (window.nextLoading === undefined) NextLoading.start();
  // 无 token 停止执行下一步
  if (!getToken()) return false;
  // 添加动态路由
  await setAddRoute();
  // 设置递归过滤有权限的路由到 vuex routesList 中（已处理成多级嵌套路由）及缓存多级嵌套数组处理后的一维数组
  await setFilterMenuAndCacheTagsViewRoutes();
}

// 路由加载前
router.beforeEach(async (to, from, next) => {
  NProgress.configure({ showSpinner: false });
  if (to.meta.title) NProgress.start();
  // 非开发环境不展示此菜单
  if(!isDevEnv && to.path === '/workFlow/processDefinitionUserList') {
    next('/404');
  }
  const token = getToken();
  if (to.path === '/login' && !token) {
    next();
    NProgress.done();
  } else {
    if (!token) {
      // 目前分两种情况
      // 1、扫码跳转回来带了临时授权码，解析授权码拿token
      const code = to.query.code;
      const state = to.query.state;
      if (state && code) {
        await store.dispatch('user/userScanLogin', { code: code });
        next(to?.path);
      } else {
        // 2、未带临时授权码时跳登录页面
        next('/login');
        deleteToken();
        resetRoute();
      }
      NProgress.done();
    } else if (token && to.path === '/login') {
      next('/');
      NProgress.done();
    } else if (token && to.path === '/401') {
      next();
    } else {
      if (store.state.router.routesList.length === 0) {
        try {
          await store.dispatch('user/getUserInfo');
          if (store.state.router.routesList.length && hasAuth(store.state.user.authMenu, to)) {
            next({ ...to, replace: true });
          } else {
            next('/401');
          }
        } catch (e) {
          deleteToken();
          next('/login');
        }
      } else {
        if (hasAuth(store.state.user.authMenu, to)) {
          next();
        } else {
          next('/401');
        }
      }
    }
  }
});

// 路由加载后
router.afterEach(() => {
  NProgress.done();
  NextLoading.done();
});

// 导出路由
export default router;
