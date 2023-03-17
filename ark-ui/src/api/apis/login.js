/**
 * Created by WebStorm.
 * User: nirongxu
 * Date: 2020/4/15
 * Description: 文件描述
 */
import axios from "../axios"
import loginUrls from "../urls/login"
import qs from 'qs';

export default {
  // 账号密码登陆
  fetchLogin (data) {
    return axios({
      method: "post",
      url: loginUrls.login,
      headers: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      withCredentials: true,
      data: qs.stringify(data)
    })
  }
}
