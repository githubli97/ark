package com.ark.base.config.mp;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 数据源配置
 * 基于druid连接池配置
 */
@Getter
@ConfigurationProperties(prefix = ArkMybatisPlusProperties.ARK_MYBATIS_PLUS)
public class ArkMybatisPlusProperties {
    public static final String ARK_MYBATIS_PLUS = "ark.mybatis-plus";

    private Boolean printSql;

    private GlobalConfig globalConfig;

    private MybatisConfiguration configuration;

    public ArkMybatisPlusProperties() {
        printSql = true;
        configuration = new MybatisConfiguration();

        globalConfig = new GlobalConfig();
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        globalConfig.setDbConfig(dbConfig);
        globalConfig.setMetaObjectHandler(new BaseFillHandler());
        dbConfig.setLogicDeleteField("isDeleted");
    }
}