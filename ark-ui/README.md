## 开发使用
### 1. 开发
```
# 推荐使用 yarn, 安装依赖基本上一次过,npm 经常会卡在node-sass,如果npm安装node-sass 失败,单独多安装几次应该就可以了: npm i node-sass -D

# 设置淘宝镜像
yarn config set registry https://registry.npm.taobao.org/
or
npm config set registry https://registry.npm.taobao.org

# 安装依赖 (如果安装失败就多安装几次，实在不行就换淘宝镜像)
yarn  or  yarn install
or
npm install

# 启动项目 (已经配置好启动服务自动打开浏览器，如果没自动打开按照控制台输出的地址自己打开)
# 如果eslint语法检查报错，直接关掉eslint语法检查
yarn dev
or
npm run dev

# 启动单元测试
yarn  unit
or
npm run unit

# 启动端到端测试
yarn e2e
or
 npm run e2e

# 启动编译打包 生产环境
yarn build
or
 npm run build

# 启动编译打包 并生成打包结果 生产环境
yarn analyz
or
npm run analyz

# 抽取分离公共依赖
yarn startdll
or
npm run startdll
```

## 2. 项目结构说明
```
|------------build          构建脚本目录

    |---------build.js             生产环境构建脚本

    |---------check-version.js 检查node、npm等版本

    |---------dev-client.js     开发服务器热重载脚本，主要用来实现开发阶段的页面自动刷新

    |---------dev-server.js     运行本地开发服务器

    |---------utils.js               构建相关工具方法

    |---------vebpack.base.conf.js     webpack基本配置

    |---------vebpack.dev.conf.js       webpack开发环境配置

    |---------vebpack.prod.conf.js     webpack生产环境配置   

|------------config           项目配置

    |---------dev.env.js           开发环境变量

    |---------index.js              项目配置文件

    |---------prod.env.js         生产环境变量

|------------dist             使用生产环境配置构建项目，构建好的目录放到该目录

|------------node_modules         node的依赖包

|------------src
    |---------api                 封装了 axios

    |---------assets                 资源目录，这里的资源会被webpack构建

    |---------components        		组件目录

    |---------directive        		    自定义指令

    |---------i18n					        多语言国际化

    |---------router

    |-----------index.js               前端路由

    |---------utils					全局方法和工具函数

    |---------views					页面文件

    |---------vuex					全局状态管理目录

    |--------App.vue                	根组件

    |--------main.js                 入口js文件

    |--------markData.js                 markdown 初始数据

|------------static             纯静态资源，不会被webpack构建

|------------index.html         入口页面

|------------test        		单元测试

|------------.babelrc            ES6语法编译配置

|-----------.editorconfig      	定义代码格式

|-----------.gitignore         	git 上传需要忽略的文件

|-----------package.json       项目基本信息

---------------------
```

# 3. fork by
https://github.com/xuxuxu-ni/vue-xuAdmin
