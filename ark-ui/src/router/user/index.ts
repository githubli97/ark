import { RouteRecordRaw } from 'vue-router';

export const userRoutes: Array<RouteRecordRaw> = [
  {
    path: '/user',
    name: 'user',
    component: () => import('/@/layout/index.vue'),
    redirect: '/user/index',
    meta: {
      title: 'message.router.userCenter',
      isLink: '',
      isHide: false,
      isKeepAlive: false,
      isAffix: false,
      isIframe: false,
      icon: 'iconfont icon-shouye'
    },
    children: [
      {
        path: '/userCenter/index',
        name: 'user-center-table',
        component: () => import('/@/views/usercenter/index.vue'),
        meta: {
          title: 'message.router.organizationalStructure',
          isLink: '',
          isHide: false,
          isKeepAlive: false,
          isAffix: false,
          isIframe: false,
          icon: 'iconfont icon-shouye'
        },
      }
    ],
  },
];
