package com.ark.base.config.mp;

import com.alibaba.druid.pool.DruidDataSource;
import com.ark.base.config.datasource.ArkDataSourceAutoConfiguration;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 数据源配置
 * 基于druid连接池配置
 */
@Slf4j
@Configuration
@AutoConfigureAfter(ArkDataSourceAutoConfiguration.class)
@EnableConfigurationProperties(ArkMybatisPlusProperties.class)
@MapperScan("com.ark.*.infrastucture.persistence.*.mapper")
public class ArkMybatisPlusAutoConfiguration {

    /**
     * 通用配置
     */
    @Bean
    public MybatisSqlSessionFactoryBean getMybatisSqlSessionFactoryBean(@Autowired DruidDataSource druidDataSource, ArkMybatisPlusProperties properties) {
        MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
        mybatisPlus.setDataSource(druidDataSource); // 配置项目中要使用的数据源
        mybatisPlus.setVfs(SpringBootVFS.class); // 配置程序的扫描类

        mybatisPlus.setPlugins(getMybatisPlusInterceptor()); // 设置分页拦截器
        mybatisPlus.setConfiguration(properties.getConfiguration());

        if (properties.getPrintSql()) {
            try {
                properties.getConfiguration().setLogImpl((Class<? extends Log>) Class.forName("org.apache.ibatis.logging.stdout.StdOutImpl"));
            } catch (ClassNotFoundException e) {
                log.warn("打印sql日志实现类加载失败。");
            }

        }

        mybatisPlus.setGlobalConfig(properties.getGlobalConfig());
        return mybatisPlus;
    }

    /**
     * 分页
     */
    public MybatisPlusInterceptor getMybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor page = new PaginationInnerInterceptor(DbType.MYSQL);
        page.setOverflow(true); // 设置覆盖

        interceptor.addInnerInterceptor(page); // 使用MySQL分页实现
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor()); //乐观锁

        return interceptor;
    }

    /**
     * MyBatis 字段值自动填充
     */
    @Bean
    @ConditionalOnClass(ArkMybatisPlusAutoConfiguration.class)
    public MetaObjectHandler myMeatObjectHandler() {
        return new BaseFillHandler();
    }
}