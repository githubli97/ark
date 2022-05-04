package com.ark.generator.mp.main;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class ArkMPInfrastructureGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://mysql.daydayup.com:3308/daydayup", "root", "jXpullesLBc8hUdsei")
                .globalConfig(builder -> {
                    builder.author("lihang") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("D:\\code\\daydayup\\user-center\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.ark.infrastucture") // 设置父包名
                            .entity("do")
                            .serviceImpl("repository")
                            .moduleName("account"); // 设置父包模块名;
                })
                .strategyConfig(builder -> {
                    builder
                            .addInclude("ark_identify_account") // 设置需要生成的表名
                            .entityBuilder()
                            .enableLombok()
                            .superClass("com.daydayup.base.entity.CrudTemplateBase")
                            .addIgnoreColumns("id", "creater", "create_time", "modifier", "modify_time", "is_deleted", "version")
                            .serviceBuilder()
                            .formatServiceImplFileName("%sRepositoryImpl")
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
