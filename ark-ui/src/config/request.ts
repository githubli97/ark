import axios from 'axios';
import { ElMessage } from 'element-plus';
import { saveToken, getToken, KEY_USER_TOKEN } from '/@/config/cookies';
import { BASE_CONFIG } from '../../env.process';
import { i18n } from '/@/i18n/index';
import { store } from '/@/store';
const ARK_RESPONSE_HEADER_TOKEN_KEY = 'ark-token';
//获取rest api相关
function getRestPromise(url: string, params: object, method: string) {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios[method](url, params).then(async (response: any) => {
      if (response && response.code === 0 && response.success) {
        resolve(response.data);
      }  else if (response && response.code === 403) {
        await store.dispatch('user/userLogout');
      } else {
        // todo 为了自定义返回值，后期要改掉
        let message = i18n.global.t(`message.response.${response.resultMessage}`);
        message = message.replace('message.response.', '')
        ElMessage.error(
          response?.resultMessage ? message : 'api report error'
        );
        reject('api report error');
      }
    });
  });
}

// 添加请求拦截器
axios.interceptors.request.use(
  (request) => {
    let token = getToken();
    if (token) {
      request.headers[KEY_USER_TOKEN] = token;
    }
    request.baseURL = BASE_CONFIG.BASE_API_URL;
    // request.timeout = 80000;
    return request;
  },
  (err) => {
    return Promise.reject(err);
  }
);
function updateToken(token: string){
  saveToken(token)
}
// 添加响应拦截器
axios.interceptors.response.use(
  (response) => {
    if(Object.keys(response.headers).includes(ARK_RESPONSE_HEADER_TOKEN_KEY)){
      updateToken(response.headers[ARK_RESPONSE_HEADER_TOKEN_KEY])
    }
    // 对响应数据做点什么
    return response.data;
  },
  (error) => {
    // 对响应错误做点什么
    // if (error.message.indexOf('timeout') != -1) {
    //   ElMessage.error('网络超时');
    // } else if (error.message == 'Network Error') {
    //   ElMessage.error('网络连接错误');
    // } else {
    //   if (error.response.data) ElMessage.error(error.response.statusText);
    //   else ElMessage.error('接口路径找不到');
    // }
    // return Promise.reject(error);
  }
);

const get = function (url: string, params: object) {
  return getRestPromise(url, { params: params }, 'get');
};
const del = function (url: string, params: object) {
  return getRestPromise(url, { params: params }, 'delete');
};
const post = function (url: string, params: object) {
  return getRestPromise(url, params, 'post');
};
const put = function (url: string, params: object) {
  return getRestPromise(url, params, 'put');
};

// 导出 axios 实例
export const ajax = {
  get: get,
  del: del,
  post: post,
  put: put,
};
