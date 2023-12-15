package com.ark.core.common.spring;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取ApplicationContext工具类.
 *
 * @Classname ArkApplicationContextAware
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@Slf4j
@Component
public class ArkApplicationContextAware implements ApplicationContextAware {

  static volatile ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(@NotNull ApplicationContext applicationContext)
      throws BeansException {
    log.info("织入applicationContext");
    ArkApplicationContextAware.applicationContext = applicationContext;
  }
}
