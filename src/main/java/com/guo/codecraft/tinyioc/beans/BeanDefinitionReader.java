package com.guo.codecraft.tinyioc.beans;

/**
 * Created by guo on 3/1/2018.
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
