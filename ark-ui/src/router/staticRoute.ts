import { RouteRecordRaw } from 'vue-router';

/**
 * 定义静态路由
 */
export const staticRoutes: Array<RouteRecordRaw> = [
  {
    path: '/login',
    name: 'login',
    component: () => import('/@/views/login/index.vue'),
    meta: {
      title: '登录',
    },
  },
  {
    path: '/404',
    name: 'notFound',
    component: () => import('/@/views/error/404.vue'),
    meta: {
      title: 'message.staticRoutes.notFound',
    },
  },
  {
    path: '/401',
    name: 'noPower',
    component: () => import('/@/views/error/401.vue'),
    meta: {
      title: 'message.staticRoutes.noPower',
    },
  },
];
