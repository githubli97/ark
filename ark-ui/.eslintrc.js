// https://cn.eslint.org/docs/rules/
//
/*
 * "off"或者0，不启用这个规则
 * "warn"或者1，出现问题会有警告
 * "error"或者2，出现问题会报错
 */

module.exports = {
  root: true, // 此项是用来告诉eslint找当前配置文件不能往父级查找
  env: {
    // 环配置 如 "browser": true, node: true,
    node: true,
  },
  parserOptions: {
    parser: 'babel-eslint',
  },
  globals: {
    defineProps: true,
    defineExpose: true,
    defineEmits: true,
    DocsAPI: true,
  },
  extends: [
    // https://github.com/vuejs/eslint-plugin-vue#priority-a-essential-error-prevention
    // consider switching to `plugin:vue/strongly-recommended` or `plugin:vue/recommended` for stricter rules.
    'plugin:vue/essential',
    'eslint:recommended',
    '@vue/prettier',
  ],
  plugins: ['prettier'],
  rules: {
    'array-callback-return': 1, // return 后面是否允许省略
    'arrow-parens': ['error', 'as-needed'], // 箭头函数的参数可以不使用圆括号
    'consistent-return': 0, // 要求 return 语句要么总是指定返回的值，要么不指定
    camelcase: 0, // 强制驼峰法命名
    eqeqeq: 2, // 强制全等( === 和 !==)
    'func-names': 0, // 函数表达式必须有名字
    'global-require': 0, // 取消对require的验证，使得可以使用require来加载图片的相对路径
    'import/no-unresolved': 0, // 取消自动解析路径，以此开启alias的别名路径设置
    'import/extensions': 0, // 取消对文件扩展名的验证
    indent: 'off', // 缩进风格(强制使用一致的缩进)
    'linebreak-style': 0, // 取消换行符\n或\r\n的验证()
    'max-len': 0, // 字符串最大长度
    'no-unused-vars': 0, // 禁止出现未使用过的变量
    'no-redeclare': 0, // 禁止多次声明同一变量
    'no-use-before-define': 0, // 禁止在变量定义之前使用它们
    'no-unused-expressions': 0, // 允许使用未使用过的表达式，以此来支持a && a()的代码形式
    'no-restricted-syntax': 1, // 禁用特定的语法
    'no-plusplus': 0, // 禁止使用++，--
    'no-underscore-dangle': 0, // 允许在标识符中使用下划线
    'no-param-reassign': 0, // 禁止对 function 的参数进行重新赋值
    'no-nested-ternary': 0, // 禁止嵌套三元表达式
    'no-else-return': 0, // 禁止 if 语句中 return 语句之后有 else 块
    'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    'prefer-rest-params': 0, //  允许使用 arguments
    'prefer-arrow-callback': 0, // 要求回调函数使用箭头函数
    'prefer-const': 0, // 不要首选const
    'template-curly-spacing': 'off', // 要求或禁止模板字符串中的嵌入表达式周围空格的使用
    'vue/no-parsing-error': 0, // vue 没有关闭标签报错
    'vue/no-unused-components': 1, // vue 没有使用的组件
    'vue/no-reserved-keys': 0, // vue   可以使用 __  当为变量名
    'no-useless-escape': 0, // 是否允许使用转义字符
    'no-empty': 0, // 是否允许块内容为空
    'spaced-comment': 1, // 要求在注释前有空白,
    'no-multiple-empty-lines': [0, { max: 10 }], // ???  不允许多个空行
    'prettier/prettier': ['error', { endOfLine: 'auto' }], // 不符合 prettier 规则的代码，要进行错误提示（红线）
  },
  overrides: [
    {
      files: ['*.ts'],
      parser: '@typescript-eslint/parser',
      plugins: ['@typescript-eslint'],
      extends: ['plugin:@typescript-eslint/recommended'],
    },
  ],
};
