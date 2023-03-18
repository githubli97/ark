import { RouteRecordRaw } from 'vue-router';

export const homeRoutes: Array<RouteRecordRaw> = [
  {
    path: '/home',
    name: 'home',
    component: () => import('/@/layout/index.vue'),
    redirect: '/home',
    meta: {
      title: 'message.router.home',
      isLink: '',
      isHide: false,
      isKeepAlive: false,
      isAffix: false,
      isIframe: false,
      icon: 'iconfont icon-shouye'
    },
    // children: [
    //   {
    //     path: '/userCenter/index',
    //     name: 'user-center-table',
    //     component: () => import('/@/views/usercenter/index.vue'),
    //     meta: {
    //       title: 'message.router.organizationalStructure',
    //       isLink: '',
    //       isHide: false,
    //       isKeepAlive: false,
    //       isAffix: false,
    //       isIframe: false,
    //       icon: 'iconfont icon-shouye'
    //     },
    //   }
    // ],
  },
];
