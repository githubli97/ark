import { createI18n } from 'vue-i18n';
import zhcnLocale from 'element-plus/lib/locale/lang/zh-cn';
import enLocale from 'element-plus/lib/locale/lang/en';

import nextZhcn from '/@/i18n/lang/zh-cn';
import nextEn from '/@/i18n/lang/en';

// 定义语言国际化内容
/**
 * 说明：
 * /src/i18n/lang 下的 ts 为框架的国际化内容
 * /src/i18n/pages 下的 ts 为各界面的国际化内容
 */
const messages = {
  [zhcnLocale.name]: {
    ...zhcnLocale,
    message: {
      ...nextZhcn,
    },
  },
  [enLocale.name]: {
    ...enLocale,
    message: {
      ...nextEn,
    },
  },
};

// 导出语言国际化
export const i18n = createI18n({
  locale: 'zh-cn',
  fallbackLocale: zhcnLocale.name,
  messages,
});
