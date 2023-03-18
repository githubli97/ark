 /**
* @desc 函数节流
* @param func (function) 函数
* @param wait (number) 延迟执行毫秒数
*/
export default function throttle(func: Function, wait:number|undefined=500) {
  let previous = 0;
  return function() {
    let context = this;
    let args = arguments;
    let now = Date.now();
    if (now - previous > wait) {
      func.apply(context, args);
      previous = now;
    }
  }
}