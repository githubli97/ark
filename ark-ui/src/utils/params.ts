/**
 * 添加多个参数到指定 URL。
 */
export function setParams(oParams: any, sUrl: string = location.href, isEncodeURIComponent = false): string {
  const sUri = sUrl.split('?')[0];
  const oParamData = getParams(sUrl);

  // 合并。
  Object.assign(oParamData, oParams);
  // 重新转换回来。
  const sParams = objToParams(oParamData, isEncodeURIComponent);

  if (sParams) {
    return sUri + '?' + sParams;
  } else {
    return sUri;
  }
}
/**
 * 获取 URL 中所有参数信息。
 */
export function getParams(sUrl: string = location.href) {
  // 过滤后面的锚点   锚点有可能在在前面。

  if (sUrl.indexOf('?') < sUrl.indexOf('#')) {
    sUrl = sUrl.replace(/(\/)?#.*/g, '');
  }
  // 取出 ? 后面的参数串。
  sUrl = sUrl.split('?')[1] || '';

  const oParam: any = {};
  sUrl.split('&').forEach(function (sItem) {
    const asParam = sItem.split('=');
    if (asParam[0]) {
      oParam[asParam[0]] = decodeURIComponent(asParam[1]);
    }
  });

  return oParam;
}
/**
 * 将对象转换成 URL 参数，并对字符进行转义。
 *  @param isEncodeURIComponent 是否编码，默认不编码
 */

function objToParams(obj: any, isEncodeURIComponent = false) {
  let str = '';
  for (const key in obj) {
    if (str !== '') {
      str += '&';
    }
    str += key + '=' + (isEncodeURIComponent ? encodeURIComponent(obj[key]) : obj[key]);
  }
  return str;
}
