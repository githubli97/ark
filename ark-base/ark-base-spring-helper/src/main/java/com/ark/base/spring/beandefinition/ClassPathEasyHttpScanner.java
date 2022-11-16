package com.ark.base.spring.beandefinition;

import com.ark.base.spring.beandefinition.easyhttp.EasyHttpFactoryBean;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ClassPathEasyHttpScanner
 * @Description TODO
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@Slf4j
public class ClassPathEasyHttpScanner extends ClassPathBeanDefinitionScanner {
    public static OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectTimeout(200, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .build();

    public ClassPathEasyHttpScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        processBeanDefinitions(beanDefinitionHolders);
        return beanDefinitionHolders;
    }
    private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions) {
        AbstractBeanDefinition definition;
        BeanDefinitionRegistry registry = getRegistry();
        for (BeanDefinitionHolder holder : beanDefinitions) {
            definition = (AbstractBeanDefinition) holder.getBeanDefinition();

            String beanClassName = definition.getBeanClassName();
            definition.getConstructorArgumentValues().addGenericArgumentValue(beanClassName); // issue #59
            definition.getPropertyValues().add("httpClient", httpClient);

            definition.setBeanClass(EasyHttpFactoryBean.class);
        }
    }
}
