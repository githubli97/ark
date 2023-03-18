// 接口类型声明

// 布局配置
export interface ThemeConfigState {
  themeConfig: {
    isDrawer: boolean;
    primary: string;
    success: string;
    info: string;
    warning: string;
    danger: string;
    topBar: string;
    menuBar: string;
    columnsMenuBar: string;
    topBarColor: string;
    menuBarColor: string;
    columnsMenuBarColor: string;
    isTopBarColorGradual: boolean;
    isMenuBarColorGradual: boolean;
    isColumnsMenuBarColorGradual: boolean;
    isMenuBarColorHighlight: boolean;
    isCollapse: boolean;
    isUniqueOpened: boolean;
    isFixedHeader: boolean;
    isFixedHeaderChange: boolean;
    isClassicSplitMenu: boolean;
    isLockScreen: boolean;
    lockScreenTime: number;
    isShowLogo: boolean;
    isShowLogoChange: boolean;
    isBreadcrumb: boolean;
    isTagsview: boolean;
    isBreadcrumbIcon: boolean;
    isTagsviewIcon: boolean;
    isCacheTagsView: boolean;
    isSortableTagsView: boolean;
    isShareTagsView: boolean;
    isFooter: boolean;
    isGrayscale: boolean;
    isInvert: boolean;
    isWartermark: boolean;
    wartermarkText: string;
    tagsStyle: string;
    animation: string;
    columnsAsideStyle: string;
    columnsAsideLayout: string;
    layout: string;
    isRequestRoutes: boolean;
    globalTitle: string;
    globalViceTitle: string;
    globalI18n: string;
    globalComponentSize: string;
  };
}
export interface ModuleInfo {
  id: string;
  name: string;
}

// app信息
export interface AppState {
  currentModule: ModuleInfo; // 当前选择系统
}
export interface UserState {
  userInfo: Record<string, any>;
  authMenu: Record<string, any>;
}
export interface RouterState {
  routesList: Array<any>;
  keepAliveNames: Array<string>;
  tagsViewRoutes: Array<any>;
  isTagsViewCurrenFull: boolean;
}

// 主接口(顶级类型声明)
export interface RootStateTypes {
  themeConfig: ThemeConfigState;
  router: RouterState;
  user: UserState;
}
