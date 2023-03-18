const hexMap = [
  { key: 0, val: '0000' },
  { key: 1, val: '0001' },
  { key: 2, val: '0010' },
  { key: 3, val: '0011' },
  { key: 4, val: '0100' },
  { key: 5, val: '0101' },
  { key: 6, val: '0110' },
  { key: 7, val: '0111' },
  { key: 8, val: '1000' },
  { key: 9, val: '1001' },
  { key: 'a', val: '1010' },
  { key: 'b', val: '1011' },
  { key: 'c', val: '1100' },
  { key: 'd', val: '1101' },
  { key: 'e', val: '1110' },
  { key: 'f', val: '1111' },
];

/**
 *  十六进制转二进制
 * @param str
 * @returns
 */
export function hexToBin(str: string) {
  str = str.toLocaleLowerCase();
  let value = '';
  for (let i = 0; i < str.length; i++) {
    for (const item of hexMap) {
      if (str.charAt(i) === item.key.toString()) {
        value = value.concat(item.val);
        break;
      }
    }
  }
  return value;
}

/**
 * 二进制转16进制
 * @param str
 * @returns
 */
export function binToHex(str: string) {
  let value = '';
  const list: Array<string> = [];
  if (str.length % 4 !== 0) {
    const a = '0000';
    const b: string = a.substring(0, 4 - (str.length % 4));
    str = b.concat(str);
  }
  while (str.length > 4) {
    list.push(str.substring(0, 4));
    str = str.substring(4);
  }
  list.push(str);
  for (let i = 0; i < list.length; i++) {
    for (const item of hexMap) {
      if (list[i] === item.val) {
        value = value.concat(item.key.toString());
        break;
      }
    }
  }
  return value;
}

/**
 * 指定位置补1
 * @param posIndex
 * @param len
 * @returns
 */
export function numPositionFill(posIndex: Array<number>, len) {
  if (!len || !posIndex.length) {
    throw '填充的长度必须大于0';
  }
  const numArr: Array<number> = new Array(len).fill(0);
  for (let i = 0; i < len; i++) {
    for (let j = 0; j < posIndex.length; j++) {
      if (+posIndex[j] === i) {
        numArr[i] = 1;
      }
    }
  }
  return numArr
    .reverse()
    .join('')
    .replace(/\b(0+)/gi, '');
}

/**
 * 获取为1的索引值
 * @param value
 * @param len
 * @returns
 */
export function findNumPositionIndex(value: string, len: number) {
  const fmtValue = value.toString().padStart(len, '0');
  const sourceList = fmtValue.split('').reverse();
  const numArr = [];
  for (let i = 0; i < sourceList.length; i++) {
    if (+sourceList[i] === 1) {
      numArr.push(i);
    }
  }
  return numArr;
}
