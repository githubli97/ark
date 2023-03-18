// 区分打包环境
import { BASE_API_URL_DEV } from '/@/config/env';

const buildType = process.env.NODE_ENV; // 打包node环境
let BASE_API_URL; // api baseUrl

//
switch (buildType) {
  case 'test': // 测试环境打包命令 npm run build test
    BASE_API_URL = 'https://test-mdzy-api.mingdutech.cn/';
    break;
  default:
    BASE_API_URL = BASE_API_URL_DEV;
    break;
}

export const BASE_CONFIG = (function () {
  return isPrivate()
    ? window['goConfig']
    : {
        BASE_API_URL,
      };
})();
export function isProd() {
  return process.env.NODE_ENV === 'prod' && process.env.ENV === 'prod';
}

export function isTest() {
  return process.env.NODE_ENV === 'test' && process.env.ENV === 'test';
}
export function isDemo() {
  return process.env.NODE_ENV === 'demo' && process.env.ENV === 'demo';
}
export function isLocal() {
  return process.env.NODE_ENV === 'local';
}
export function isPrivate() {
  return process.env.NODE_ENV === 'private';
}
