package com.ark.generator.mp.main;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.function.Consumer;

public class ArkMPInfrastructureGenerator {
    public static final String INFRASTUCTURE_BASE_PACKAGE = "infrastucture.persistence";

    /**
     * 生成带防腐层service
     */
    public static void generatorInit(String moduleName, String domainName, Class repository) {
        // todo
        FastAutoGenerator.create("jdbc:mysql://mysql.ark.com:3308/ark", "root", "jXpullesLBc8hUdsei")
                .globalConfig(builder -> {
                    builder.author("lihang") // 设置作者
                            .fileOverride()
//                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("D:\\code\\ark\\ark-" + moduleName + "\\ark-" + moduleName + "-infrastructure\\src\\main\\java\\"); // 指定输出目录
                })
                .packageConfig(getPackageConfig(moduleName, domainName))
                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER)
                            .service("template/service.java")
                            .build();
                })

                .strategyConfig(getStrategyConfig(moduleName, domainName, repository))
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    /**
     * 更新PO中的字段
     * @param moduleName
     * @param domainName
     * @param repository
     */
    public static void generatorUpdatePO(String moduleName, String domainName, Class repository) {
        FastAutoGenerator.create("jdbc:mysql://mysql.ark.com:3308/ark", "root", "jXpullesLBc8hUdsei")
                .globalConfig(builder -> {
                    builder.author("lihang") // 设置作者
                            .fileOverride()
//                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("D:\\code\\ark\\ark-" + moduleName + "\\ark-" + moduleName + "-infrastructure\\src\\main\\java\\"); // 指定输出目录

                })
                .packageConfig(getPackageConfig(moduleName, domainName))
                .templateConfig(builder -> {
                    builder.disable(TemplateType.SERVICE)
                            .disable(TemplateType.CONTROLLER)
                            .disable(TemplateType.SERVICEIMPL)
                            .disable(TemplateType.MAPPER)
                            .disable(TemplateType.XML)
                            .build();
                })
                .strategyConfig(getStrategyConfig(moduleName, domainName, repository))
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    /**
     * 生成mapper和po
     */
    public static void generatorPOAndMapper(String moduleName, String domainName, Class repository) {
        FastAutoGenerator.create("jdbc:mysql://mysql.ark.com:3308/ark", "root", "jXpullesLBc8hUdsei")
                .globalConfig(builder -> {
                    builder.author("lihang") // 设置作者
                            .fileOverride()
//                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("D:\\code\\ark\\ark-" + moduleName + "\\ark-" + moduleName + "-infrastructure\\src\\main\\java\\"); // 指定输出目录

                })
                .packageConfig(getPackageConfig(moduleName, domainName))
                .templateConfig(builder -> {
                    builder.disable(TemplateType.SERVICE)
                            .disable(TemplateType.CONTROLLER)
                            .disable(TemplateType.SERVICEIMPL)
                            .build();
                })
                .strategyConfig(getStrategyConfig(moduleName, domainName, repository))
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }


    private static Consumer<GlobalConfig.Builder> getGlobalConfig(String moduleName) {
        return builder -> {
            builder.author("lihang") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                    .outputDir("D:\\code\\ark\\ark-" + moduleName + "\\ark-" + moduleName + "-infrastructure\\src\\main\\java\\"); // 指定输出目录
        };
    }

    private static Consumer<PackageConfig.Builder> getPackageConfig(String moduleName, String domainName) {
        return builder -> {
            builder.parent("com.ark." + moduleName + "." + INFRASTUCTURE_BASE_PACKAGE) // 设置父包名
                    .entity("model")
                    .service("repository")
                    .serviceImpl("repository.impl")
                    .moduleName(domainName); // 设置父包模块名;
        };
    }

    private static Consumer<StrategyConfig.Builder> getStrategyConfig(String moduleName, String domainName, Class repository) {
        return builder -> {
            builder
                    .addInclude("ark_" + moduleName + "_" + domainName) // 设置需要生成的表名
                    .addTablePrefix("ark_" + moduleName + "_")
                    .entityBuilder()
                    .superClass("com.ark.base.object.BaseDO")
                    .addIgnoreColumns("id", "is_deleted", "version")
                    .enableLombok()
                    .formatFileName("%sPO")
                    .serviceBuilder()
                    .superServiceClass(repository)
                    .superServiceImplClass("com.ark.base.service.ArkServiceImpl");
        };
    }
}
