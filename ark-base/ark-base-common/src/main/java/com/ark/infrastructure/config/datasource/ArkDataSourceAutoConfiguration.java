//package com.ark.infrastructure.config.datasource;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//
///**
// * 数据源配置
// * 基于druid连接池配置
// */
//@EnableConfigurationProperties({ArkDataSourceProperties.class})
//public class ArkDataSourceAutoConfiguration {
//    @Bean("druidDataSource") // 手工设置Bean名称
//    public DruidDataSource getArkDataSource(ArkDataSourceProperties properties) {
//        ArkDataSourceProperties.DruidPool druid = properties.getDruid();
//
//        DruidDataSource dataSource = new DruidDataSource(); // 实例化DataSource子类对象
//        dataSource.setDriverClassName(properties.getDriverClassName()); // 数据库驱动程序
//        dataSource.setUrl(properties.getUrl()); // 数据库的连接地址
//        dataSource.setUsername(properties.getUsername()); // 数据库用户名
//        dataSource.setPassword(properties.getPassword()); // 数据库密码
//
//        dataSource.setInitialSize(druid.getInitialSize()); // 连接池初始化大小
//        dataSource.setMinIdle(druid.getMinIdle()); // 最小维持的连接数量
//        dataSource.setMaxActive(druid.getMaxActive()); // 最大的连接数量
//        dataSource.setMaxWait(druid.getMaxWait()); // 最大等待时间
//        dataSource.setTimeBetweenEvictionRunsMillis(druid.getTimeBetweenEvictionRunsMillis()); // 检查的间隔时间
//        dataSource.setMinEvictableIdleTimeMillis(druid.getMinEvictableIdleTimeMillis()); // 存活时间
//        dataSource.setValidationQuery(druid.getValidationQuery()); // 验证SQL
//        dataSource.setTestWhileIdle(druid.isTestWhileIdle()); // 测试连接是否可用
//        dataSource.setTestOnBorrow(druid.isTestOnBorrow()); // 获取时检测
//        dataSource.setTestOnReturn(druid.isTestOnReturn()); // 归还时检测
//        dataSource.setPoolPreparedStatements(druid.isPoolPreparedStatements()); // 是否缓存PSTMT
//        dataSource.setMaxPoolPreparedStatementPerConnectionSize(druid.getMaxPoolPreparedStatementPerConnectionSize()); // 缓存个数
//
//        return dataSource;
//    }
//
//}