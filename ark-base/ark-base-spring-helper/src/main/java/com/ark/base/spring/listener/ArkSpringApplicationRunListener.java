package com.ark.base.spring.listener;

import com.ark.base.spring.order.ArkPriorityOrderedFirstHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Classname ArkSpringApplicationRunListener
 * @Description TODO
 * @Date 2022/6/30 11:04
 * @Created by hang.li
 */
@Slf4j
public class ArkSpringApplicationRunListener implements SpringApplicationRunListener, ArkPriorityOrderedFirstHandle {

    private final SpringApplication application;

    private final String[] args;

    public ArkSpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        log.info("当 run 方法第一次启动时立即调用。 可用于非常早的初始化。");
        SpringApplicationRunListener.super.starting(bootstrapContext);
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        log.info("environment准备好，但在ApplicationContext被创建之前调用。");
        SpringApplicationRunListener.super.environmentPrepared(bootstrapContext, environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("在创建并准备好ApplicationContext ，但在加载源之前调用。");
        SpringApplicationRunListener.super.contextPrepared(context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("在加载应用程序上下文后但在刷新之前调用。");
        SpringApplicationRunListener.super.contextLoaded(context);
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("上下文已刷新且应用程序已启动，但尚未调用CommandLineRunners和ApplicationRunners 。");
        SpringApplicationRunListener.super.started(context);
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("在 run 方法完成之前立即调用，此时应用程序上下文已刷新并且所有CommandLineRunners和ApplicationRunners已被调用。");
        SpringApplicationRunListener.super.running(context);
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("在运行应用程序时发生故障时调用。");
        SpringApplicationRunListener.super.failed(context, exception);
    }
}
