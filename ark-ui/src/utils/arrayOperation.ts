/**
 * 判断两数组是否相同
 * @param news 新数据
 * @param old 源数据
 * @returns 两数组相同返回 `true`，反之则反
 */
export function judementSameArr(news: Array<string | number>, old: Array<string | number>): boolean {
  let count = 0;
  const leng = old.length;
  for (const i in old) {
    for (const j in news) {
      if (old[i] === news[j]) count++;
    }
  }
  return count === leng ? true : false;
}

export function enqualsArray(leftArr: any, rightArr: any) {
  if (!leftArr || !rightArr) return false;
  if (leftArr.length !== rightArr.length) return false;
  for (let i = 0, l = leftArr.length; i < l; i++) {
    if (Array.isArray(leftArr[i]) && Array.isArray(rightArr[i])) {
      if (!enqualsArray(leftArr[i], rightArr[i])) return false;
    } else if (leftArr[i] !== rightArr[i]) {
      // Warning - two different object instances will never be equal: {x:20} != {x:20}
      return false;
    }
  }
  return true;
}
/**
 * 判断两个对象是否相同
 * @param a 要比较的对象一
 * @param b 要比较的对象二
 * @returns 相同返回 true，反之则反
 */
export function isObjectValueEqual(a: { [key: string]: any }, b: { [key: string]: any }) {
  if (!a || !b) return false;
  const aProps = Object.getOwnPropertyNames(a);
  const bProps = Object.getOwnPropertyNames(b);
  if (aProps.length !== bProps.length) return false;
  for (let i = 0; i < aProps.length; i++) {
    const propName = aProps[i];
    const propA = a[propName];
    const propB = b[propName];
    if (!b.hasOwnProperty(propName)) return false;
    if (propA instanceof Object) {
      if (!isObjectValueEqual(propA, propB)) return false;
    } else if (propA !== propB) {
      return false;
    }
  }
  return true;
}
