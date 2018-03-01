package com.guo.codecraft.tinyioc.aop;

import com.guo.codecraft.tinyioc.beans.facroty.BeanFactory;

/**
 * Created by guo on 3/1/2018.
 * 设置bean工厂
 */
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
