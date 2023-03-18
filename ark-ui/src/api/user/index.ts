import { ajax } from '/@/config/request';
import {
  API_USER_LOGIN,
  API_USER_REGISTER,
  API_USER_getUserInfo,
  API_USER_getUserInfoId,
  API_USER_userList,
  API_USER_editPassword,
  API_USER_editUserInfo,
  API_USER_delUser
} from '/@/api/const/user-api';

/**
 * 用户登录
 * @param params
 */
export async function userLogin(params: any) {
  const res: any = await ajax.post(API_USER_LOGIN, params);
  return res;
}

/**
 * 获取当前用户信息
 * @param params
 */
export async function getUserInfo(params: any) {
  const res: any = await ajax.post(API_USER_getUserInfo, params);
  return res;
}

/**
 * 通过id获取用户信息
 * @param params
 */
export async function getUserInfoById(params: any) {
  const res: any = await ajax.post(API_USER_getUserInfoId, params);
  return res;
}

/**
 * 查询用户信息
 * @param params 要传的参数值
 * @returns 返回接口数据
 */
export async function userList(params: any) {
  const res: any = await ajax.get(API_USER_userList, params);
  return res;
}

/**
 * 新增用户信息
 * @param params 要传的参数值
 * @returns 返回接口数据
 */
export async function userAdd(params: any) {
  const res: any = await ajax.post(API_USER_REGISTER, params);
  return res;
}

/**
 * 修改用户信息
 * @param params 要传的参数值
 * @returns 返回接口数据
 */
export async function userEdit(params: any) {
  const res: any = await ajax.put(API_USER_editUserInfo, params);
  return res;
}

/**
 * 删除用户信息
 * @param params 要传的参数值
 * @returns 返回接口数据
 */
export async function userDelete(params: any) {
  const res: any = await ajax.del(API_USER_delUser, params);
  return res;
}



/**
 * 管理员重置密码
 */
export async function userReset(params: any) {
  const res: any = await ajax.post(API_USER_editPassword, params);
}
