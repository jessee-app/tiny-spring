package com.guo.codecraft.tinyioc.beans;

/**
 * Created by guo on 3/1/2018.
 * 初始化前后处理器
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
