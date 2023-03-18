import { VueCookieNext } from 'vue-cookie-next';

export const KEY_USER_TOKEN = 'ARK_TOKEN';

const buildType = process.env.NODE_ENV;

export const COOKIE_KEY_USER_TOKEN = 'ARK_TOKEN' + buildType?.toUpperCase().replace(/\-/g, '_');;

export function getToken(): string {
  return VueCookieNext.getCookie(COOKIE_KEY_USER_TOKEN);
}
export function saveToken(token: string) {
  VueCookieNext.setCookie(COOKIE_KEY_USER_TOKEN, token);
}
export function deleteToken() {
  VueCookieNext.removeCookie(COOKIE_KEY_USER_TOKEN);
}
