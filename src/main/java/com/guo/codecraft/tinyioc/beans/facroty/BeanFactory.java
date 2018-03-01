package com.guo.codecraft.tinyioc.beans.facroty;

/**
 * Created by guo on 3/1/2018.
 * bean的容器，工厂
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
}
