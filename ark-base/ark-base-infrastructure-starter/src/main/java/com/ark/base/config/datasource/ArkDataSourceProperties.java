package com.ark.base.config.datasource;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 数据源配置
 * 基于druid连接池配置
 */
@Getter
@ConfigurationProperties(prefix = ArkDataSourceProperties.ARK_DATASOURCE_PREFIX)
public class ArkDataSourceProperties {
    public static final String ARK_DATASOURCE_PREFIX = "ark.datascource.druid";

    private String driverClassName = "com.mysql.cj.jdbc.Driver"; // 数据库驱动程序
    private String url = "jdbc:mysql://mysql.ark.com:3308/ark?autoReconnect=true&failOverReadOnly=false&useSSL=false"; // 数据库连接地址
    private String username = "root"; // 数据库的用户名
    private String password = "jXpullesLBc8hUdsei"; // 数据库的用户名

    private DruidPool druid = new DruidPool();

    @Getter
    public static class DruidPool {
        private int initialSize = 5; // 初始化连接数
        private int minIdle = 10; // 最小维持连接数
        private int maxActive = 50; // 最大连接数
        private long maxWait = 60000L; // 最长等待时间
        private long timeBetweenEvictionRunsMillis = 6000L; // 关闭空闲连接间隔
        private long minEvictableIdleTimeMillis = 30000L; // 最小存活时间
        private String validationQuery = "SELECT 1 FROM dual"; // 验证查询
        private boolean testWhileIdle = true; // 测试空闲连接是否可用
        private boolean testOnBorrow = false; // 测试后返回连接
        private boolean testOnReturn = false; // 测试后归还
        private boolean poolPreparedStatements = false; // 是否缓存PSTMT
        private int maxPoolPreparedStatementPerConnectionSize = 20; // PSTMT缓gen存个数
    }

}