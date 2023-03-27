package com.ark.infrastructure.config.mp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.ark.*.infrastucture.persistence.*.mapper")
public class ArkMybatisPlusAutoConfiguration {

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