import { RouteRecordRaw } from 'vue-router';
import {homeRoutes} from "/@/router/home";

/**
 * 路由meta对象参数说明
 * meta: {
 *      title:          菜单栏及 tagsView 栏、菜单搜索名称（国际化）
 *      isLink：        是否超链接菜单，开启外链条件，`1、isLink:true 2、链接地址不为空`
 *      isKeepAlive：   是否缓存组件状态
 *      isIframe：      是否内嵌窗口，，开启条件，`1、isIframe:true 2、链接地址不为空`
 *      icon：          菜单、tagsView 图标，阿里：加 `iconfont xxx`，fontawesome：加 `fa xxx`
 *      code:           路由code,与后端匹配是否展示
 * }
 */
function envRoutes() {
  const allRoutes: any = {
    homeRoutes: homeRoutes,
  };

  const fmtRoutes: any = [];
  Object.keys(allRoutes).forEach((key: string) => {
    fmtRoutes.push(...allRoutes[key]);
  });
  return fmtRoutes;
}
export const dynamicArkRoutes = () => {
  return [
    {
      path: '/',
      name: '/',
      component: () => import('/@/layout/index.vue'),
      redirect: '/home',
      meta: {
        isKeepAlive: true,
      },
      children: envRoutes()
    },
  ];
};
