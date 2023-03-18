export const nodeEnv: any = process.env.NODE_ENV;

// 私有部署环境判断
export const isPrivateEnv = ['private'].includes(nodeEnv);
// 开发环境判断
export const isDevEnv = ['development'].includes(nodeEnv);
// 测试环境判断
export const isTestEnv = ['test'].includes(nodeEnv);
//demo
export const isDemoEnv = ['demo'].includes(nodeEnv);
