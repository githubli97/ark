import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import { store, key } from './store';
import { directive } from '/@/utils/directive';
import { i18n } from '/@/i18n/index';
import { globalComponentSize } from '/@/utils/componentSize';
import ElementPlus from 'element-plus';
import 'element-plus/lib/theme-chalk/index.css';
import '/@/theme/index.scss';
import mitt from 'mitt';
import screenShort from 'vue-web-screen-shot';
import VueGridLayout from 'vue-grid-layout';
import { VueCookieNext } from 'vue-cookie-next';
import ARKComponents from '/@/components/register';
import * as echarts from 'echarts'; // 引入echarts

const app = createApp(App);
app
  .use(router)
  .use(store, key)
  .use(ElementPlus, { i18n: i18n.global.t, size: globalComponentSize })
  .use(i18n)
  .use(screenShort, { enableWebRtc: false })
  .use(VueGridLayout)
  .use(VueCookieNext)
  .use(ARKComponents)
  .mount('#app');

VueCookieNext.config({ expire: '7d' });

app.config.globalProperties.mittBus = mitt();
app.config.errorHandler = function (err, instance, info) {
  console.log(`err === ${err}`);
};
app.config.globalProperties.$echarts = echarts; // 全局使用
directive(app);
